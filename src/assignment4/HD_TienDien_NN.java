package assignment4;

public class HD_TienDien_NN extends HD_TienDien_VN {

    private boolean foreigner;

    public HD_TienDien_NN() {

    }


    public HD_TienDien_NN(String IDCode, String fullName, int year, int month, int date, int amountKW, int intoMoney, boolean foreigner) {
        this.setIDCode(IDCode);
        this.setFullName(fullName);
        this.setYear(year);
        this.setMonth(month);
        this.setDate(date);
        this.setAmountKW(amountKW);
        this.setIntoMoney(intoMoney);
        this.foreigner = foreigner;
    }

    public boolean getForeigner() {
        return foreigner;
    }

    public void setForeigner(boolean foreigner) {
        this.foreigner = foreigner;
    }


    @Override
    public void electricityBill() {
        if(getForeigner() == true) {
            setIntoMoney(getAmountKW() * 2000);
            this.hienThi();
        } else {
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
}

