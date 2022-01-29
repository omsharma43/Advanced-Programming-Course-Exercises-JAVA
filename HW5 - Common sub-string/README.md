# question
Write a program that takes an integer n from the user and then takes n strings from the input. The output of the program will be the largest string, such as s, with each string having s or vice versa as a subroutine. Do not print anything if there is no common subcategory.

Sub-discipline definition: "consecutive" characters from the string whose beginning and end can be anywhere in the string, and the order of the characters is exactly the same order in the main string. For example, the subcategories of ABC are as follows: A, B, C, AB, BC, ABC
# input
In a line the number n then n strings is given to you.
The length of the strings is also a maximum of 20.
# output
The subroutine that is printed in the output should be in the form that is in the first string, for example in the example it should be printed in the CDEF output, not the FEDC.
# example:

## Sample input 1:
```
3
ABCDEF
FEDCAB
GHCDEFJK
```
## Sample output 1:
```
CDEF
```

