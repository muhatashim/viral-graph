package org.ls.viralgraph;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 11:15 AM
 */
public class GraphTest {

    @Test
    public void testGraph() throws Exception {

        Node<?, Integer> const1 = param -> 1;
        Node<Integer, Integer> plus2 = param -> param + 2;
        Node<Integer, String> resultConverter = param -> "The result is: " + param;
        VoidNode<String> voidNode = System.out::println;

        Graph graph = new GraphBuilder()
                .edge(const1,plus2)
                .edge(plus2,resultConverter)
                .edge(resultConverter,voidNode)
                .build();

        graph.fire(const1);
    }
}