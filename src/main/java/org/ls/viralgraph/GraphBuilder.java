package org.ls.viralgraph;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 11:05 AM
 */
public class GraphBuilder {

    private IdentityHashMap<Node<?, ?>, List<Node>> nodes;

    public GraphBuilder() {
        nodes = new IdentityHashMap<>();
    }

    public <I, O> GraphBuilder node(Node<I, O> node) {
        nodes.put(node, null);
        return this;
    }

    public <I, J, K> GraphBuilder edge(Edge<I, J, K> edge) {
        List<Node> edgeOutputs = null;
        if (nodes.get(edge.getInput()) != null) {
            edgeOutputs = nodes.get(edge.getInput());
        } else {
            edgeOutputs = new ArrayList<>();
            this.nodes.put(edge.getInput(), edgeOutputs);
        }

        edgeOutputs.add(edge.getOutput());
        return this;
    }

    public <J> GraphBuilder edge(Node<?, J> node, Node<J, ?> node1) {
        edge(new EdgeBuilder<J>().input(node).output(node1).build());
        return this;
    }

    public Graph build() {
        return new Graph(nodes);
    }
}
