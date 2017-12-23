package org.ls.viralgraph;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 11:15 AM
 */
public class GraphTest {

    @Test
    public void testSimpleAddition() throws Exception {
        Node<Integer, Integer> startNode = param -> param;
        Node<Integer, Integer> plus2 = param -> param + 2;
        Node<Integer, String> resultConverter = param -> "The result is: " + param;
        VoidNode<String> voidNode = System.out::println;

        Graph graph = new GraphBuilder()
                .edge(startNode, plus2)
                .edge(plus2, resultConverter)
                .edge(resultConverter, voidNode)
                .build();

        graph.fire(startNode, 1);
    }

    @Test
    public void testSimpleMultithreading() throws Exception {
        Node<Integer[], Integer[]> startNode = param -> param;
        VoidNode<Integer[]> printNumbersForSomeReason = param -> IntStream.range(param[0], param[1]).forEach(System.out::println);
        VoidNode<Integer[]> printNumbersForSomeReason2 = param -> IntStream.range(param[0], param[1]).forEach(System.out::println);

        Graph graph = new GraphBuilder()
                .edge(startNode, printNumbersForSomeReason)
                .edge(startNode, printNumbersForSomeReason2)
                .build();

        graph.fire(startNode, new Integer[]{0, 1000});
    }
}