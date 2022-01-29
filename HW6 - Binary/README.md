# question
Write a program that performs simple binary calculations (addition and multiplication). Assume that the input numbers are in complementary system 2 and work according to the rules of this system, also the numbers are in 8-bit format. If the input number is not in the 8-bit system, you must convert it to an 8-bit system for the program to work properly. The important point here is that you should not convert the input numbers that are in base 2 to base 10 and then do the calculations on them, but you should do the calculations in base 2 and avoid converting base.

1) Suppose the input of two numbers is in base 2, which is in String format. The program must calculate the sum of these two binary numbers and print the output in binary format and then decimal, and if the overflow occurs, print the message "OVERFLOW".

2) The program must also be able to calculate the product of two binary numbers and print in both binary and decimal formats on the output. (Assume that in this case overflow does not occur)

3) Now give an input to the program that calculates its symmetry in a binary way without converting it to a decimal number and prints it on the output.

The following table gives examples of inputs and outputs of this function:
# input
The input numbers of each operation are in the form of a string containing the numbers 0 and 1. Be sure to give the program inputs that do not overflow. Each time you enter a number, specify whether the number is negative or positive of a device with two characters + and -
# output
The output of each step consists of two strings, one representing the result of each operation in base 2 and the other in base 10. In the first line, print the number in base 10 and in the second line, the desired number in base 2.
# example:

## Sample input 1:
```
+
0101101
+
00110011
+
10100
+
0000011
-
11111011
```
## Sample output 1:
```
01100000
96
00111100
60
00000101
5
```

