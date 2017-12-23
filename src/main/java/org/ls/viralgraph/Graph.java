package org.ls.viralgraph;

import java.util.IdentityHashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 10:45 AM
 */
public class Graph {

    private IdentityHashMap<Node<?, ?>, List<Node>> nodes;

    public Graph(IdentityHashMap<Node<?, ?>, List<Node>> nodes) {
        this.nodes = nodes;
    }

    public GraphBuilder graphBuilder() {
        return new GraphBuilder();
    }

    public void fire(Node<?, ?> node) {
        fire(node, null);
    }

    public <I> void fire(Node<I, ?> node, I param) {
        Object output = node.run(param);
        List<Node> childNodes = this.nodes.get(node);

        if (childNodes != null)
            fire(childNodes, output);
    }


    public void fire(List<Node> children, Object param) {
        if (children == null) {
            return;
        }
        
        children.parallelStream().forEach(iNode -> fire(nodes.get(iNode), iNode.run(param)));
    }
}
