package assignment6_javafx;

public class Mark_Student {
    private String name;
    private String email;
    private int mark;

    public Mark_Student(String name, String email, int mark) {
        this.name = name;
        this.email = email;
        this.mark = mark;
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

    public String toString(){
        return this.name + "---" + this.email +  "---" + this.mark;
    }
}
