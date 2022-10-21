package session2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PhoneBook extends Phone{

    ArrayList<PhoneList> phoneArr= new ArrayList<>();

    public ArrayList<PhoneList> getPhoneArr() {
        return phoneArr;
    }

    public void setPhoneArr(ArrayList<PhoneList> phoneArr) {
        this.phoneArr = phoneArr;
    }

    @Override
    public void insertPhone(String name, String phone) {
        boolean dem = false;
        boolean dem2 = false;
        for(int i = 0; i <phoneArr.size();i++ ){
            if (phoneArr.get(i).getName().equals(name)){
                dem = true;
                for (int j = 0; j < phoneArr.get(i).tel.size(); j++){
                    if (phoneArr.get(i).tel.get(j).equals(phone)) {
                        dem2 = true;
                        break;
                    }
                }
                if (!dem2) {
                    this.phoneArr.get(i).tel.add(phone);
                }
            }
        }
        if (!dem) {
            this.phoneArr.add(new PhoneList(name, phone));

        }

    }

    @Override
    public void removePhone(String name) {

        for (int i = 0; i < phoneArr.size(); i++){
            if (phoneArr.get(i).getName().equals(name)) {
                phoneArr.remove(i);
            }
        }

    }

    @Override
    public void updatePhone(String name, String oldPhone, String newPhone) {
        for (int i= 0; i < phoneArr.size(); i++) {
            if (phoneArr.get(i).getName().equals(name)){
                for (int j = 0; j < phoneArr.get(i).tel.size(); j++){
                    if (phoneArr.get(i).tel.get(j).equals(oldPhone)) {
                        phoneArr.get(i).tel.set(i,newPhone);
                        break;
                    }
                }
            }
        }
    }

    @Override
    PhoneList searchPhone(String name) {
        for(PhoneList p: getPhoneArr()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void sort() {
//        Collections.sort(getPhoneArr(), new Comparator<PhoneList>() {
//            @Override
//            public int compare(PhoneList o1, PhoneList o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });


        Comparator<PhoneList> cp = (o1,o2)->{
            return o1.getName().compareTo(o2.getName());
        };
        Collections.sort(getPhoneArr(), cp);

    }


}
