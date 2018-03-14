#!/usr/bin/env python

def doctest():
	'this is a doc'
	return 'hello'

print(doctest.__doc__)

help(doctest)
