
import java.util.Scanner;
import java.math.*;
import java.lang.String;
public class Main {

    //factorial equation for our formula
    static double facrorial (int num){
        double result=1;
        for (int i=2;i<=num;i++){
            result*=i;
        }
        return result;
    }

    //taylor series main function
    static double taylor(double degree){
        int i;
        //final result calculator
        double sum=0;
        //exchange degree with radian
        double radian= (double)degree*(Math.PI/180.0);
        radian%=2*Math.PI;
        //main equation
        for(i=0;i<10;++i){
            sum+=Math.pow(-1,i)*(Math.pow(radian,2*i+1))/facrorial(2*i+1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        //input the degree of sin(x)
	    double degree = input.nextDouble();
	    //print the result
        System.out.printf("%.2f",taylor(degree));
    }
}
