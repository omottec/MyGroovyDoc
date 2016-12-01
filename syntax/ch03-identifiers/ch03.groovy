package Syntax

/**
 * Created by qinbingbing on 11/7/16.
 * Identifiers
 */

def name
def item3
def with_underscore
def $dollarStart

def map = [:]
map."an identifier with a space and double quotes" = "ALLOWED"
map.'with-dash-signs-and-single-quotes' = "ALLOWED"

assert map."an identifier with a space and double quotes" == "ALLOWED"
assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""
map./slashy string/
map.$/dollar slashy string/$

def firstname = "Homer"
map."Simson-${firstname}" = "Homer Simson"
assert map.'Simson-Homer' == "Homer Simson"