package assignment5_javafx2;

public class Contact {

    private String fullName;
    private String email;
    private String address;
    private String age;
    private String phoneNumber;

    public Contact(String fullName, String email, String address, String age, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.fullName + "---" + this.email + "---" + this.address + "---" + this.age + "---" + this.phoneNumber;
    }
}
