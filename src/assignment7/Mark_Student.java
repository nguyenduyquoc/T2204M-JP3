package assignment7;

public class Mark_Student {
    private String name;
    private String email;
    private int mark;
    private String gender;

    public Mark_Student(String name, String email, int mark, String gender) {
        this.name = name;
        this.email = email;
        this.mark = mark;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return "\t" + this.name + "\n" + "\t" + this.email +  "\n" + "\t" + + this.mark + "\n" + "\t" +this.gender;
    }
}