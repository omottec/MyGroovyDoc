package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Composition
 */

def plus2 = { it + 2 }
def time3 = { it * 3 }

def time3plus2 = plus2 << time3
assert time3plus2(3) == 11
assert time3plus2(4) == plus2(time3(4))

def plus2time3 = time3 << plus2
assert plus2time3(3) == 15
assert plus2time3(5) == time3(plus2(5))

// reverse composition
assert time3plus2(3) == (time3 >> plus2)(3)
