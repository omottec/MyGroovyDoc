/**
 * Created by qinbingbing on 11/9/16.
 * Closures in GStrings
 */

def x = 1
def gs = "x = ${x}"
assert gs == 'x = 1'
x = 2
//assert gs == 'x = 2' // Assertion failed

x = 1
gs = "x = ${ -> x }"
assert gs == 'x = 1'
x = 2
assert gs == 'x = 2'


class Person {
    String name
    String toString() { name }
}
def james = new Person(name: 'James')
def jason = new Person(name: 'Jason')
def p = james
gs = "Name: ${ p }"
assert gs == 'Name: James'
p = jason
assert gs == 'Name: James'
james.name = 'Jason'
assert gs == 'Name: Jason'


james = new Person(name: 'James')
p = james
// Create a GString with lazy evaluation of "p"
gs = "Name: ${ -> p}"
assert gs == 'Name: James'
p = jason
assert gs == 'Name: Jason'