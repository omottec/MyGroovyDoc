package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Owner of a closure
 */

class Enclosing1 {
    void run() {
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod() == this
        def whatIsOwner = { owner }
        assert whatIsOwner() == this
    }
}

class EnclosedInInnerClass1 {
    class Inner {
        Closure cl = { owner }
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}

class NestedClosures1 {
    void run() {
        def nestedClosures = {
            def cl = { owner }
            cl()
        }
        assert nestedClosures() == nestedClosures
    }
}