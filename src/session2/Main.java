package session2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        PhoneBook pb1 = new PhoneBook();
        pb1.insertPhone("Nguyen Duy Quoc", "111111111");
        pb1.insertPhone("Nguyen Duy Khanh", "222222222");
        pb1.insertPhone("Nguyen Duy Vuong", "333333333");
        pb1.insertPhone("Nguyen Duy Phuong", "444444444");
        pb1.insertPhone("Lionel Messi", "555555555");
        pb1.insertPhone("Neymar Jr", "666666666");

        pb1.removePhone("Neymar Jr");

        pb1.insertPhone("Nguyen Duy Quoc", "111111111");
        pb1.insertPhone("Nguyen Duy Quoc", "111112222");

        pb1.updatePhone("Nguyen Duy Quoc","111111111", "2222211111");

        ArrayList<PhoneList> phoneArr = pb1.getPhoneArr();
        for (int i = 0; i < phoneArr.size(); i++) {
            System.out.println(phoneArr.get(i).getName());
            System.out.println(phoneArr.get(i).tel);
        }

        pb1.searchPhone("Nguyen Duy Quoc");
        pb1.sort();


    }
}
