/**
 * Created by qinbingbing on 11/9/16.
 * Defining a closure
 */

def a = { item++ }
def b = { -> item++ }
def c = { println it }
def d = { it -> println it }
def e = { name -> println name }
def f = { String x, int y ->
    println "hey ${x} the value is ${y}"
}
def g = { reader ->
    def line = reader.readLine()
    line.trim()
}