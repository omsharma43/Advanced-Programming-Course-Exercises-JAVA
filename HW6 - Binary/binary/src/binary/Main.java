package binary;

import javax.print.attribute.EnumSyntax;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.IOException;

public class Main {

    static int binary_to_int (String num){
        int number=0;
        StringBuilder REV_NUM=new StringBuilder(num);
        for (int i=0;i<8;i++){
            if (i==0){
                if (num.charAt(i)==49){
                    REV_NUM.delete(0,8);
                    REV_NUM=operator_minus(num);
                }
            }
            else {
                if (REV_NUM.charAt(i)==49 && i==1){
                    number+=64;
                }
                if (REV_NUM.charAt(i)==49 && i==2){
                    number+=32;
                }
                if (REV_NUM.charAt(i)==49 && i==3){
                    number+=16;
                }
                if (REV_NUM.charAt(i)==49 && i==4){
                    number+=8;
                }
                if (REV_NUM.charAt(i)==49 && i==5){
                    number+=4;
                }
                if (REV_NUM.charAt(i)==49 && i==6){
                    number+=2;
                }
                if (REV_NUM.charAt(i)==49 && i==7){
                    number+=1;
                }
            }
        }
        if (num.charAt(0)==49){
            number=-number;
        }
        return number;
    }

    //OUR OVERFLOW STATEMENT
    public static boolean overflow_sum(StringBuilder NUM1, StringBuilder NUM2,StringBuilder SUM) {
        if (SUM.length()>8){
            return true;
        }
        int number1=binary_to_int(NUM1.toString());
        int number2=binary_to_int(NUM2.toString());
        int sum= number1+number2;
        return sum > 127 || sum < -128;
    }

    public static ArrayList sum(ArrayList<String> NUM) {
        ArrayList<String> ANSWER = new ArrayList<String>();
        char change = '0';
        char sum_of_char = '0';
        Continue:
        for (int i = 0; i < NUM.size(); i = i + 2) {
            StringBuilder SUM = new StringBuilder();
            StringBuilder num1 = new StringBuilder(NUM.get(i));
            StringBuilder num2 = new StringBuilder(NUM.get(i + 1));

            if (num1.charAt(0)==49 && num2.charAt(0)==49){
                num1=operator_minus(num1.toString());
                num2=operator_minus(num2.toString());
            }

            if ( (NUM.get(i).charAt(0)==49 || NUM.get(i+1).charAt(0)==49) && (binary_to_int(NUM.get(i))+binary_to_int(NUM.get(i+1)) > 0) ){
                stop2:
                for (int m = 7; m > -1; m--) {
                    sum_of_char = (char) (num1.charAt(m) + num2.charAt(m) + change - '0' - '0');
                    if (m == 0 && sum_of_char >= 50) {
                        if (sum_of_char == 50) {
                            SUM.append('0');
                            change = '1';
                        }
                        if (sum_of_char == 51) {
                            SUM.append('1');
                            change = '1';
                        }
                        if (change==49){
                            SUM.append(change);
                        }
                        change='0';
                        break stop2;
                    }
                    //main op
                    else {
                        if (sum_of_char >= 50) {
                            if (sum_of_char == 50) {
                                SUM.append('0');
                                change = '1';
                            }
                            if (sum_of_char == 51) {
                                SUM.append('1');
                                change = '1';
                            }
                        }
                        else {
                            SUM.append(sum_of_char);
                            change = '0';
                        }
                    }
                    sum_of_char='0';
                }
                SUM.deleteCharAt(0);
                if (overflow_sum(num1,num2,SUM)){
                    ANSWER.add("OVERFLOW");
                    ANSWER.add("0");
                    continue Continue;
                }
                if (!overflow_sum(num1, num2,SUM)){
                    SUM.reverse();
                    ANSWER.add(SUM.toString());
                    Integer sum_not_binary=binary_to_int(SUM.toString());
                    ANSWER.add(sum_not_binary.toString());
                    continue Continue;
                }
            }

            stop1:
            for (int m = 7; m > -1; m--) {
                sum_of_char = (char) (num1.charAt(m) + num2.charAt(m) + change - '0' - '0');
                if (m == 0 && sum_of_char >= 50) {
                    if (sum_of_char == 50) {
                        SUM.append('0');
                        change = '1';
                    }
                    if (sum_of_char == 51) {
                        SUM.append('1');
                        change = '1';
                    }
                    if (change==49){
                        SUM.append(change);
                    }
                    change='0';
                    break stop1;
                }
                //main op
                else {
                    if (sum_of_char >= 50) {
                        if (sum_of_char == 50) {
                            SUM.append('0');
                            change = '1';
                        }
                        if (sum_of_char == 51) {
                            SUM.append('1');
                            change = '1';
                        }
                    }
                    else {
                        SUM.append(sum_of_char);
                        change = '0';
                    }
                }
                sum_of_char='0';
            }
            if (overflow_sum(num1,num2,SUM)){
                ANSWER.add("OVERFLOW");
                ANSWER.add("0");
                continue Continue;
            }
            if (!overflow_sum(num1, num2,SUM)){
                SUM.reverse();
                if (NUM.get(i).charAt(0)==49 && NUM.get(i+1).charAt(0)==49){
                    SUM=operator_minus(SUM.toString());
                }
                ANSWER.add(SUM.toString());
                Integer sum_not_binary=binary_to_int(SUM.toString());
                ANSWER.add(sum_not_binary.toString());
                continue Continue;
            }
        }
        return ANSWER;
    }

