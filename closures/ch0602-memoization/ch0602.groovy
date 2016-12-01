/**
 * Created by qinbingbing on 11/9/16.
 * Memoization
 */

def fib
fib = { long n -> n < 2 ? n : fib(n-1) + fib(n-2) }
assert fib(15) == 610 // slow!

fib = { long n -> n < 2 ? n : fib(n-1) + fib(n-2) }.memoize()
assert fib(25) == 75025 // fast!
