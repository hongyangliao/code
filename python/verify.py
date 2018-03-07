#!/usr/bin/env python

database = [
['zhangsan','12345'],
['username','password'],
['lisi','54321']
]

username = raw_input("Please input your username:\n")
password = raw_input("Please input your password:\n")

token = [username,password]

if token in database: 
	print('verify success')
else:
	print('verify fail')
