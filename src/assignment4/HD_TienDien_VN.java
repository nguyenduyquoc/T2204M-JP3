package assignment4;

import java.util.Date;

public class HD_TienDien_VN {

    private String IDCode;
    private String fullName;
    // thuộc tính ngày/ tháng/ năm xuât hóa đơn
    private int year;
    private int month;
    private int date;

    private String typeCustomer;
    private int amountKW;

    private int intoMoney;


    // Khai báo không đối số
    public HD_TienDien_VN() {
    }

    // Khai báo có đối số
    public HD_TienDien_VN(String IDCode, String fullName,int year, int month, int date, String typeCustomer, int amountKW, int intoMoney) {
        this.IDCode = IDCode;
        this.fullName = fullName;
        this.year = year;
        this.month = month;
        this.date = date;
        this.typeCustomer = typeCustomer;
        this.amountKW = amountKW;
        this.intoMoney =intoMoney;
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

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public int getAmountKW() {
        return amountKW;
    }

    public void setAmountKW(int amountKW) {
        this.amountKW = amountKW;
    }

    public int getIntoMoney() {
        return intoMoney;
    }

    public void setIntoMoney(int intoMoney) {
        this.intoMoney = intoMoney;
    }


    public void hienThi() {
        System.out.println(getIDCode());
        System.out.println(getFullName());
        System.out.println(getYear() +"/" + getMonth() + "/" + getDate());
        System.out.println(getTypeCustomer());
        System.out.println(getAmountKW());
        System.out.println(getIntoMoney());
    }
    // tính số tiền vượt định mức
    public int excessMoney(int check) {
        if(check == 1) {
            return 1000;
        }
        if(check == 2) {
            return 1200;
        }
        if(check == 3 || check == 4) {
            return 1500;
        }
        return 2000;
    }

    // tính tổng số tiền điện phải trả
    public void electricityBill(){
        int a = getAmountKW() / 50;
        int b = getAmountKW() % 50;// số kW vượt mức
        int thanhTien = b * excessMoney(a + 1);

        for(int i = 1; i <= a ; i++){
            thanhTien = thanhTien + 50 * excessMoney(i);
        }
        this.setIntoMoney(thanhTien);
        this.hienThi();
    }

}
