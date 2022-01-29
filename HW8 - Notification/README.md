# question
Matthew, a working computer student living alone in his home, nowadays has to handle all his work remotely despite coronation and home quarantine, using social media to communicate. Due to the high volume of courses, job activities, family care, etc., it receives many messages from any field on a daily basis.

Due to the lack of time, he asks you to design a program for him so that any notification he receives will notice at a glance which person or application is from his mobile phone and which field of his activity it is related to.

Matthew's fields of activity:

* University courses
* Job
* Exchange
* Family
* Emotional
* Necessary
* Sport
* Diet

Each of these messages has a criterion for recognition based on which the criteria are checked and their type is determined:

* Necessary = {"hurry up", "faster", "important", (more than 4 "!")}
* Emotional = {"babe", "honey", "love"}
* Exchange = {(more than 10 digit number), "stock"}
* Job = {"project", "presentation", "meeting", "deadline"}
* Family = {"dad", "mom", "sonny", "son"}
* Sport = exercises "exercises", "muscle Building", "aerobic", "yoga", "walking", "run"}
* Educational = {"university", "master", "lesson", "grade", "homework", "class"}
* Diet = {"snack", "lunch", "dinner", "salad", "breakfast", "fruit", "vitamin tablets", "coffee", "herbal Tea"}

Now you have to consider a class for each type of message that all classes use the showNotificationPanel method based on the display of notifications and the output order of the notifications should be in the order given in the criteria description and then based on the sending time. Message to be brought.

Each type of notification has its own special and unique appearance that you can design based on your senses, but in each notification you must have two items:

**1.Massage Type 2.Sender Name**

Be sure to display.

Write the characteristics of each class in a principled way and use the topic of inheritance directly. Otherwise your code will not receive a score.

To sort messages by the time they were sent, you can only use one method for all objects, and this method must be in the class. Be] and ... will not have a score)

It is very important to clean the code and maintain the main framework of the program (avoid hitting extra and crowded codes that can be much more concise or optimized)

Important Note: In case of graphic implementation, up to 100 points will be considered for you.

```
class Notification
{
    public String showNotificationPanel () {
    }
}
```

```
class EducationalNotification extends Notification
{
    @override
    public String showNotificationPanel () {

    }
}
```
# input
The input of the program includes lines, each of which includes 3 senders, text message and message sending time.
# output
In output, all notifications should be displayed first based on the importance of the message type and then in each type based on the message sending time.

The format and text of the output is complete based on each person's taste.
# example:

## Sample input 1:
```
TA DD : "The Marshall class starts on Monday at 3 p.m." , 12:30
George : "The X project deadline is Friday." , 8:43 
Foodly : "Today, spinach and pomegranate salad is a good suggestion for lunch" , 11:00

```
## Sample output 1:
```
•• There is an Job message from George ••
>> TA DD has sent you a new Educational message <<
:::YOU HAVE A NEW DIET MESSAGE FROM FOODLY:::
```
## Sample input 2:
```
Yoga coach : "Did you do yoga today? " , 23:16
mom : "My son is your sister's birthday tomorrow !!!!" , 12:00
```
## Sample output 2:
```
XX mom has sent you a new Necessary message XX
++ There is an Sport message from Yoga coach ++
```

