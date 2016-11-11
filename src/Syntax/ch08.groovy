package Syntax

/**
 * Created by qinbingbing on 11/11/16.
 * Arrays
 */

String[] arrStr = ['Ananas', 'Banana', 'Kiwi']


assert arrStr instanceof String[]
assert !(arrStr instanceof List)

def numArr = [1, 2, 3] as int[]
assert numArr instanceof int[]
assert numArr.size() == 3


def matrix3 = new Integer[3][3]
assert matrix3.size() == 3

Integer[][] matrix2
matrix2 = [[1, 2], [3, 4]]
assert matrix2 instanceof Integer[][]


String[] names = ['James Bond', 'Jason Bourne', 'Ethan Hunt', 'Jack Bauer']
assert names[0] == 'James Bond'

names[2] = 'Jack'
assert names[2] == 'Jack'