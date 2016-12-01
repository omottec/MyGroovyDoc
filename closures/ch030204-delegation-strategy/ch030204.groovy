/**
 * Created by qinbingbing on 12/1/16.
 */

class Person {
    String name
    def pretty = { "My name is $name" }
    int age

    def fetchAge = { age }

    @Override
    String toString() {
        pretty()
    }
}
def p = new Person(name: 'Daniel')
def cl = { name.toUpperCase() }
cl.delegate = p
assert cl() == 'DANIEL'


class Thing {
    String name
}

def t = new Thing(name: 'Bottle')
assert p.toString() == 'My name is Daniel'
p.pretty.delegate = t
assert p.toString() == 'My name is Daniel'
p.pretty.resolveStrategy = Closure.DELEGATE_FIRST
assert p.toString() == 'My name is Bottle'


p = new Person(name: 'Jason', age: 27)
t = new Thing(name: 'Gun')
cl = p.fetchAge
cl.delegate = p
assert cl() == 27
cl.delegate == t
assert cl() == 27
cl.resolveStrategy = Closure.DELEGATE_ONLY
cl.delegate = p
assert cl() == 27
cl.delegate = t
try {
    cl()
    assert false
} catch (MissingPropertyException ex) {
    // "age" is not defined on the delegate
}