    public static StringBuilder operator_minus(String BINARY_NUM) {
        StringBuilder change_bin_num = new StringBuilder(BINARY_NUM);
        stop:
        for (int i = BINARY_NUM.length() - 1; i > -1; i--) {
            if (BINARY_NUM.charAt(i) == 49) {
                for (int j = i - 1; j > -1; j--) {
                    if (BINARY_NUM.charAt(j) == 48) {
                        change_bin_num.setCharAt(j, '1');
                    }
                    if (BINARY_NUM.charAt(j) == 49) {
                        change_bin_num.setCharAt(j, '0');
                    }
                }
                break stop;
            }
        }
        return change_bin_num;
    }

    public static StringBuilder change_the_number_of_bits (String num,int bits){
        StringBuilder number= new StringBuilder(num);
        number.reverse();
        int add=bits-num.length();
        for (int i=0;i<add;i++){
            number.append('0');
        }
        number.reverse();
        return number;
    }

    public static StringBuilder partial_operation(char number,StringBuilder num,int level){
        StringBuilder Answer=new StringBuilder();
        if (number==48){
            if (level==1){
                Answer.append("00000000");
            }
            if (level==2){
                Answer.append("00000000");
                Answer.append('0');
            }
            if (level==3){
                Answer.append("00000000");
                Answer.append("00");
            }
            if (level==4){
                Answer.append("00000000");
                Answer.append("000");
            }
            if (level==5){
                Answer.append("00000000");
                Answer.append("0000");
            }
            if (level==6){
                Answer.append("00000000");
                Answer.append("00000");
            }
            if (level==7){
                Answer.append("00000000");
                Answer.append("000000");
            }
            if (level==8){
                Answer.append("00000000");
                Answer.append("0000000");
            }
        }
        if (number==49){
            if (level==1){
                Answer.append(num.toString());
            }
            if (level==2){
                Answer.append(num.toString());
                Answer.append('0');
            }
            if (level==3){
                Answer.append(num.toString());
                Answer.append("00");
            }
            if (level==4){
                Answer.append(num.toString());
                Answer.append("000");
            }
            if (level==5){
                Answer.append(num.toString());
                Answer.append("0000");
            }
            if (level==6){
                Answer.append(num.toString());
                Answer.append("00000");
            }
            if (level==7){
                Answer.append(num.toString());
                Answer.append("000000");
            }
            if (level==8){
                Answer.append(num.toString());
                Answer.append("0000000");
            }
        }
        return Answer;
    }

