package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Delegation strategy
 */

class Person2 {
    String name
}
def p = new Person2(name: 'Igor')
def cl = { name.toUpperCase() }
cl.delegate = p
assert cl() == 'IGOR'


class Person3 {
    String name
    def pretty = { "My name is $name" }
    String toString() {
        pretty()
    }
}

class Thing3 {
    String name
}

def p3 = new Person3(name: 'Sarah')
def t3 = new Thing3(name: 'Teapot')

assert p3.toString() == 'My name is Sarah'
//p3.pretty.resolveStrategy = Closure.DELEGATE_FIRST
p3.pretty.delegate = t3
assert p3.toString() == 'My name is Sarah'

class Person4 {
    String name
    int age
    def fetchAge = { age }
}

class Thing4 {
    String name
}

def p4 = new Person4(name: 'Jessica', age: 42)
def t4 = new Thing4(name: 'Printer')
def cl4 = p4.fetchAge
cl4.delegate = p4
assert cl4() == 42
cl4.delegate = t4
assert cl4() == 42
cl4.resolveStrategy = Closure.DELEGATE_ONLY
cl4.delegate = p4
assert cl4() == 42
cl4.delegate = t4
try {
    cl4()
    assert false
} catch (MissingPropertyException ex) {
    println 'age is not defined on the delegate'
}