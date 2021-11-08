# iot_algo_labs

# 6 lab

## Task 

Beavers Antin and Ori came up with a game - to invent random binary numbers,
and to see if these numbers can be broken into pieces, each of which is
the power of the number X in the decimal system.

For example, if X == 5, then the binary number 101110011 
can be divided into 101, 11001 and 1,
each of which is 5 to some degree 
(101 in decimal == 5 == 5 ^ 1, 11001 == 25 == 5 ^ 2 and 1 == 1 is 5 ^ 0).

Demonstrate that humans are smarter than beavers, and for a given binary number N, find the smallest number of pieces to break it into.

-----------
### Simple explanation

+ Step 1 - Find possible pows of given number 
+ Step 2 - Iterate through the given *binary string* and compare if the part of string is equal to binary pow of the digit
+ Step 3 - count possible pows

Wel done!

