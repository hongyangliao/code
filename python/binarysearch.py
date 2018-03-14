#!/usr/bin/env python

def search(sequence,number,lower,upper):
	if lower == upper:
		print('upper:' + upper)
		assert number == sequence[upper]
		return upper
	else:
		middle = (lower + upper) // 2
		if sequence[middle]  > number:
			return search(sequence,number,lower,middle)
		else:
			return search(sequence,number,middle + 1,upper)


sequence = [1,2,3,4,5,6,7]
sequence.sort()
print(search(sequence,6,0,len(sequence) - 1))
		
		
