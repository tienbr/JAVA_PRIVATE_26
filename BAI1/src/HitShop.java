import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Product;
import model.CartItem;
import model.Customer;
import model.Book;
import model.Cake;

public class HitShop {
    static Scanner sc = new Scanner(System.in);

    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();
    private static final List <Product> products = new ArrayList<>();
//    static final Product product1 = new Product("P01", "Ao thun", 150000, 20);
//    static final Product product2 = new Product("P02", "Binh nuoc", 50000, 10);

    static void addOder() {
        Product iProduct = null;
        System.out.println("==========Cac san pham san co========= ");
        System.out.println("1. Product - Sản phẩm thông thường");
        System.out.println("2. Book - Sách");
        System.out.println("3. Cake - Bánh");
        System.out.println("Nhập vào lựa chọn của bạn");
        int choice = Integer.parseInt (sc.nextLine()) ;
        System.out.println("Nhap vao id san pham ");
        String idP = sc.nextLine();
        System.out.println("Nhap vao ten san pham ");
        String nameP = sc.nextLine();
        System.out.println("Nhap vao gia san pham ");
        double priceP = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap vao so luong san pham trong kho ");
        int stockP = Integer.parseInt (sc.nextLine());

        if (choice == 1){
                iProduct = new Product(idP , nameP , priceP , stockP);
       }
       else if (choice == 2){
                System.out.println("Nhap ten tac gia ");
                String authorB = sc.nextLine();
               iProduct = new Book (idP , nameP , priceP,stockP , authorB);
            }
        else if (choice == 3) {
                System.out.println("Nhap vao ten hang banh");
                String brandC = sc.nextLine();
                iProduct = new Cake(idP , nameP , priceP , stockP , brandC);
            }
       products.add(iProduct);
        System.out.print("Nhap vao so luong cua product: ");
        int quantity1 = Integer.parseInt(sc.nextLine());
        if (quantity1 <= 0 || quantity1 > stockP) {
            System.out.println("So luong phai lon hon 0");
        } else {
            CartItem cartItem = new CartItem(iProduct, quantity1);
            cart.add(cartItem);
            System.out.println("Đã thêm vào giỏ thành công.");
        }
    }

    static void readAndRemoveItem() {
        if (cart.isEmpty()) {
            System.out.println("Gio hang trong");
            return;
        }
        System.out.println("=========== Danh sach mat hang trong gio==========");
        for (int i = 0; i < cart.size(); i++) {
            Product p = cart.get(i).getProduct();
            System.out.println((i + 1) + " . " + p.getName() + " | SL: " + cart.get(i).getQuantity());
        }

        System.out.print("Nhap so thu tu muon xoa: ");
        int displayNumber = Integer.parseInt(sc.nextLine());
        if (displayNumber < 1 || displayNumber > cart.size()) {
            System.out.println("Khong tim thay mat hang");
        } else {
            cart.remove(displayNumber - 1);
            System.out.println("Xoa mat hang thanh cong.");
        }
    }

    static void printItems() {
        System.out.println("==================Thong tin gio hang==============");
        System.out.println(currentCustomer.toString());
        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
        } else {
            for (int i = 0; i < cart.size(); i++) {
                Product product = cart.get(i).getProduct();
                System.out.println((i + 1) + ". " + product.getId() + " | " + product.getName() + " | " + product.getPrice() + " | SL: " + cart.get(i).getQuantity() + " | Thanh tien: " + cart.get(i).getTotal());
            }
        }
    }

    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getTotal();
        }
        return total;
    }

    static void printMenu() {
        System.out.println("\n---------------------Menu----------------------");
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("5. Kiểm tra sản phẩm có đắt không ");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }
    static void checkExpensve (){
        boolean flag = false;
        System.out.println("Nhap vao id cua sp");
        String idP = sc.nextLine();
        for (int i = 0 ; i < products.size() ; i ++){
            Product product = products.get(i);
            if (product.getId() .equals(idP)){
                flag = true;
                if (product.isExpensive()){
                    System.out.println("San phan dat");
                }
                else {System.out.println("San pham khong dat");}
                break;
            }
        }
        if (!flag) System.out.println("Khong co id san pham ");
    }

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addOder();
                case 2 -> readAndRemoveItem();
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 5 -> checkExpensve();
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}