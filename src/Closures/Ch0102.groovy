package Closures

/**
 * Created by qinbingbing on 11/9/16.
 * Closure as an object
 */

// { [closureParameters -> ] statements }

def listener = { e -> println "Clicked on $e.source" }
assert listener instanceof Closure
Closure callback = { println 'Done!' }
Closure<Boolean> isTextFile = {
    File it -> it.name.endsWith('.txt')
}