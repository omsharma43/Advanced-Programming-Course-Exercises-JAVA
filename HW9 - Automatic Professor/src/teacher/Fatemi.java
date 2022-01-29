package teacher;

public class Fatemi extends Professor {
    public Fatemi() {
        super("Fatemi");
    }
    @Override
    void reaction(collegian Collegian){
        if (Collegian instanceof Hard_working_student){
            System.out.print("fatemi : ");
            System.out.print(Collegian.getName());
            System.out.print(" , I think you can deliver the exercises faster .");
            System.out.println();
        }
        if (Collegian instanceof Normal_student){
            System.out.print("fatemi : ");
            System.out.print(Collegian.getName());
            System.out.print(" , You are at the lowest acceptance level to continue the course ");
            System.out.print(Collegian.getUniversityField());
            System.out.print(" .");
            System.out.println();
        }
        if (Collegian instanceof Weak_student){
            System.out.print("fatemi : ");
            System.out.print(Collegian.getName());
            System.out.print(" , Will you delete ");
            System.out.print(Collegian.getUniversityField());
            System.out.print(" yourself or will I do it for you?");
            System.out.println();
        }
    }
}