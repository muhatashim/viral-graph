## Readme ##

This is a work-in-progress library for Java that allows for computations in Java to be expressed inside nodes that can be arbitrarily placed anywhere in a graph. This idea comes from Google library, Tensorflow, but using a different approach in order to allow writing more complex computational graphs in Java.

Here are some examples with using library:

#### Simple Addition: ####

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

#### Multithreading: ####

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