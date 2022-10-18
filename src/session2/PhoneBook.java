package session2;

import java.util.ArrayList;

public class PhoneBook extends Phone{


    ArrayList<PhoneList> phoneArr= new ArrayList<>();




    @Override
    public void insertPhone(String name, String phone) {
        int dem = 0;
        for(int i = 0; i <phoneArr.size();i++ ){
            if (name != phoneArr.get(i).getName()){
                dem++;
            } else {

            }
        }
        if (dem == 0) {
            this.phoneArr.add(new PhoneList(name, phone));

        }
    }

    @Override
    public void removePhone(String name) {

    }

    @Override
    public void updatePhone(String name, String oldPhone, String newPhone) {

    }

    @Override
    public void searchPhone(String name) {

    }

    @Override
    public void sort() {

    }


}
