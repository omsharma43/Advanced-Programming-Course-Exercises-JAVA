package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class person extends university {

    protected String firstname,lastname;
    protected int age;
    protected int instructor_or_student_code;

    public person(){}

    public person(String firstname,String lastname,int age,int entranceYear,int instructor_or_student_code){
        super(entranceYear);
        this.firstname=firstname;
        this.lastname=lastname;
        this.age=age;
        this.instructor_or_student_code=instructor_or_student_code;
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null || getClass() != x.getClass()) return false;
        person o=(person) x;
        return age == o.getAge() && instructor_or_student_code == o.getInstructor_or_student_code() && firstname.equals(o.getFirstname()) && lastname.equals(o.getLastname()) && super.getYear().equals(o.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age, instructor_or_student_code);
    }

    public int getAge() {
        return age;
    }
    public int getEntranceYear() {
        return super.getYear();
    }
    public int getInstructor_or_student_code() {
        return instructor_or_student_code;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setEntranceYear(int entranceYear) {
        super.setYear(entranceYear);
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setInstructor_or_student_code(int instructor_or_student_code) {
        this.instructor_or_student_code = instructor_or_student_code;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "person{" +
                "year=" + year +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", instructor_or_student_code=" + instructor_or_student_code +
                '}';
    }
}