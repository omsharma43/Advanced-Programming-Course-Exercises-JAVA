package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class student extends person{
    public student(){}
    public student(String firstname,String lastname,int age,int entranceYear,int student_code){
        super(firstname,lastname,age,entranceYear,student_code);
    }
    @Override
    public String toString(){
        return "["+super.getFirstname()+","+super.getLastname()+","+super.getAge()+","+super.getEntranceYear()+","+super.getInstructor_or_student_code()+"]";
    }

    public student(student st){
        super(st.getFirstname(),st.getLastname(),st.getAge(),st.getEntranceYear(),st.getInstructor_or_student_code());
    }

    public int compare(String str1,String str2){

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        StringBuilder string1=new StringBuilder(str1);
        StringBuilder string2=new StringBuilder(str2);

        int j=0;
        for (int i=0;i<string1.length() && i<string2.length();i++){
            if (string1.charAt(i)<string2.charAt(i)){
                return 1;
            }
            if (string1.charAt(i)>string2.charAt(i)){
                return -1;
            }
            j=i;
        }
        if ((j+1)==string1.length() || (j+1)==string2.length()){
            if ((j+1)==string1.length()){
                return -1;
            }
            if ((j+1)==string2.length()){
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<student> sort(ArrayList<student> STUD, String OP){
        if (OP.equals("FIRSTNAME")){
            student t=new student();
            for (int i=0;i<STUD.size();i++){
                for (int j=0;j<STUD.size()-i-1;j++){
                    if ((t.compare(STUD.get(j).getFirstname(),STUD.get(j+1).getFirstname()))==1){
                        student temp=new student(STUD.get(j));
                        STUD.set(j,STUD.get(j+1));
                        STUD.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("LASTNAME")){
            student t=new student();
            for (int i=0;i<STUD.size();i++){
                for (int j=0;j<STUD.size()-i-1;j++){
                    if ((t.compare(STUD.get(j).getLastname(),STUD.get(j+1).getLastname()))==1){
                        student temp=new student(STUD.get(j));
                        STUD.set(j,STUD.get(j+1));
                        STUD.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("ENTRANCEYEAR")){
            for (int i=0;i<STUD.size();i++){
                for (int j=0;j<STUD.size()-i-1;j++){
                    if (STUD.get(j).getEntranceYear() > STUD.get(j+1).getEntranceYear()){
                        student temp=new student(STUD.get(j));
                        STUD.set(j,STUD.get(j+1));
                        STUD.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("STUDENTCODE")){
            for (int i=0;i<STUD.size();i++){
                for (int j=0;j<STUD.size()-i-1;j++){
                    if (STUD.get(j).getInstructor_or_student_code() > STUD.get(j+1).getInstructor_or_student_code()){
                        student temp=new student(STUD.get(j));
                        STUD.set(j,STUD.get(j+1));
                        STUD.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("AGE")){
            for (int i=0;i<STUD.size();i++){
                for (int j=0;j<STUD.size()-i-1;j++){
                    if (STUD.get(j).getAge() > STUD.get(j+1).getAge()){
                        student temp=new student(STUD.get(j));
                        STUD.set(j,STUD.get(j+1));
                        STUD.set(j+1,temp);
                    }
                }
            }
        }
        return STUD;
    }
    @Override
    public boolean equals(Object o) {
        person x=(person) o;
        return super.equals(x);
    }
}
