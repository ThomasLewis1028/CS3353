To use, run NodeMain, StackMain, or QueueMain.

NodeMain Instructions:
	Follow instructions, use X.op for each operation including in, del and sch, and in_X
	Examples: 5.in 4.del 7.sch 3.in_1
	Use exit to exit, and print to print.
	Duplicates are accounted for and will be rejected

StackMain Instructions:
	Type filename, use entire path (at least that's how I tested it)
	This uses dynamic array so just use X.pop and push to put things on and pop things off the stack
	Examples: 3.push pop

QueueMain Instructions:
	Type filename, use entire path
	File formatting should be: <size> <operations>
	Use X.in to insert and del to delete
	Examples: 3.in del

Both Stack and Queue can take multiple lines to allow for different tests. So each line will be a new stack/queue

All three programs will not allow for overflow in any form. This means that you can't add too many elements
to the queue, you can't delete items that don't exist, and you can't insert to a node that doens't exist.
