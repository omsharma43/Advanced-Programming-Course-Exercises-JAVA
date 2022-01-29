
import java.util.Scanner;
public class soal2 {
    public static void main(String[] args) {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        //number of our triangle rows
        int rows=in.nextInt();
        //for our rows
        int number=1;
        //loop for print our numeric triangle
        int i;
        int j;
        for(i=1;i<=rows;++i){
            for(j=1;j<=i;++j){
                System.out.printf("%d " ,number);
                ++number;
            }
            System.out.println(" ");
        }
    }
}
