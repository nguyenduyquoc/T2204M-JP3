package assignment3;

import assignment2.Account;

public class AccountT2204M extends Account {
    public String address;

    public AccountT2204M(){

    }
    public AccountT2204M (int id, String name , int balance,String address){
        super(id, name, balance);
        this.address = address;
    }
    // hàm ghi đè
    @Override
    public  void credit(int amount){

        if (amount > 0) {
            this.setBalance(this.getBalance() + amount);
        } else {
            System.out.println("Số tiền bạn muốn chuyển phải là số dương...");
        }
        this.hienThi();
    }
}
