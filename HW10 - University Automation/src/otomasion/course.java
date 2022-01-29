package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class course extends university{

    protected String name;
    protected Integer code;
    protected ArrayList<Integer> instructorsCodes= new ArrayList<Integer>();
    protected ArrayList<Integer> studentsCodes= new ArrayList<Integer>();

    public course(ArrayList<Integer> studentsCodes,ArrayList<Integer> instructorsCodes,String name,int code,int year){
        super(year);
        this.studentsCodes=studentsCodes;
        this.instructorsCodes=instructorsCodes;
        this.name=name;
        this.code=code;
    }

    public course(){}

    public course(course c){
        super(c.getYear());
        this.studentsCodes=c.getStudentsCodes();
        this.instructorsCodes=c.getInstructorsCodes();
        this.name=c.getName();
        this.code=c.getCode();
    }

    public ArrayList<Integer> getInstructorsCodes() {
        return instructorsCodes;
    }
    public int getInstructorsCodes(int index) {
        return instructorsCodes.get(index);
    }
    public Integer getCode() {
        return code;
    }
    public Integer getYear() {
        return super.getYear();
    }
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getStudentsCodes() {
        return studentsCodes;
    }
    public int getStudentsCodes(int index) {
        return studentsCodes.get(index);
    }

    public int getStudentsCodes_size(){
        return this.studentsCodes.size();
    }
    public int getInstructorsCodes_size(){
        return this.instructorsCodes.size();
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setInstructorsCodes(ArrayList<Integer> instructorsCodes) {
        this.instructorsCodes = instructorsCodes;
    }
    public void setInstructorsCodes(int index,int code) {
        this.instructorsCodes.set(index,code);
    }
    public void setYear(int year) {
        super.setYear(year);
    }
    public void setStudentsCodes(ArrayList<Integer> studentsCodes) {
        this.studentsCodes = studentsCodes;
    }
    public void setStudentsCodes(int index,int code) {
        this.studentsCodes.set(index,code);
    }

    @Override
    public String toString(){
        StringBuilder TOSTRING=new StringBuilder();
        TOSTRING.append("[");
        if (getStudentsCodes_size()==1){
            TOSTRING.append(getStudentsCodes().get(0).toString());
        }
        else {
            TOSTRING.append("{");
            for (int i = 0; i < getStudentsCodes_size(); i++) {

                TOSTRING.append(getStudentsCodes().get(i).toString());
                if ((i + 1) <= getStudentsCodes_size() - 1) {
                    TOSTRING.append(",");
                }

            }
            TOSTRING.append("}");
        }

        TOSTRING.append(",");

        if (getInstructorsCodes_size()==1){
            TOSTRING.append(getInstructorsCodes().get(0).toString());
        }
        else {
            TOSTRING.append("{");
            for (int i = 0; i < getInstructorsCodes_size(); i++) {

                TOSTRING.append(getInstructorsCodes().get(i).toString());
                if ((i + 1) <= getInstructorsCodes_size() - 1) {
                    TOSTRING.append(",");
                }

            }
            TOSTRING.append("}");
        }

        TOSTRING.append(",");

        TOSTRING.append(getName());

        TOSTRING.append(",");

        TOSTRING.append(getCode().toString());

        TOSTRING.append(",");

        TOSTRING.append(getYear().toString());

        TOSTRING.append("]");
        return TOSTRING.toString();
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

    public ArrayList<course> sort(ArrayList<course> cour,String OP){
        if (OP.equals("NAME")){
            course t=new course();
            for (int i=0;i<cour.size();i++){
                for (int j=0;j<cour.size()-i-1;j++){
                    if ((t.compare(cour.get(j).getName(),cour.get(j+1).getName()))==1){
                        course temp=new course(cour.get(j));
                        cour.set(j,cour.get(j+1));
                        cour.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("CODE")){
            for (int i=0;i<cour.size();i++){
                for (int j=0;j<cour.size()-i-1;j++){
                    if (cour.get(j).getCode() > cour.get(j+1).getCode()){
                        course temp=new course(cour.get(j));
                        cour.set(j,cour.get(j+1));
                        cour.set(j+1,temp);
                    }
                }
            }
        }
        if (OP.equals("YEAR")){
            for (int i=0;i<cour.size();i++){
                for (int j=0;j<cour.size()-i-1;j++){
                    if (cour.get(j).getYear() > cour.get(j+1).getYear()){
                        course temp=new course(cour.get(j));
                        cour.set(j,cour.get(j+1));
                        cour.set(j+1,temp);
                    }
                }
            }
        }
        return cour;
    }
}
