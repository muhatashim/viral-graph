package org.ls.viralgraph;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 11:06 AM
 */
public class Edge<I, J, K> {

    private Node<I, J> input;
    private Node<J, K> output;

    public Edge(Node<I, J> input, Node<J, K> output) {
        this.input = input;
        this.output = output;
    }

    public Node<J, K> getOutput() {
        return output;
    }

    public void setOutput(Node<J, K> output) {
        this.output = output;
    }

    public Node<I, J> getInput() {
        return input;
    }

    public void setInput(Node<I, J> input) {
        this.input = input;
    }
}
