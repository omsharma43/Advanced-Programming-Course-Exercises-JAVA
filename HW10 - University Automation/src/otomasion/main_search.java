package otomasion;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class main_search {
    public static ArrayList<person> search(int num_arg, String arg, ArrayList<person> per){
        ArrayList<person> NOT_SORTED_answer=new ArrayList<person>();
        ArrayList<person> SORTED_answer=new ArrayList<person>();
        if (num_arg==1){
            StringBuilder args=new StringBuilder(arg);
            args.append(" = ");
            Scanner input = new Scanner(args.toString()).useDelimiter("\\s*=\\s*");
            String AR1=input.next();
            String ARI1=input.next();

            switch (AR1){
                case "NAME" :{
                    for(int i=0;i<per.size();i++){
                        if (ARI1.equals(per.get(i).getFirstname())){
                            SORTED_answer.add(per.get(i));
                        }
                    }
                    break;
                }
                case "LASTNAME" :{
                    for(int i=0;i<per.size();i++){
                        if (ARI1.equals(per.get(i).getLastname())){
                            SORTED_answer.add(per.get(i));
                        }
                    }
                    break;
                }
                case "AGE" :{
                    Integer n=Integer.parseInt(ARI1);
                    for(int i=0;i<per.size();i++){
                        if (n.equals(per.get(i).getAge())){
                            SORTED_answer.add(per.get(i));
                        }
                    }
                    break;
                }
                case "ENTRANCEYEAR" :{
                    Integer n=Integer.parseInt(ARI1);
                    for(int i=0;i<per.size();i++){
                        if (n.equals(per.get(i).getEntranceYear())){
                            SORTED_answer.add(per.get(i));
                        }
                    }
                    break;
                }
                case "CODE" :{
                    Integer n=Integer.parseInt(ARI1);
                    for(int i=0;i<per.size();i++){
                        if (n.equals(per.get(i).getInstructor_or_student_code())){
                            SORTED_answer.add(per.get(i));
                        }
                    }
                    break;
                }
                case "DEPARTMENT" :{
                    for (int i=0;i< per.size();i++) {
                        if (per.get(i) instanceof instructor) {
                            if (ARI1.equals(((instructor) per.get(i)).getDepartment())){
                                SORTED_answer.add(per.get(i));
                            }
                        }
                    }
                }
            }
            input.close();
        }
        if (num_arg==2){
            StringBuilder parameter=new StringBuilder(arg);
            parameter.append(", ");
            Scanner input = new Scanner(parameter.toString()).useDelimiter(",\\s*");
            StringBuilder arg1=new StringBuilder(input.next());
            StringBuilder arg2=new StringBuilder(input.next());
            arg1.append(" = ");
            arg2.append(" = ");
            Scanner input1 = new Scanner(arg1.toString()).useDelimiter("\\s*=\\s*");
            Scanner input2 = new Scanner(arg2.toString()).useDelimiter("\\s*=\\s*");

            ArrayList<String> arguments=new ArrayList<String>();

            arguments.add(input1.next());
            arguments.add(input1.next());
            arguments.add(input2.next());
            arguments.add(input2.next());

            for (int i=0;i<arguments.size();i=i+2){
                switch (arguments.get(i)){

                    case "NAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getFirstname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "LASTNAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getLastname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "AGE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getAge())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "ENTRANCEYEAR" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getEntranceYear())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "CODE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getInstructor_or_student_code())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "DEPARTMENT" : {
                        for (int j = 0; j < per.size(); j++) {
                            if (per.get(j) instanceof instructor){
                                if (arguments.get(i+1).equals(((instructor) per.get(j)).getDepartment())){
                                    NOT_SORTED_answer.add(per.get(j));
                                }
                            }
                        }
                        break;
                    }
                }
            }


            for (int i=0;i<NOT_SORTED_answer.size();i++){
                int count=0;
                for (int j=0;j< NOT_SORTED_answer.size();j++){
                    if (NOT_SORTED_answer.get(i).equals(NOT_SORTED_answer.get(j))){
                        count++;
                    }
                }
                if (count==num_arg){
                    SORTED_answer.add(NOT_SORTED_answer.get(i));
                }
            }

            LinkedHashSet<person> lhSet = new LinkedHashSet<person>( SORTED_answer );
            SORTED_answer.clear();
            SORTED_answer.addAll(lhSet);

            input.close();
            input1.close();
            input2.close();
        }
        if (num_arg==3){
            StringBuilder parameter=new StringBuilder(arg);
            parameter.append(", ");
            Scanner input = new Scanner(parameter.toString()).useDelimiter(",\\s*");
            StringBuilder arg1=new StringBuilder(input.next());
            StringBuilder arg2=new StringBuilder(input.next());
            StringBuilder arg3=new StringBuilder(input.next());
            arg1.append(" = ");
            arg2.append(" = ");
            arg3.append(" = ");
            Scanner input1 = new Scanner(arg1.toString()).useDelimiter("\\s*=\\s*");
            Scanner input2 = new Scanner(arg2.toString()).useDelimiter("\\s*=\\s*");
            Scanner input3 = new Scanner(arg3.toString()).useDelimiter("\\s*=\\s*");

            ArrayList<String> arguments=new ArrayList<String>();

            arguments.add(input1.next());
            arguments.add(input1.next());
            arguments.add(input2.next());
            arguments.add(input2.next());
            arguments.add(input3.next());
            arguments.add(input3.next());

            for (int i=0;i<arguments.size();i=i+2){
                switch (arguments.get(i)){

                    case "NAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getFirstname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "LASTNAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getLastname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "AGE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getAge())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "ENTRANCEYEAR" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getEntranceYear())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "CODE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getInstructor_or_student_code())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "DEPARTMENT" : {
                        for (int j = 0; j < per.size(); j++) {
                            if (per.get(j) instanceof instructor){
                                if (arguments.get(i+1).equals(((instructor) per.get(j)).getDepartment())){
                                    NOT_SORTED_answer.add(per.get(j));
                                }
                            }
                        }
                        break;
                    }
                }
            }


            for (int i=0;i<NOT_SORTED_answer.size();i++){
                int count=0;
                for (int j=0;j< NOT_SORTED_answer.size();j++){
                    if (NOT_SORTED_answer.get(i).equals(NOT_SORTED_answer.get(j))){
                        count++;
                    }
                }
                if (count==num_arg){
                    SORTED_answer.add(NOT_SORTED_answer.get(i));
                }
            }

            LinkedHashSet<person> lhSet = new LinkedHashSet<person>( SORTED_answer );
            SORTED_answer.clear();
            SORTED_answer.addAll(lhSet);

            input.close();
            input1.close();
            input2.close();
            input3.close();
        }
        if (num_arg==4){
            StringBuilder parameter=new StringBuilder(arg);
            parameter.append(", ");
            Scanner input = new Scanner(parameter.toString()).useDelimiter(",\\s*");
            StringBuilder arg1=new StringBuilder(input.next());
            StringBuilder arg2=new StringBuilder(input.next());
            StringBuilder arg3=new StringBuilder(input.next());
            StringBuilder arg4=new StringBuilder(input.next());
            arg1.append(" = ");
            arg2.append(" = ");
            arg3.append(" = ");
            arg4.append(" = ");
            Scanner input1 = new Scanner(arg1.toString()).useDelimiter("\\s*=\\s*");
            Scanner input2 = new Scanner(arg2.toString()).useDelimiter("\\s*=\\s*");
            Scanner input3 = new Scanner(arg3.toString()).useDelimiter("\\s*=\\s*");
            Scanner input4 = new Scanner(arg4.toString()).useDelimiter("\\s*=\\s*");


            ArrayList<String> arguments=new ArrayList<String>();

            arguments.add(input1.next());
            arguments.add(input1.next());
            arguments.add(input2.next());
            arguments.add(input2.next());
            arguments.add(input3.next());
            arguments.add(input3.next());
            arguments.add(input4.next());
            arguments.add(input4.next());

            for (int i=0;i<arguments.size();i=i+2){
                switch (arguments.get(i)){

                    case "NAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getFirstname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "LASTNAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getLastname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "AGE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getAge())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "ENTRANCEYEAR" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getEntranceYear())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "CODE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getInstructor_or_student_code())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "DEPARTMENT" : {
                        for (int j = 0; j < per.size(); j++) {
                            if (per.get(j) instanceof instructor){
                                if (arguments.get(i+1).equals(((instructor) per.get(j)).getDepartment())){
                                    NOT_SORTED_answer.add(per.get(j));
                                }
                            }
                        }
                        break;
                    }
                }
            }


            for (int i=0;i<NOT_SORTED_answer.size();i++){
                int count=0;
                for (int j=0;j< NOT_SORTED_answer.size();j++){
                    if (NOT_SORTED_answer.get(i).equals(NOT_SORTED_answer.get(j))){
                        count++;
                    }
                }
                if (count==num_arg){
                    SORTED_answer.add(NOT_SORTED_answer.get(i));
                }
            }

            LinkedHashSet<person> lhSet = new LinkedHashSet<person>( SORTED_answer );
            SORTED_answer.clear();
            SORTED_answer.addAll(lhSet);

            input.close();
            input1.close();
            input2.close();
            input3.close();
            input4.close();
        }
        if (num_arg==5){
            StringBuilder parameter=new StringBuilder(arg);
            parameter.append(", ");
            Scanner input = new Scanner(parameter.toString()).useDelimiter(",\\s*");
            StringBuilder arg1=new StringBuilder(input.next());
            StringBuilder arg2=new StringBuilder(input.next());
            StringBuilder arg3=new StringBuilder(input.next());
            StringBuilder arg4=new StringBuilder(input.next());
            StringBuilder arg5=new StringBuilder(input.next());
            arg1.append(" = ");
            arg2.append(" = ");
            arg3.append(" = ");
            arg4.append(" = ");
            arg5.append(" = ");
            Scanner input1 = new Scanner(arg1.toString()).useDelimiter("\\s*=\\s*");
            Scanner input2 = new Scanner(arg2.toString()).useDelimiter("\\s*=\\s*");
            Scanner input3 = new Scanner(arg3.toString()).useDelimiter("\\s*=\\s*");
            Scanner input4 = new Scanner(arg4.toString()).useDelimiter("\\s*=\\s*");
            Scanner input5 = new Scanner(arg5.toString()).useDelimiter("\\s*=\\s*");


            ArrayList<String> arguments=new ArrayList<String>();

            arguments.add(input1.next());
            arguments.add(input1.next());
            arguments.add(input2.next());
            arguments.add(input2.next());
            arguments.add(input3.next());
            arguments.add(input3.next());
            arguments.add(input4.next());
            arguments.add(input4.next());
            arguments.add(input5.next());
            arguments.add(input5.next());

            for (int i=0;i<arguments.size();i=i+2){
                switch (arguments.get(i)){

                    case "NAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getFirstname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "LASTNAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getLastname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "AGE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getAge())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "ENTRANCEYEAR" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getEntranceYear())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "CODE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getInstructor_or_student_code())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "DEPARTMENT" : {
                        for (int j = 0; j < per.size(); j++) {
                            if (per.get(j) instanceof instructor){
                                if (arguments.get(i+1).equals(((instructor) per.get(j)).getDepartment())){
                                    NOT_SORTED_answer.add(per.get(j));
                                }
                            }
                        }
                        break;
                    }
                }
            }


            for (int i=0;i<NOT_SORTED_answer.size();i++){
                int count=0;
                for (int j=0;j< NOT_SORTED_answer.size();j++){
                    if (NOT_SORTED_answer.get(i).equals(NOT_SORTED_answer.get(j))){
                        count++;
                    }
                }
                if (count==num_arg){
                    SORTED_answer.add(NOT_SORTED_answer.get(i));
                }
            }

            LinkedHashSet<person> lhSet = new LinkedHashSet<person>( SORTED_answer );
            SORTED_answer.clear();
            SORTED_answer.addAll(lhSet);

            input.close();
            input1.close();
            input2.close();
            input3.close();
            input4.close();
            input5.close();
        }
        if (num_arg==6){
            StringBuilder parameter=new StringBuilder(arg);
            parameter.append(", ");
            Scanner input = new Scanner(parameter.toString()).useDelimiter(",\\s*");
            StringBuilder arg1=new StringBuilder(input.next());
            StringBuilder arg2=new StringBuilder(input.next());
            StringBuilder arg3=new StringBuilder(input.next());
            StringBuilder arg4=new StringBuilder(input.next());
            StringBuilder arg5=new StringBuilder(input.next());
            StringBuilder arg6=new StringBuilder(input.next());
            arg1.append(" = ");
            arg2.append(" = ");
            arg3.append(" = ");
            arg4.append(" = ");
            arg5.append(" = ");
            arg6.append(" = ");
            Scanner input1 = new Scanner(arg1.toString()).useDelimiter("\\s*=\\s*");
            Scanner input2 = new Scanner(arg2.toString()).useDelimiter("\\s*=\\s*");
            Scanner input3 = new Scanner(arg3.toString()).useDelimiter("\\s*=\\s*");
            Scanner input4 = new Scanner(arg4.toString()).useDelimiter("\\s*=\\s*");
            Scanner input5 = new Scanner(arg5.toString()).useDelimiter("\\s*=\\s*");
            Scanner input6 = new Scanner(arg6.toString()).useDelimiter("\\s*=\\s*");


            ArrayList<String> arguments=new ArrayList<String>();

            arguments.add(input1.next());
            arguments.add(input1.next());
            arguments.add(input2.next());
            arguments.add(input2.next());
            arguments.add(input3.next());
            arguments.add(input3.next());
            arguments.add(input4.next());
            arguments.add(input4.next());
            arguments.add(input5.next());
            arguments.add(input5.next());
            arguments.add(input6.next());
            arguments.add(input6.next());

            for (int i=0;i<arguments.size();i=i+2){
                switch (arguments.get(i)){

                    case "NAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getFirstname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "LASTNAME" :{
                        for(int j=0;j<per.size();j++){
                            if (arguments.get(i+1).equals(per.get(j).getLastname())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "AGE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getAge())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "ENTRANCEYEAR" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getEntranceYear())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "CODE" :{
                        Integer n=Integer.parseInt(arguments.get(i+1));
                        for(int j=0;j<per.size();j++){
                            if (n.equals(per.get(j).getInstructor_or_student_code())){
                                NOT_SORTED_answer.add(per.get(j));
                            }
                        }
                        break;
                    }
                    case "DEPARTMENT" : {
                        for (int j = 0; j < per.size(); j++) {
                            if (per.get(j) instanceof instructor){
                                if (arguments.get(i+1).equals(((instructor) per.get(j)).getDepartment())){
                                    NOT_SORTED_answer.add(per.get(j));
                                }
                            }
                        }
                        break;
                    }
                }
            }


            for (int i=0;i<NOT_SORTED_answer.size();i++){
                int count=0;
                for (int j=0;j< NOT_SORTED_answer.size();j++){
                    if (NOT_SORTED_answer.get(i).equals(NOT_SORTED_answer.get(j))){
                        count++;
                    }
                }
                if (count==num_arg){
                    SORTED_answer.add(NOT_SORTED_answer.get(i));
                }
            }

            LinkedHashSet<person> lhSet = new LinkedHashSet<person>( SORTED_answer );
            SORTED_answer.clear();
            SORTED_answer.addAll(lhSet);

            input.close();
            input1.close();
            input2.close();
            input3.close();
            input4.close();
            input5.close();
            input6.close();
        }
        return SORTED_answer;
    }
}
