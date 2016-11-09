package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Left currying
 */

def nCopies = { int n, String str -> str*n }
def twice = nCopies.curry(2)
assert twice('bla') == 'blabla'
assert twice('bla') == nCopies(2, 'bla')

