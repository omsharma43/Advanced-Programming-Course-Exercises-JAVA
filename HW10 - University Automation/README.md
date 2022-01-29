# question
In this question you have to implement the simple automation of a university using the concepts of object-orientation and inheritance, and finally add a number of students and professors as well as the course to the system and print an output that defines the relationship between the three. Slowly Your app should also be able to search.

The student, the teacher, and the course each contain a set of characteristics: The student has a unique 5-digit student code, first and last name, age of entry. The teacher has a unique 5-digit code, name, age, year of entry and the department in which he teaches. The course will have a set of codes for the students participating in the course, the professor code that will teach the course, the name, the year of presentation, and a unique two-digit number. In this question, we will have different operations that fall into 3 categories: SORT ADD SEARCH. The ADD operation adds a student, professor, or course to the campus space as shown below. After adding it, it prints it in the format specified below. The SORT operation will sort the list of each student or instructor on an input basis, and below is how it works. After the SORT keyword, one of the INSTRUCTOR / STUDENT / COURSE keywords must be selected. Note that they must be converted in ascending order, for example in sorting by name: Adam Benjamin john After sorting, print it in the format shown below. The SEARCH operation first specifies the number of attributes it wants to search and enters the specifications, and then prints the list in the format shown below. .

```
ADD STUDENT : [firstName,lastName,age,entranceYear,studentCode]
ADD STUDENT : [John,Borg,21,2020,12345]

ADD INSTRUCTOR :[firstName,lastName,age,entranceYear,instructorCode,department]
INSTRUCTOR :
[Franklin,Jabber,40,2010,23456,engineering]

COURSE : [studentsCodes,instructorsCodes,name,code,year]
COURSE : [{1234,13456},23456,AdvancedProgramming,78,2020]

SORT INSTRUCTOR/STUDENT/COURSE : NAME
SORT INSTRUCTOR/STUDENT/COURSE : LASTNAME
SORT INSTRUCTOR/STUDENT/COURSE : ENTRANCEYEAR
SEARCH : 3 : NAME = John, LASTNAME = Borg, AGE = 20 
```

# input
In the input section, first give the program a number of students, professors, as well as lessons, the input format of which is specified below. After adding a series of operations, enter and test the program. (This program does not include case testing) By entering the EXIT keyword the program should end.
# output
The outputs described above should be printed according to the operation you performed.
# example:

## Sample input 1:
```
ADD STUDENT : [John,Borg,21,2020,12345]
ADD STUDENT : [Adam,Brown,22,2019.13456]
ADD INSTRUCTOR : [Franklin,Jabber,40,2010,23456,engineering]
ADD INSTRUCTOR : [John,Goodman,45,2002,23957,engineering]
ADD COURSE : [{1234,13456},23456,AdvancedProgramming,78,2020]
SORT STUDENT : NAME
SEARCH : 1 : NAME = John
EXIT
```
## Sample output 1:
```
STUDENT WAS ADDED : [John,Borg,21,2020,12345]
STUDENT WAS ADDED :[Adam,Brown,22,2019.13456]
INSTRUCTOR WAS ADDED : [Franklin,Jabber,40,2010,23456,engineering]
INSTRUCTOR WAS ADDED : [John,Goodman,45,2002,23957,engineering]
COURSE  ADDED : [{1234,13456},23456,AdvancedProgramming,78,2020]
STUDENTS WAE SORTED : [{Adam,Brown,22,2019.13456},{John,Borg,21,2020,12345}]
RESULT OF YOUR SEARCH : [INSTRUCTOR{John,Goodman,45,2002,23957,engineering},STUDENT{John,Borg,21,2020,12345}] 
```


