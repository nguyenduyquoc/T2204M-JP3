package assignment2;

public class Account {
    public int id;
    public String name;
    public  int  balance = 0;

    public Account() {
        id = 0;
        name = "Quoc";
        balance = 0;

    }

    public Account(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void hienThi(){
        System.out.println(getId());
        System.out.println(getName());
        System.out.println(getBalance());
    }

    public  void credit(int amount){

        if (amount > 0) {
            this.setBalance(this.getBalance() + amount);
        } else {
            System.out.println("Bạn phải nhập số dương...");
        }
        this.hienThi();

    }

    public void debit(int amount){
        if (amount > 0 && amount <= getBalance()){
            this.setBalance(this.getBalance() - amount);
        } else {
            System.out.println("Thanh toán không thành công...");
        }
        this.hienThi();
    }

    public void tranferTo(Account ac, int amount){
        if(amount >0 && amount <= this.getBalance()) {
            this.setBalance(getBalance() - amount);
            ac.setBalance(ac.getBalance() + amount);
        } else {
            System.out.println("Chuyển tiền không thành công...");
        }
        this.hienThi();
        ac.hienThi();
    }

}
