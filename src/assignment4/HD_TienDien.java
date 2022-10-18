package assignment4;

public class HD_TienDien {
    private String IDCode;
    private String fullName;
    // thuộc tính ngày/ tháng/ năm xuât hóa đơn
    private int year;
    private int month;
    private int date;

    private int amountKW;


    // Khai báo không đối số


    // Khai báo có đối số
    public HD_TienDien(String IDCode, String fullName,int year, int month, int date, int amountKW) {
        this.IDCode = IDCode;
        this.fullName = fullName;
        this.year = year;
        this.month = month;
        this.date = date;
        this.amountKW = amountKW;
    }

    public String getIDCode() {
        return IDCode;
    }

    public void setIDCode(String IDCode) {
        this.IDCode = IDCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }


    public int getAmountKW() {
        return amountKW;
    }

    public void setAmountKW(int amountKW) {
        this.amountKW = amountKW;
    }


    public double electricityBill(){
        return 2000* getAmountKW();
    }

}
