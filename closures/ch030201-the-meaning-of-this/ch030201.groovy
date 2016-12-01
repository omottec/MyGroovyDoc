/**
 * Created by qinbingbing on 12/1/16.
 */

class Enclosing {
    void run() {
        def whatIsThisObject = { getThisObject() }
        assert whatIsThisObject() == this
        def whatIsThis = { this }
        assert whatIsThis() == this
    }
}

new Enclosing().run()

class EnclosedInInnerClass {
    class Inner {
        Closure cl = { this }
    }

    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}

new EnclosedInInnerClass().run()

class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { this }
            cl()
        }
        assert nestedClosures() == this
    }
}

new NestedClosures().run()

class Person {
    String name
    int age

    @Override
    String toString() {
        "$name is $age years old"
    }

    String dump() {
        def cl = {
            String msg = this.toString()
            println msg
            msg
        }
        cl()
    }
}

def p = new Person(name: 'Daniel', age: 74)
assert p.dump() == 'Daniel is 74 years old'