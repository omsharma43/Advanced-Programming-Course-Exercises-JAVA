package teacher;

public class Zohuri extends Professor {
    public Zohuri() {
        super("Zohuri");
    }
    @Override
    void reaction(collegian Collegian){
        if (Collegian instanceof Hard_working_student){
            System.out.print("Zohuri : ");
            System.out.print(Collegian.getName());
            System.out.print(" , I Like you , you have great future .");
            System.out.println();
        }
        if (Collegian instanceof Normal_student){
            System.out.print("Zohuri : ");
            System.out.print(Collegian.getName());
            System.out.print(" , Because of your effort I appreciate you .");
            System.out.println();
        }
        if (Collegian instanceof Weak_student){
            System.out.print("Zohuri : ");
            System.out.print(Collegian.getName());
            System.out.print(" , please work harder , I believe , you can succeed in ");
            System.out.print(Collegian.getUniversityField());
            System.out.print(" course .");
            System.out.println();
        }
    }
}