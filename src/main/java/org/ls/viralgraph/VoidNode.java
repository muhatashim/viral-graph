package org.ls.viralgraph;

import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 12:38 PM
 */
public interface VoidNode<I> extends Node<I,Void>, Consumer<I> {
    @Override
    default Void run(I input){
        accept(input);
        return null;
    }
}
