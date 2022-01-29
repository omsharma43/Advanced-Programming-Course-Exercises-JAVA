package riazi;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class Main {

    public static boolean is_prime (long n){
        if (n==0){
            return false;
        }
        if (n==1){
            return false;
        }
        if (n<0){
            return false;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static ArrayList partition_of_sets(int length,String... ops){
        ArrayList<String> answer= new ArrayList<String>();
        if (length==1){
            for (int i=0;i< ops.length;i++)
                answer.add(ops[i]);
            return answer;
        }
        else {
            ArrayList<String> temporary=partition_of_sets(length-1,ops);
            for (int i=0;i<temporary.size();i++){
                for (int j=0;j< ops.length;j++){
                    answer.add(ops[j]+temporary.get(i));
                }
            }
        }
        return answer;
    }

    public static ArrayList legal_partitions (int length,String... ops){
        ArrayList<String> ANSWER=new ArrayList<String>();
        ArrayList<String> temporary=new ArrayList<String>();
        for (int i=0;i<length;i++){
            temporary.addAll(partition_of_sets(i+1,ops));
        }
        for (int i=0;i<temporary.size();i++){
            int sum=0;
            for (int j=0;j<temporary.get(i).length();j++)
                sum+=Integer.parseInt(String.valueOf(temporary.get(i).charAt(j)));
            if (sum==length)
                ANSWER.add(temporary.get(i));
        }
        return ANSWER;
    }

    static Scanner input=new Scanner(System.in);

    public static ArrayList find_and_check(ArrayList<String> legal_partition,ArrayList<String> partition_of_operators,String number,int length){
        ArrayList<String> FINAL_ANSWER=new ArrayList<String>();
        for (int i=0;i<legal_partition.size();i++){
            for (int j=0;j<partition_of_operators.size();j++){
                double result=0;
                Integer num=0;
                long Final_result=0;
                StringBuilder operation=new StringBuilder();
                if (legal_partition.get(i).length()-1 == partition_of_operators.get(j).length()){

                    for (int m=0;m<legal_partition.get(i).length()-1;m++){
                        operation.append("(");
                    }

                    num=Integer.parseInt(number.substring(0,Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(0)))));
                    operation.append(num.toString());
                    result+=(double)num;
                    int index=Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(0)));

                    for (int n=0;n<partition_of_operators.get(j).length();n++){
                        switch (partition_of_operators.get(j).charAt(n)){
                            case '+':{
                                operation.append("+");
                                num=Integer.parseInt(number.substring(index,index+Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)))));
                                index+=Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)));
                                operation.append(num.toString());
                                operation.append(")");
                                result+=(double)num;
                                break;
                            }
                            case '-':{
                                operation.append("-");
                                num=Integer.parseInt(number.substring(index,index+Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)))));
                                index+=Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)));
                                operation.append(num.toString());
                                operation.append(")");
                                result-=(double)num;
                                break;
                            }
                            case '*':{
                                operation.append("*");
                                num=Integer.parseInt(number.substring(index,index+Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)))));
                                index+=Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)));
                                operation.append(num.toString());
                                operation.append(")");
                                result*=(double)num;
                                break;
                            }
                            case '/':{
                                operation.append("/");
                                num=Integer.parseInt(number.substring(index,index+Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)))));
                                index+=Integer.parseInt(String.valueOf(legal_partition.get(i).charAt(n+1)));
                                operation.append(num.toString());
                                operation.append(")");
                                result/=(double)num;
                                break;
                            }
                        }
                    }

                    Final_result=(long)result;
                    if (is_prime(Final_result)){
                        operation.append(" $ ");
                        operation.append(Final_result);
                        FINAL_ANSWER.add(operation.toString());
                    }

                }

            }
        }
        return FINAL_ANSWER;
    }

    public static void main(String[] args) {
        ArrayList<String> FINAL_ANSWER=new ArrayList<String>();
        String number=input.nextLine();
        int length=number.length();

        String number_ops[]=new String[length-1];
        for (Integer i=0,j=1;i<length-1 && j<length;i++,j++){
            number_ops[i]=Integer.toString(j);
        }
        ArrayList<String> legal_partition=legal_partitions(length,number_ops);

        ArrayList<String> partition_of_operators=new ArrayList<String>();
        for (int i=0;i<length-1;i++){
            partition_of_operators.addAll(partition_of_sets(i+1,"/","*","-","+"));
        }

        FINAL_ANSWER=find_and_check(legal_partition,partition_of_operators,number,length);

        if (FINAL_ANSWER.isEmpty()){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
            for (int i = 0; i < FINAL_ANSWER.size(); i++) {
                System.out.println(FINAL_ANSWER.get(i));
            }
        }
    }
}
