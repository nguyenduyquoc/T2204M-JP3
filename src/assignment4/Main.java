package assignment4;

public class Main {
    public static void main(String[] args) {

        HD_TienDien_VN hd1 = new HD_TienDien_VN("Q001", "Quoc",2022, 10, 17,"business",136,0);
        hd1.electricityBill();

        HD_TienDien_NN hd2 = new HD_TienDien_NN("Q002","Nguyễn Duy Quốc",2022,4,29,340,0,true);
        hd2.electricityBill();

        HD_TienDien_NN hd3 = new HD_TienDien_NN("Q002","Chu Văn Anh", 2022, 4, 25,140,0,false);
        hd3.electricityBill();
    }
}
