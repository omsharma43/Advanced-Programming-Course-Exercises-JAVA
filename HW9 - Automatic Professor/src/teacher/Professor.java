package teacher;

public class Professor{
    protected String name;
    public Professor (String name_of_Professor){
        this.name=name_of_Professor;
    }
    void reaction(collegian Collegian){
        System.out.print(getName());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
