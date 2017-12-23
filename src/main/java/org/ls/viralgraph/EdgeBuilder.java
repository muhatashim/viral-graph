package org.ls.viralgraph;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 11:06 AM
 */
public class EdgeBuilder<I> {

    private Node<?, I> input;
    private Node<I, ?> output;

    public EdgeBuilder<I> input(Node<?, I> inputType) {
        this.input = inputType;
        return this;
    }

    public EdgeBuilder<I> output(Node<I, ?> outputType) {
        this.output = outputType;
        return this;
    }

    public Edge<?, I, ?> build() {
        return new Edge<>(input, output);
    }
}
