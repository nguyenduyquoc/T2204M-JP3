package assignment3;

import assignment2.Account;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Account[] accounts = new Account[3];
        accounts[0] = new Account();
        accounts[1] = new Account();
        accounts[2] = new Account();

        Account[] accounts11 = new Account[4];
        double[] arr2 = new double[4];

        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 30;
        arr[2] = 29;
        arr[3] = 25;
        arr[4] = 15;

        ArrayList<Account> aArr = new ArrayList<>();
        // Thêm 5 phần tử...
        aArr.add(new Account());
        aArr.add(new Account());
        aArr.add(new Account());
        aArr.add(new Account());
        aArr.add(new Account());
        aArr.get(0).credit(40000);

        for(int i = 0 ; i < aArr.size(); i++){
            aArr.get(i).credit(30000);
        }

        for(Account fx :aArr){
            fx.credit(30000); // fx = aArr[i]
        }


        ArrayList<String> strArr = new ArrayList<>();
        ArrayList<Integer> intArr = new ArrayList<>();


    }
}
