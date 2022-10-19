package session2;

import java.util.ArrayList;


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
    public void searchPhone(String name) {
        boolean search = false;
        for (int i = 0; i < phoneArr.size(); i++){
            if (phoneArr.get(i).getName().equals(name)){
                search = true;
                System.out.println(phoneArr.get(i).getName());
                System.out.println(phoneArr.get(i).getTel());
                break;
            }
        }
        if (!search) {
            System.out.println("khong tìm thây danh bạ có tên "+ name);
        }
    }

    @Override
    public void sort() {

    }


}
