/**
 * Created by qinbingbing on 12/1/16.
 */

class Enclosing {
    void run() {
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod() == this
        def whatIsOwner = { owner }
        assert whatIsOwner() == this
    }
}
new Enclosing().run()

class EnclosedInnerClass {
    class Inner {
        Closure cl = { owner }
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}
new EnclosedInnerClass().run()

class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { owner }
            cl()
        }
        assert nestedClosures() == nestedClosures
    }
}
new NestedClosures().run()