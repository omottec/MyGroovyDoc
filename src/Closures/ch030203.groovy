package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Delegate of a closure
 */

class Enclosing2 {
    void run() {
        def c1 = { getDelegate() }
        def cl1 = { delegate }
        assert cl() == cl1()
        assert cl() == this
        def enclosed = {
            { -> delegate }.call()
        }
        assert enclosed() == enclosed
    }
}

class Person1 {
    String name
}

class Thing {
    String name
}

def p = new Person1(name: 'Norman')
def t = new Thing(name: 'Teapot')

def upperCasedName = { delegate.name.toUpperCase() }

upperCasedName.delegate = p
assert upperCasedName() == 'NORMAN'
upperCasedName.delegate = t
assert upperCasedName() == 'TEAPOT'

