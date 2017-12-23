package org.ls.viralgraph;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: Muhatashim
 * Date: 12/23/2017
 * Time: 10:48 AM
 */
public interface ConditionalNode<I, O> extends Node<I, Optional<O>> {

    boolean validate();
}
