#!/usr/bin/env python

def recursion(n):
	if n == 1:
		return n
	return n *  recursion(n - 1)


print(recursion(3))
