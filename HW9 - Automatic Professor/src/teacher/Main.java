package teacher;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        ArrayList<collegian> student=new ArrayList<collegian>();
        ArrayList<Professor> TEACHERS=new ArrayList<Professor>();
        int counter=0;
        String name=" ";
        String type=" ";
        String field=" ";
        String prof=" ";
        while (true){
            String pms=new String(scan.nextLine());
            if (pms.equals("0")){
                break;
            }
            StringBuilder pmss=new StringBuilder(pms);
            pmss.append(" , ");
            Scanner input = new Scanner(pmss.toString()).useDelimiter("\\s*,\\s*");
            name=input.next();
            type=input.next();
            field=input.next();
            prof=input.next();

            if (prof.contains("Zohuri")){
                Professor professor=new Zohuri();
                TEACHERS.add(professor);
            }
            else {
                Professor professor=new Fatemi();
                TEACHERS.add(professor);
            }

            if (type.contains("Hard-working student")){
                collegian stud=new Hard_working_student(name,field,type_of_student.Hard_working);
                student.add(stud);
            }
            if (type.contains("Weak student")){
                collegian stud=new Weak_student(name,field,type_of_student.Weak);
                student.add(stud);
            }
            if (type.contains("Normal student")){
                collegian stud=new Normal_student(name,field,type_of_student.Normal);
                student.add(stud);
            }

            counter++;
        }
        for (int i=0;i<counter;i++){
            TEACHERS.get(i).reaction(student.get(i));
        }
    }
}
