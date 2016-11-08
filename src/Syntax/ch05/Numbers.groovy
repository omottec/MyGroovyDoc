package Syntax.ch05

/**
 * Created by qinbingbing on 11/8/16.
 */

// 5.1 Integral literals

// primitive types
byte b = 1
char c = 2
short s = 3
int i = 4
long l = 5

// infinite precision
BigInteger bi = 6

def pa = 1
assert pa instanceof Integer

// Integer.MAX_VALUE
def pb = 2147483647
assert pb instanceof Integer

// Integer.MAX_VALUE + 1
def pc = 2147483648
assert pc instanceof Long

// Long.MAX_VALUE
def pd = 9223372036854775807
assert pd instanceof Long

// Long.MAX_VALUE + 1
def pe = 9223372036854775808
assert pe instanceof BigInteger

def na = -1
assert na instanceof Integer

// Integer.MIN_VALUE
def nb = -2147483648
assert nb instanceof Integer

// Integer.MIN_VALUE -1
def nc = -2147483649
assert nc instanceof Long

// Long.MIN_VALUE
def nd = -9223372036854775808
assert nd instanceof Long

// Long.MIN_VALUE - 1
def ne = -9223372036854775809
assert ne instanceof BigInteger

/**
 *  Binary literal
 */
int xInt = 0b10101111
assert xInt == 175

short xShort = 0b11001001
assert xShort == 201 as short

byte xByte = 0b11
assert xByte == 3 as byte

long xLong = 0b101101101101
assert xLong == 2925l

BigInteger xBigInteger = 0b111100100001
assert xBigInteger == 3873g

int xNegativeInt = -0b10101111
assert xNegativeInt == -175

/**
 * Octal Literal
 */
xInt = 077
assert xInt == 63

xShort = 011
assert xShort == 9 as short

xByte = 032
assert xByte == 26 as byte

xLong = 0246
assert xLong == 166l

xBigInteger = 01111
assert xBigInteger == 585g

xNegativeInt = -077
assert xNegativeInt == -63

/**
 * Hexadecimal literal
 */
xInt = 0x77
assert xInt == 119

xShort = 0xaa
assert xShort == 170 as short

xByte = 0x3a
assert xByte == 58 as byte

xLong = 0xffff
assert xLong == 65535l

xBigInteger = 0xaaaa
assert xBigInteger == 43690g

Double xDouble = new Double('0x1.0p0')
assert xDouble == 1.0d

xNegativeInt = -0x77
assert xNegativeInt == -119

/**
 * Decimal literals
 */

// primitive types
float f = 1.234
double d = 2.345

// infinite precision
BigDecimal bd = 3.456

assert 1e3 == 1_000.0
assert 2E4 == 20_000.0
assert 3e+1 == 30.0
assert 4E-2 == 0.04
assert 5e-1 == 0.5

/**
 * Underscore in literals
 */
long creditCardNumber = 1234_5678_9012_3456L
long socialSecurityNumbers = 999_99_9999L
double monetaryAmount = 12_345_132.12
long hexBytes = 0xFF_EC_DE_5E
long hexWords = 0xFFEC_DE5E
long maxLong = 0x7fff_ffff_ffff_ffff
long alsoMaxLong = 9_223_372_036_854_775_807L
long bytes = 0b11010010_01101001_10010100_10010010

/**
 * Number type suffixes
 */
