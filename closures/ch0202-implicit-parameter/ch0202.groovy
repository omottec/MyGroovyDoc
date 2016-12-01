/**
 * Created by qinbingbing on 11/9/16.
 * Implicit parameter
 */

def greeting = { "Hello, $it!" }
assert greeting('Bond') == 'Hello, Bond!'

def magicNumber = { -> 42 }
// this call will fail because the closure doesn't accept any argument
magicNumber(11)