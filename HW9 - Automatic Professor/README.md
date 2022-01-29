# question
One of the university professors, who is tired of answering students repeatedly, has decided to create a program that gives a message instead of himself, that is, to repeat the usual sentences of professors in dealing with students, so that our student will feel a little in reading these sentences. To be a university. To do this, create a master class and a student class. There is only one method in the master class that has been overloaded in different ways. Implement the reaction method in such a way that it is against strong students, weak students and average students Give you different answers. Create two different classes (described below) that they inherit from the master class and implement the teachers' attitudes in the way described.

professor class

```
Class Professor {
	void reaction(Collegian collegian);
}
```

The input of the reaction method has different overloads based on the classes it inherits from the student class.

Student class

```
Class collegian{    
    String name ;        
    String universityField;
            }
```

We ask you to create three new classes by inheriting from the student class and creating a variable to identify strong, medium and weak students, the difference between which is strong, average and weak students (the type of variable to determine this is up to you Creative solutions will add extra points.) Also, by inheriting from the Master Class, create two new classes called Zohuri and Fatemi, which represent two prominent professors with different ethics from the School of Engineering. .

How professors treat students:

```
zohuri : Hard-working student -> "name" , I Like you ,you have great future .

fatemi : Hard-working student -> "name" , I think you can deliver the exercises faster .

zohuri : Normal student -> "name" , Because of your effort I appreciate you .        

fatemi : Normal student -> "name" , You are at the lowest acceptance level to continue the course "universityField" .

zohuri : Weak student -> "name" , please  work harder , I believe , you can succeed in "universityField" course .

fatemi : Weak student -> "name" , Will you delete "universityField" yourself or will I do it for you?
```

**Codes that do not use object-oriented features will not receive a full score.**

# input
The input will include the name and field, as well as the level and name of the professor with whom (for example) the student is talking, at the end of "0" indicates the end of the file.
# output
The output contains the statements made by each professor in relation to each student from the first input.
# example:

## Sample input 1:
```
AmirAli , Weak student , Computer Engineering , Zohuri
Soheil , Hard-working student , industrial engineering , Fatemi
0
```
## Sample output 1:
```
Zohuri : AmirAli , please  work harder , I believe , you can succeed in Computer Engineering course .
Fatemi : Soheil , I think you can deliver the exercises faster .    
```


