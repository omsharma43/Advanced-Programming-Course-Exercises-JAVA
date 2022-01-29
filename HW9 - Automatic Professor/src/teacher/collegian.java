package teacher;

public class collegian{
    protected String name;
    protected String universityField;

    public collegian(String NAME,String FIELD){
        this.name=NAME;
        this.universityField=FIELD;
    }
    public String getName() {
        return name;
    }
    public String getUniversityField() {
        return universityField;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUniversityField(String universityField) {
        this.universityField = universityField;
    }
}
