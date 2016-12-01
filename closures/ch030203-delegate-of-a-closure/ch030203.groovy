/**
 * Created by qinbingbing on 12/1/16.
 */

class Enclosing {
    void run() {
        def cl = { getDelegate() }
        def cl2 = { delegate }
        assert cl() == cl2()
        assert cl() == this
        def enclosed = {
            { -> delegate }.call()
        }
        assert enclosed() == enclosed
    }
}

new Enclosing().run()

class Person {
    String name
}

class Thing {
    String name
}

def p = new Person(name: 'Daniel')
def t = new Thing(name: 'bottle')

def upperCaseName = { delegate.name.toUpperCase() }

upperCaseName.delegate = p
assert upperCaseName() == 'DANIEL'
upperCaseName.delegate = t
assert upperCaseName() == 'BOTTLE'

def target = p
def upperCaseNameUsingVar = { target.name.toUpperCase() }
assert upperCaseNameUsingVar() == 'DANIEL'
target = t
assert upperCaseNameUsingVar() == 'BOTTLE'