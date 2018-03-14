#!/usr/bin/env python

def story(**params):
	return 'this is a param test \
	name = $(name) value = $(value)' % params

params = {'name'='xiaoming','value'='lisi'}

print(story(**params))
