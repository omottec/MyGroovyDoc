package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Closures in GStrings
 */

def x = 1
def gs = "x = ${x}"
assert gs == 'x = 1'
x = 2
//assert gs == 'x = 2' // Assertion failed

def x1 = 1
def gs1 = "x1 = ${ -> x1 }"
assert gs1 == 'x1 = 1'
x1 = 2
assert gs1 == 'x1 = 2'


class Person5 {
    String name
    String toString() { name }
}
def sam5 = new Person5(name: 'Sam')
def lucy5 = new Person5(name: 'Lucy')
def p5 = sam5
def gs5 = "Name: ${p5}"
assert gs5 == 'Name: Sam'
p5 = lucy5
assert gs5 == 'Name: Sam'
sam5.name = 'Lucy'
assert gs5 == 'Name: Lucy'


class Person6 {
    String name
    String toString() { name }
}
def sam6 = new Person6(name: 'Sam')
def lucy6 = new Person6(name: 'Lucy')
def p6 = sam6
// Create a GString with lazy evaluation of "p"
def gs6 = "Name: ${-> p6}"
assert gs6 == 'Name: Sam'
p6 = lucy6
assert gs6 == 'Name: Lucy'