#!/usr/bin/env python

# this is mapping simple

information = {
	'alice':{
		'sex':'male',
		'age':'12'
	},
	'hongyangliao':{
		'sex':'female',
		'age':'23'
	}
}

name = raw_input('what dou you name?\n')
print('your name is ' +  name)
info = information[name]
choose = raw_input('Do you want to choose sex or age\n')
print('your ' + choose + ' is ' + info[choose])


