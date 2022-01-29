package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> SEQUENCES=new ArrayList<String>();
        Scanner input=new Scanner(System.in);
        while (true){
            String seq=new String(input.nextLine());
            if (seq.equals("EXIT")){
                break;
            }
            SEQUENCES.add(seq);
        }
        input.close();

        ArrayList<person> PERSON=new ArrayList<person>();
        ArrayList<student> students=new ArrayList<student>();
        ArrayList<instructor> instructors=new ArrayList<instructor>();
        ArrayList<course> courses=new ArrayList<course>();

        for (int i=0;i< SEQUENCES.size();i++){

            if (SEQUENCES.get(i).contains("ADD STUDENT")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder OP=new StringBuilder(in.next());
                StringBuilder ARG=new StringBuilder(in.next());

                ARG.deleteCharAt(ARG.length()-1);
                ARG.deleteCharAt(0);
                ARG.append(",");

                in.close();

                Scanner cin=new Scanner(ARG.toString()).useDelimiter(",");

                String name=new String(cin.next());
                String lastname=new String(cin.next());
                int age=Integer.parseInt(cin.next());
                int en_year=Integer.parseInt(cin.next());
                int code=Integer.parseInt(cin.next());

                student s=new student(name,lastname,age,en_year,code);
                person p=new student(name,lastname,age,en_year,code);

                PERSON.add(p);
                students.add(s);

                cin.close();
                System.out.print("STUDENT WAS ADDED : "+ s.toString());
                System.out.println();
            }

            if (SEQUENCES.get(i).contains("ADD INSTRUCTOR")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder OP=new StringBuilder(in.next());
                StringBuilder ARG=new StringBuilder(in.next());

                ARG.deleteCharAt(ARG.length()-1);
                ARG.deleteCharAt(0);
                ARG.append(",");

                in.close();

                Scanner cin=new Scanner(ARG.toString()).useDelimiter(",");

                String name=new String(cin.next());
                String lastname=new String(cin.next());
                int age=Integer.parseInt(cin.next());
                int en_year=Integer.parseInt(cin.next());
                int code=Integer.parseInt(cin.next());
                String department=new String(cin.next());

                instructor j=new instructor(name,lastname,age,en_year,code,department);
                person p=new instructor(name,lastname,age,en_year,code,department);

                PERSON.add(p);
                instructors.add(j);

                cin.close();
                System.out.print("INSTRUCTOR WAS ADDED : "+ j.toString());
                System.out.println();

            }

            if (SEQUENCES.get(i).contains("ADD COURSE")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder OP=new StringBuilder(in.next());
                StringBuilder ARG=new StringBuilder(in.next());

                ARG.deleteCharAt(ARG.length()-1);
                ARG.deleteCharAt(0);
                ARG.append("},");
                in.close();

                Scanner inp=new Scanner(ARG.toString()).useDelimiter("},");

                StringBuilder s_codes=new StringBuilder(inp.next());
                s_codes.deleteCharAt(0);
                s_codes.append(",");
                StringBuilder ARGUMENTS=new StringBuilder(inp.next());

                in.close();

                ARGUMENTS.append(",");
                Scanner cin=new Scanner(ARGUMENTS.toString()).useDelimiter(",");

                ArrayList<Integer> instructor_codes=new ArrayList<Integer>();
                StringBuilder instructor_code=new StringBuilder(cin.next());
                if (instructor_code.charAt(0)=='{'){
                    instructor_code.deleteCharAt(instructor_code.length()-1);
                    instructor_code.deleteCharAt(0);
                    instructor_code.append(",");

                    int count1=0;
                    for (int i1=0;i1<instructor_code.length();i1++){
                        if (s_codes.charAt(i1)==','){
                            count1++;
                        }
                    }

                    Scanner cin2=new Scanner(s_codes.toString()).useDelimiter(",");
                    for (int j=0;j<count1;j++){
                        instructor_codes.add(Integer.parseInt(cin2.next()));
                    }

                    cin2.close();
                }
                else {
                    instructor_codes.add(Integer.parseInt(instructor_code.toString()));
                }
                String name=new String(cin.next());
                int code=Integer.parseInt(cin.next());
                int year=Integer.parseInt(cin.next());

                int count=0;
                for (int i1=0;i1<s_codes.length();i1++){
                    if (s_codes.charAt(i1)==','){
                        count++;
                    }
                }
                Scanner cin1=new Scanner(s_codes.toString()).useDelimiter(",");
                ArrayList<Integer> Scodes=new ArrayList<Integer>();
                for (int j=0;j<count;j++){
                    Scodes.add(Integer.parseInt(cin1.next()));
                }

                course cour=new course(Scodes,instructor_codes,name,code,year);

                courses.add(cour);

                cin1.close();
                cin.close();
                System.out.print("COURSE ADDED : "+ cour.toString());
                System.out.println();
            }

            if (SEQUENCES.get(i).contains("SORT COURSE")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder nci=new StringBuilder(in.next());
                StringBuilder op=new StringBuilder(in.next());
                in.close();

                course o=new course();

                courses=o.sort(courses,op.toString());

                System.out.print("COURSES WAE SORTED : [");
                for (int j=0;j<courses.size();j++){
                    System.out.print(courses.get(j).toString());
                    if (j<courses.size()-1){
                        System.out.print(",");
                    }
                }
                System.out.print("]");
                System.out.println();
            }

            if (SEQUENCES.get(i).contains("SORT INSTRUCTOR")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder nci=new StringBuilder(in.next());
                StringBuilder op=new StringBuilder(in.next());

                in.close();

                instructor o=new instructor();

                instructors=o.sort(instructors,op.toString());

                System.out.print("INSTRUCTORS WAE SORTED : [");
                for (int j=0;j<instructors.size();j++){
                    StringBuilder out=new StringBuilder(instructors.get(j).toString());
                    out.setCharAt(0,'{');
                    out.setCharAt(out.length()-1,'}');
                    System.out.print(out.toString());
                    if (j<instructors.size()-1){
                        System.out.print(",");
                    }
                }
                System.out.print("]");
                System.out.println();
            }

            if (SEQUENCES.get(i).contains("SORT STUDENT")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder nci=new StringBuilder(in.next());
                StringBuilder op=new StringBuilder(in.next());

                in.close();

                student o=new student();

                students=o.sort(students,op.toString());

                System.out.print("STUDENTS WAE SORTED : [");
                for (int j=0;j<students.size();j++){
                    StringBuilder out=new StringBuilder(students.get(j).toString());
                    out.setCharAt(0,'{');
                    out.setCharAt(out.length()-1,'}');
                    System.out.print(out.toString());
                    if (j<students.size()-1){
                        System.out.print(",");
                    }
                }
                System.out.print("]");
                System.out.println();
            }

            if (SEQUENCES.get(i).contains("SEARCH")){

                StringBuilder SEQ=new StringBuilder(SEQUENCES.get(i));
                SEQ.append(" : ");
                Scanner in=new Scanner(SEQ.toString()).useDelimiter("\\s*:\\s*");

                StringBuilder nci=new StringBuilder(in.next());
                int num=Integer.parseInt(in.next());
                StringBuilder op=new StringBuilder(in.next());

                ArrayList<person> result_of_search=new ArrayList<person>();

                result_of_search=main_search.search(num,op.toString(),PERSON);

                if(!result_of_search.isEmpty()) {
                    System.out.print("RESULT OF YOUR SEARCH : [");
                    for (int j = 0; j < result_of_search.size(); j++) {
                        StringBuilder out = new StringBuilder(result_of_search.get(j).toString());
                        out.setCharAt(0, '{');
                        out.setCharAt(out.length() - 1, '}');
                        if (result_of_search.get(j) instanceof student) {
                            System.out.print("STUDENT");
                        }
                        if (result_of_search.get(j) instanceof instructor) {
                            System.out.print("INSTRUCTOR");
                        }
                        System.out.print(out.toString());
                        if (j < result_of_search.size() - 1) {
                            System.out.print(",");
                        }
                    }
                    System.out.print("]");
                    System.out.println();
                }
                else {
                    System.out.println("not found!");
                }

                in.close();
            }
        }
    }
}
