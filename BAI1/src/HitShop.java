import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Product;
import model.CartItem;
import model.Customer;

public class HitShop {
    static Scanner sc = new Scanner(System.in);

    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();

    static final Product product1 = new Product("P01", "Ao thun", 150000, 20);
    static final Product product2 = new Product("P02", "Binh nuoc", 50000, 10);

    static void readAndAddItem() {
        Product iProduct = null;
        System.out.println("==========Cac san pham san co========= ");
        System.out.println(product1.getId() + "         " + product1.getName());
        System.out.println(product2.getId() + "         " + product2.getName());

        System.out.print("Nhap vao id cua product: ");
        String id = sc.nextLine().trim();

        if (id.equals(product1.getId())) {
            iProduct = product1;
        } else if (id.equals(product2.getId())) {
            iProduct = product2;
        } else {
            System.out.println("Khong tim thay san pham ");
            return;
        }

        System.out.print("Nhap vao so luong cua product: ");
        int quantity1 = Integer.parseInt(sc.nextLine());
        if (quantity1 <= 0) {
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
        System.out.println("5. Số đối tượng Product được tạo la ");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> readAndAddItem();
                case 2 -> readAndRemoveItem();
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 5 -> System.out.println("So san pham da tao la " +  Product.getCount());
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
