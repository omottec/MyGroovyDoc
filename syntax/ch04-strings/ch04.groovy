package Syntax

/**
 * Created by qinbingbing on 11/7/16.
 * Strings
 */

// Single quoted string
'a single quoted string'

// String concatenation
assert 'ab' == 'a' + 'b'

// Triple single quoted string
'''a triple single quoted string'''

def aMultilineString = '''line one
line two
line three'''

def startAndEndWithANewline = '''
line one
line two
line three
'''

def strippedFirstNewline = '''\
line one
line two
line three
'''

// Escaping special characters
'an escape single quote: \' needs a backslash'
'an escaped escape character: \\ needs a double backslash'

// Unicode escape sequence
'The Euro currency symbol: \u20AC'

// Double quoted string
"a double quoted string"
"A double quote:\""

// String interpolation
def name = 'Guillaume'
def greeting = "Hello ${name}"
assert greeting == 'Hello Guillaume'

def sum = "The sum of 2 and 3 equals ${2 + 3}"
assert sum == 'The sum of 2 and 3 equals 5'

def person = [name: 'Guillaume', age: 36]
assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

def number = 3.14
//shouldFail(MissingPropertyException) {
//    println "$number.toString()"
//}

def sParameterLessClosure = "1 + 2 == ${-> 3}"
assert sParameterLessClosure == '1 + 2 == 3'

def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
assert sOneParamClosure == '1 + 2 == 3'

def num = 1
def eagerGString = "value == ${num}"
def lazyGString = "value == ${-> num}"

assert eagerGString == "value == 1"
assert lazyGString == "value == 1"

num = 2
assert eagerGString == "value == 1"
assert lazyGString == "value == 2"

// 4.4.3 Interoperability with Java
String takeString(String message) {
    assert message instanceof String
    return message
}

def message = "The message is ${'hello'}"
assert message instanceof GString

def result = takeString(message)
assert result instanceof String
assert result == 'The message is hello'

assert "one: ${1}".hashCode() != "one: 1".hashCode()

def key = "a"
def m = ["${key}": "letter ${key}"]
assert m["a"] == null

def name1 = 'Groovy'
def template = """
    Dear Mr ${name1}

    You're the winner of the lottery!

    Yours sincerly

    Dave
"""
assert template.toString().contains('Groovy')

// 4.6 Slashy string
def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'

def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'

def multilineSlashy = /one
    two
    three/
assert multilineSlashy.contains('\n')

def color = 'blue'
def interpolatedSlashy = /a ${color} car/
assert interpolatedSlashy == 'a blue car'

//assert '' == //

// 4.7 Dollar Slashy string
def name2 = "Guillaume"
def date = "April, 1st"
def dollarSlashy = $/
    Hello $name2,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $/$ escaped dollar slashy string delimiter
/$
assert [
        'Guillaume',
        'April, 1st',
        '$ dollar sign',
        '$ escaped dollar sign',
        '\\ backslash',
        '/ forward slash',
        '$/ escaped forward slash',
        '/$ escaped dollar slashy string delimiter'

].each { dollarSlashy.contains(it) }

char c1 = 'A'
assert c1 instanceof Character

def c2 = 'B' as char
assert c2 instanceof Character

def c3 = (char)'C'
assert c3 instanceof Character