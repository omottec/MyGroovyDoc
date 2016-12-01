/**
 * Created by qinbingbing on 11/9/16.
 * Calling a closure
 */

def code = { 123 }
assert code() == 123
assert code.call() == 123

def isOdd = { int i -> i % 2 == 1 }
assert isOdd(3) == true
assert isOdd.call(2) == false

def isEven = { it % 2 == 0 }
assert isEven(3) == false
assert isEven.call(2) == true