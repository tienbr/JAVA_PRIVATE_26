import javax.sound.midi.Soundbank;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import  java.util.Scanner;

public class  HitShop {

    static final List <String> names = new ArrayList<>();
    static final  List <Double> prices = new ArrayList<>();
    static final  List <Integer> quantities = new ArrayList<>();
    static void Search (Scanner sc )  {
        System.out.println("Nhap vao ten mat hang can tim");
        sc.nextLine();
        String nameS = sc.nextLine();
        boolean flag = false;
        for (int i = 0 ; i < names.size() ; i ++){

            if (names.get(i).toLowerCase().equals (nameS.toLowerCase())){
                flag = true;
                double total = quantities.get(i) * prices.get(i);
                System.out.printf("%d. %s | %.2f | SL  %d | ThanhTien  %.2f%n" ,
                        i +1,
                        names.get(i),
                        prices.get(i),
                        quantities.get(i),
                        total);
            }
        }
        if (!flag){
            System.out.println("Khong co mat hang can tim ");
        }
    }
    static void printItems () {
        if (names.isEmpty()) {
            System.out.println("Gio hang trong");
        }
        else {
            System.out.println("Danh sach mat hang la : ");
            for (int i = 0 ; i < names.size() ; i ++){
                double total = prices.get(i) * quantities.get(i);
                System.out.printf("%d. %s | %.2f | SL  %d | ThanhTien  %.2f%n" ,
                        i +1,
                        names.get(i),
                        prices.get(i),
                        quantities.get(i),
                        total);
            }
        }
    }
    static void readAndAddItem (Scanner sc) {
        sc.nextLine();
        System.out.println("Nhap vao ten mat hang: ");
        String name = sc.nextLine() ;
        System.out.println("Nhap vao gia mat hang: ");
        double price = sc.nextDouble();
        System.out.println("Nhap vao so luong mat hang : ");
        int quantity = sc.nextInt();
        if (!name.isEmpty() && price > 0  && quantity > 0){
            names.add (name);
            prices.add (price);
            quantities.add(quantity);
            printItems();
    }
    }
    static void readAndRemoveItem(Scanner sc) {
        if (names.isEmpty()) {
            System.out.println("Gio hang trong");
            return;
        }

        System.out.println("Nhap vao chi so mat hang muon xoa:");
        int index = sc.nextInt();

        if (index < 1 || index > names.size()) {
            System.out.println("Khong ton tai mat hang");
            return;
        }

        index--;
        names.remove(index);
        prices.remove(index);
        quantities.remove(index);

        printItems();
    }
    static double calculateTotal () {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }
        if (total != 0){
           total = total * (1.0 /10 + 1) + 20000;
        }
        return total;
    }

    static void printMenu() {
        System.out.println("---------------------Menu----------------------");
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("5. Tim kiem hang da dat");
        System.out.println("0. Thoát");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> readAndAddItem(sc);
                case 2 -> readAndRemoveItem(sc);
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 5 -> Search(sc);
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }while (choice != 0);
    }
}