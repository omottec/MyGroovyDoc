package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Right currying
 */

def nCopies = { int n, String str -> str*n }
def blah = nCopies.rcurry('bla')
assert blah(2) == 'blabla'
assert blah(2) == nCopies(2, 'bla')
