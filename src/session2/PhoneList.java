package session2;

import java.util.ArrayList;

public class PhoneList {

    private String name;
    ArrayList<String> tel = new ArrayList<>();

    public PhoneList(String name, String phone) {
        this.name = name;
        this.tel = new ArrayList<>();
        this.tel.add(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTel() {
        return tel;
    }

    public void setTel(ArrayList<String> tel) {
        this.tel = tel;
    }
}