    public static StringBuilder partial_plus_operator(String NUMBER1,String NUMBER2){
        StringBuilder ANSWER=new StringBuilder();

        StringBuilder NUM1=new StringBuilder();
        StringBuilder NUM2=new StringBuilder();

        if (NUMBER1.length() != NUMBER2.length()){
            if (NUMBER1.length() > NUMBER2.length()){
                int bit=Math.abs(NUMBER1.length()-NUMBER2.length())+NUMBER2.length();
                NUM1.append(NUMBER1);
                NUM2=change_the_number_of_bits(NUMBER2,bit);
            }
            if (NUMBER1.length() < NUMBER2.length()){
                int bit=Math.abs(NUMBER2.length()-NUMBER1.length())+NUMBER1.length();
                NUM1=change_the_number_of_bits(NUMBER1,bit);
                NUM2.append(NUMBER2);
            }
        }
        if (NUMBER1.length() == NUMBER2.length()){
            NUM1.append(NUMBER1);
            NUM2.append(NUMBER2);
        }

        char change = '0';
        char sum_of_char = '0';

        stop3:
        for (int i=NUM1.length()-1;i>-1;i--){
            sum_of_char = (char) (NUM1.charAt(i) + NUM2.charAt(i) + change - '0' - '0');
            if (i == 0 && sum_of_char >= 50) {
                if (sum_of_char == 50) {
                    ANSWER.append('0');
                    change = '1';
                }
                if (sum_of_char == 51) {
                    ANSWER.append('1');
                    change = '1';
                }
                if (change==49){
                    ANSWER.append(change);
                }
                change='0';
                break stop3;
            }
            //main op
            else {
                if (sum_of_char >= 50) {
                    if (sum_of_char == 50) {
                        ANSWER.append('0');
                        change = '1';
                    }
                    if (sum_of_char == 51) {
                        ANSWER.append('1');
                        change = '1';
                    }
                }
                else {
                    ANSWER.append(sum_of_char);
                    change = '0';
                }
            }
            sum_of_char='0';
        }
        ANSWER.reverse();
        return ANSWER;
    }

    public static ArrayList PARTIAL(ArrayList<String> par){
        ArrayList<String> ANSWER = new ArrayList<String>();

        StringBuilder NUMBER_1=new StringBuilder(par.get(0));
        StringBuilder NUMBER_2=new StringBuilder(par.get(1));
        StringBuilder SUM_ANSWER=new StringBuilder();

        StringBuilder level_1=new StringBuilder();
        StringBuilder level_2=new StringBuilder();
        StringBuilder level_3=new StringBuilder();
        StringBuilder level_4=new StringBuilder();
        StringBuilder level_5=new StringBuilder();
        StringBuilder level_6=new StringBuilder();
        StringBuilder level_7=new StringBuilder();
        StringBuilder level_8=new StringBuilder();

        for (int i=7;i>-1;i--){
            if (i==7){
                level_1=partial_operation(NUMBER_2.charAt(i),NUMBER_1,1 );
            }
            if (i==6){
                level_2=partial_operation(NUMBER_2.charAt(i),NUMBER_1,2 );
            }
            if (i==5){
                level_3=partial_operation(NUMBER_2.charAt(i),NUMBER_1,3 );
            }
            if (i==4){
                level_4=partial_operation(NUMBER_2.charAt(i),NUMBER_1,4 );
            }
            if (i==3){
                level_5=partial_operation(NUMBER_2.charAt(i),NUMBER_1,5 );
            }
            if (i==2){
                level_6=partial_operation(NUMBER_2.charAt(i),NUMBER_1,6 );
            }
            if (i==1){
                level_7=partial_operation(NUMBER_2.charAt(i),NUMBER_1,7 );
            }
            if (i==0){
                level_8=partial_operation(NUMBER_2.charAt(i),NUMBER_1,8 );
            }
        }

        StringBuilder sum1_level1=new StringBuilder();
        StringBuilder sum2_level1=new StringBuilder();
        StringBuilder sum3_level1=new StringBuilder();
        StringBuilder sum4_level1=new StringBuilder();

        StringBuilder sum1_level2=new StringBuilder();
        StringBuilder sum2_level2=new StringBuilder();

        StringBuilder sum=new StringBuilder();

        for (int i=0;i<3;i++){
            if (i==0){
                sum1_level1=partial_plus_operator(level_1.toString(),level_2.toString());
                sum2_level1=partial_plus_operator(level_3.toString(),level_4.toString());
                sum3_level1=partial_plus_operator(level_5.toString(),level_6.toString());
                sum4_level1=partial_plus_operator(level_7.toString(),level_8.toString());
            }
            if (i==1){
                sum1_level2=partial_plus_operator(sum1_level1.toString(),sum2_level1.toString());
                sum2_level2=partial_plus_operator(sum3_level1.toString(),sum4_level1.toString());
            }
            if (i==2){
                sum=partial_plus_operator(sum1_level2.toString(),sum2_level2.toString());
                SUM_ANSWER=sum;
            }
        }
        int bit=SUM_ANSWER.length();
        bit=bit-8;
        for (int i=0;i<bit;i++){
            SUM_ANSWER.deleteCharAt(0);
        }
        ANSWER.add(SUM_ANSWER.toString());
        Integer nb_num=binary_to_int(SUM_ANSWER.toString());
        ANSWER.add(nb_num.toString());
        return ANSWER;
    }

