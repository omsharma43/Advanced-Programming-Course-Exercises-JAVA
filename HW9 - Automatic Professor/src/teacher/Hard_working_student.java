package teacher;

public class Hard_working_student extends collegian{
    protected type_of_student typeStudent;
    public Hard_working_student(String NAME, String FIELD,type_of_student typeStudent) {
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