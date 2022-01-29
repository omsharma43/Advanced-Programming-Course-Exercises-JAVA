

import java.util.*;
import java.io.*;
import java.lang.String;
import java.io.IOException;

public class Main {
    public static String rome_num (int number){
        int M=number/1000;
        number=number%1000;

        int D=number/500;
        number=number%500;

        int C=number/100;
        number=number%100;

        int L=number/50;
        number=number%50;

        int X=number/10;
        number=number%10;

        int V=number/5;
        number=number%5;

        int I=number/1;
        number=number%1;

        String ROMAN_NUM = null;

        if (M>0){
            ROMAN_NUM="M";
            for (int i=0;i<M-1;i++){
                ROMAN_NUM=ROMAN_NUM + "M";
            }
            if (D>0){
                for (int i=0;i<D;i++){
                    ROMAN_NUM=ROMAN_NUM + "D";
                }
            }
            if (C>0){
                for (int i=0;i<C;i++){
                    ROMAN_NUM=ROMAN_NUM + "C";
                }
            }
            if (L>0){
                for (int i=0;i<L;i++){
                    ROMAN_NUM=ROMAN_NUM + "L";
                }
            }
            if (X>0){
                for (int i=0;i<X;i++){
                    ROMAN_NUM=ROMAN_NUM + "X";
                }
            }
            if (V>0){
                for (int i=0;i<V;i++){
                    ROMAN_NUM=ROMAN_NUM + "V";
                }
            }
            if (I>0){
                for (int i=0;i<I;i++){
                    ROMAN_NUM=ROMAN_NUM + "I";
                }
            }
            D=0;
            C=0;
            L=0;
            X=0;
            V=0;
            I=0;
        }
        if (D>0){
            ROMAN_NUM="D";
            for (int i=0;i<D-1;i++){
                ROMAN_NUM=ROMAN_NUM + "D";
            }
            if (C>0){
                for (int i=0;i<C;i++){
                    ROMAN_NUM=ROMAN_NUM + "C";
                }
            }
            if (L>0){
                for (int i=0;i<L;i++){
                    ROMAN_NUM=ROMAN_NUM + "L";
                }
            }
            if (X>0){
                for (int i=0;i<X;i++){
                    ROMAN_NUM=ROMAN_NUM + "X";
                }
            }
            if (V>0){
                for (int i=0;i<V;i++){
                    ROMAN_NUM=ROMAN_NUM + "V";
                }
            }
            if (I>0){
                for (int i=0;i<I;i++){
                    ROMAN_NUM=ROMAN_NUM + "I";
                }
            }
            C=0;
            L=0;
            X=0;
            V=0;
            I=0;
        }
        if (C>0){
            ROMAN_NUM="C";
            for (int i=0;i<C-1;i++){
                ROMAN_NUM=ROMAN_NUM + "C";
            }
            if (L>0){
                for (int i=0;i<L;i++){
                    ROMAN_NUM=ROMAN_NUM + "L";
                }
            }
            if (X>0){
                for (int i=0;i<X;i++){
                    ROMAN_NUM=ROMAN_NUM + "X";
                }
            }
            if (V>0){
                for (int i=0;i<V;i++){
                    ROMAN_NUM=ROMAN_NUM + "V";
                }
            }
            if (I>0){
                for (int i=0;i<I;i++){
                    ROMAN_NUM=ROMAN_NUM + "I";
                }
            }
            L=0;
            X=0;
            V=0;
            I=0;
        }
        if (L>0){
            ROMAN_NUM="L";
            for (int i=0;i<L-1;i++){
                ROMAN_NUM=ROMAN_NUM + "L";
            }
            if (X>0){
                for (int i=0;i<X;i++){
                    ROMAN_NUM=ROMAN_NUM + "X";
                }
            }
            if (V>0){
                for (int i=0;i<V;i++){
                    ROMAN_NUM=ROMAN_NUM + "V";
                }
            }
            if (I>0){
                for (int i=0;i<I;i++){
                    ROMAN_NUM=ROMAN_NUM + "I";
                }
            }
            X=0;
            V=0;
            I=0;
        }
        if (X>0){
            ROMAN_NUM="X";
            for (int i=0;i<X-1;i++){
                ROMAN_NUM=ROMAN_NUM + "X";
            }
            if (V>0){
                for (int i=0;i<V;i++){
                    ROMAN_NUM=ROMAN_NUM + "V";
                }
            }
            if (I>0){
                for (int i=0;i<I;i++){
                    ROMAN_NUM=ROMAN_NUM + "I";
                }
            }
            V=0;
            I=0;
        }
        if (V>0){
            ROMAN_NUM="V";
            for (int i=0;i<V-1;i++){
                ROMAN_NUM=ROMAN_NUM + "V";
            }
            if (I>0){
                for (int i=0;i<I;i++){
                    ROMAN_NUM=ROMAN_NUM + "I";
                }
            }
            I=0;
        }
        if (I>0){
            ROMAN_NUM="I";
            for (int i=0;i<I-1;i++){
                ROMAN_NUM=ROMAN_NUM + "I";
            }
        }
        return ROMAN_NUM;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String number_seq;
        number_seq=input.nextLine();
        for (int i=0;i<number_seq.length();++i){
            char test=number_seq.charAt(i);
            if (test<48 || test>57){
                System.out.println("ERROR");
                System.exit(0);
            }
        }
        int number=Integer.parseInt(number_seq);
        String ANSWER=rome_num(number);
        System.out.println(ANSWER);
    }
}
