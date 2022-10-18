package assignment4;

import java.awt.*;

public class HD_TienDien_NN extends HD_TienDien {

    private String country;

    public HD_TienDien_NN(String IDCode, String fullName, int year, int month, int date, int amountKW, String country) {
        super(IDCode, fullName, year, month, date, amountKW);
        this.country = country;
    }

    @Override
    public double electricityBill() {
        return super.electricityBill();
    }
}

