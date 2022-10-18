package assignment4;


public class HD_TienDien_VN extends HD_TienDien{

    private String typeCustomer;

    public HD_TienDien_VN(String IDCode, String fullName, int year, int month, int date, int amountKW, String typeCustomer) {
        super(IDCode, fullName, year, month, date, amountKW);
        this.typeCustomer = typeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
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
    @Override
    public double electricityBill(){
        int a = getAmountKW() / 50;
        int b = getAmountKW() % 50;// số kW vượt mức
        double thanhTien = b * excessMoney(a + 1);

        for(int i = 1; i <= a ; i++){
            thanhTien = thanhTien + 50 * excessMoney(i);
        }
        return thanhTien;

    }


}