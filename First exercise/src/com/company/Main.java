
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        int number=in.nextInt();
        int i;
        int sum=0;
        //loop for finding all factors and sum them to check that they are equal to number or not
        for(i=1;i<number;++i) {
            if(number%i==0) {
                sum+=i;
            }
        }
        //now we check equality
        if(sum==number)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
