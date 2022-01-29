package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class instructor extends person{

    protected  String department;

    public instructor(){}

    public instructor(String firstname,String lastname,int age,int entranceYear,int instructor_code,String department){
        super(firstname,lastname,age,entranceYear,instructor_code);
        this.department=department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString(){
        return "["+super.getFirstname()+","+super.getLastname()+","+super.getAge()+","+super.getEntranceYear()+","+super.getInstructor_or_student_code()+","+getDepartment()+"]";
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

    public instructor(instructor st){
        super(st.getFirstname(),st.getLastname(),st.getAge(),st.getEntranceYear(),st.getInstructor_or_student_code());
        this.department=st.getDepartment();
    }

    public instructor clone(person st){
        instructor t=new instructor();
        if (st instanceof instructor) {
            t=(instructor) st;
        }
        return t;
    }

    public ArrayList<instructor> sort(ArrayList<instructor> inst, String OP){
        if (OP.equals("FIRSTNAME")){
            instructor t=new instructor();
            for (int i=0;i<inst.size();i++){
                for (int j=0;j<inst.size()-i-1;j++){
                    if ((t.compare(inst.get(j).getFirstname(),inst.get(j+1).getFirstname()))==1){
                        instructor temp=new instructor(inst.get(j));
                        inst.set(j,inst.get(j+1));
                        inst.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("LASTNAME")){
            instructor t=new instructor();
            for (int i=0;i<inst.size();i++){
                for (int j=0;j<inst.size()-i-1;j++){
                    if ((t.compare(inst.get(j).getLastname(),inst.get(j+1).getLastname()))==1){
                        instructor temp=new instructor(inst.get(j));
                        inst.set(j,inst.get(j+1));
                        inst.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("ENTRANCEYEAR")){
            for (int i=0;i<inst.size();i++){
                for (int j=0;j<inst.size()-i-1;j++){
                    if (inst.get(j).getEntranceYear() > inst.get(j+1).getEntranceYear()){
                        instructor temp=new instructor(inst.get(j));
                        inst.set(j,inst.get(j+1));
                        inst.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("STUDENTCODE")){
            for (int i=0;i<inst.size();i++){
                for (int j=0;j<inst.size()-i-1;j++){
                    if (inst.get(j).getInstructor_or_student_code() > inst.get(j+1).getInstructor_or_student_code()){
                        instructor temp=new instructor(inst.get(j));
                        inst.set(j,inst.get(j+1));
                        inst.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("AGE")){
            for (int i=0;i<inst.size();i++){
                for (int j=0;j<inst.size()-i-1;j++){
                    if (inst.get(j).getAge() > inst.get(j+1).getAge()){
                        instructor temp=new instructor(inst.get(j));
                        inst.set(j,inst.get(j+1));
                        inst.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("DEPARTMENT")){
            instructor t=new instructor();
            for (int i=0;i<inst.size();i++){
                for (int j=0;j<inst.size()-i-1;j++){
                    if ((t.compare(inst.get(j).getDepartment(),inst.get(j+1).getDepartment()))==1){
                        instructor temp=new instructor(inst.get(j));
                        inst.set(j,inst.get(j+1));
                        inst.set(j+1,temp);
                    }
                }
            }
        }
        return inst;
    }

    @Override
    public boolean equals(Object o) {
        person x=(person) o;
        instructor f=new instructor();
        f=f.clone(x);
        return super.equals(x) && department.equals(f.getDepartment());
    }
}