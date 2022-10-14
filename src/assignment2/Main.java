package assignment2;

public class Main {
    public static void main(String[] args){

        Account ac1 = new Account(1 , "Giang", 100000);
        ac1.credit(200000);
        ac1.debit(50000);
        ac1.debit(-20000);

        Account ac2 = new Account(2, "Quoc", 50000);

        ac1.tranferTo(ac2,50000);
        ac1.tranferTo(ac2, 200000);

    }
}