    public static ArrayList symmetrical (String REV){
        StringBuilder NUM=operator_minus(REV);
        Integer NB_number=binary_to_int(NUM.toString());
        ArrayList<String> SYMMETRICAL=new ArrayList<String>();
        SYMMETRICAL.add(NUM.toString());
        SYMMETRICAL.add(NB_number.toString());
        return SYMMETRICAL;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> SUM_OF_NUMBERS=new ArrayList<String>();
        ArrayList<String> PARTIAL_OF_NUMBERS=new ArrayList<String>();
        StringBuilder SYMMETRICAL=new StringBuilder();

        for (int i=0;i<2;i++){
            String op=input.nextLine();
            String number= input.nextLine();
            StringBuilder NEW_num=new StringBuilder(number);
            if (number.length()<8){
                if(op.equals("+")){
                    NEW_num=change_the_number_of_bits(number,8);
                }
                if (op.equals("-")){
                    StringBuilder number1= new StringBuilder(number);
                    number1.reverse();
                    int add=8-number.length();
                    for (int j=0;j<add;j++){
                        number1.append('1');
                    }
                    number1.reverse();
                    NEW_num=number1;
                }
            }
            SUM_OF_NUMBERS.add(NEW_num.toString());
        }

        for (int i=0;i<2;i++){
            String op=input.nextLine();
            String number= input.nextLine();
            StringBuilder NEW_num=new StringBuilder(number);
            if (number.length()<8){
                if(op.equals("+")){
                    NEW_num=change_the_number_of_bits(number,8);
                }
                if (op.equals("-")){
                    StringBuilder number1= new StringBuilder(number);
                    number1.reverse();
                    int add=8-number.length();
                    for (int j=0;j<add;j++){
                        number1.append('1');
                    }
                    number1.reverse();
                    NEW_num=number1;
                }
            }
            PARTIAL_OF_NUMBERS.add(NEW_num.toString());
        }

        for (int i=0;i<1;i++){
            String op=input.nextLine();
            String number= input.nextLine();
            StringBuilder NEW_num=new StringBuilder(number);
            if (number.length()<8){
                if(op.equals("+")){
                    NEW_num=change_the_number_of_bits(number,8);
                }
                if (op.equals("-")){
                    StringBuilder number1= new StringBuilder(number);
                    number1.reverse();
                    int add=8-number.length();
                    for (int j=0;j<add;j++){
                        number1.append('1');
                    }
                    number1.reverse();
                    NEW_num=number1;
                }
            }
            SYMMETRICAL=NEW_num;
        }

        ArrayList<String> SUM_ANSWER=new ArrayList<String>();
        ArrayList<String> PARTIAL_ANSWER=new ArrayList<String>();
        ArrayList<String> SYMMETRICAL_ANSWER=new ArrayList<String>();

        SUM_ANSWER=sum(SUM_OF_NUMBERS);
        PARTIAL_ANSWER=PARTIAL(PARTIAL_OF_NUMBERS);
        SYMMETRICAL_ANSWER=symmetrical(SYMMETRICAL.toString());

        if (SUM_ANSWER.get(0).equals("OVERFLOW")){
            System.out.println(SUM_ANSWER.get(0));
        }
        else {
            System.out.println(SUM_ANSWER.get(0));
            System.out.println(SUM_ANSWER.get(1));
        }

        System.out.println(PARTIAL_ANSWER.get(0));
        System.out.println(PARTIAL_ANSWER.get(1));

        System.out.println(SYMMETRICAL_ANSWER.get(0));
        System.out.println(SYMMETRICAL_ANSWER.get(1));
    }
}