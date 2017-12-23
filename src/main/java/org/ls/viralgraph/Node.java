package org.ls.viralgraph;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 10:46 AM
 */
public interface Node<I, O> {

    O run(I input);
}
