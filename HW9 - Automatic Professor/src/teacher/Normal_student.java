package teacher;

public class Normal_student extends collegian{
    protected type_of_student typeStudent;
    public Normal_student(String NAME, String FIELD,type_of_student typeStudent) {
        super(NAME, FIELD);
        this.typeStudent=typeStudent;
    }
    public type_of_student getTypeStudent() {
        return typeStudent;
    }
    public void setTypeStudent(type_of_student typeStudent) {
        this.typeStudent = typeStudent;
    }
}