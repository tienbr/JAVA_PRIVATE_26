import java.util.Scanner;
import model.*;

public class HitShop {
    static Scanner sc = new Scanner(System.in);
    static ProductService productService = new ProductServiceImpl();
    static OrderService orderService = new OrderServiceImpl();
    private static final Customer currentCustomer =
            new Customer("C01", "Linh Nguyễn", "0900000001");

    static void addOder() {
        System.out.print("Nhap vao id don hang: ");
        String orderId = sc.nextLine();

        Product iProduct = null;
        System.out.println("==========Cac san pham san co========= ");
        System.out.println("1. Product - Sản phẩm thông thường");
        System.out.println("2. Book - Sách");
        System.out.println("3. Cake - Bánh");
        System.out.println("Nhập vào lựa chọn của bạn");
        int choice = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap vao id san pham ");
        String idP = sc.nextLine();
        System.out.println("Nhap vao ten san pham ");
        String nameP = sc.nextLine();
        System.out.println("Nhap vao gia san pham ");
        double priceP = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap vao so luong san pham trong kho ");
        int stockP = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            iProduct = new GeneralProduct(idP, nameP, priceP, stockP);
        } else if (choice == 2) {
            System.out.println("Nhap ten tac gia ");
            String authorB = sc.nextLine();
            iProduct = new Book(idP, nameP, priceP, stockP, authorB);
        } else if (choice == 3) {
            System.out.println("Nhap vao ten hang banh");
            String brandC = sc.nextLine();
            iProduct = new Cake(idP, nameP, priceP, stockP, brandC);
        }

        if (iProduct != null) {
            System.out.print("Nhap vao so luong cua product: ");
            int quantity1 = Integer.parseInt(sc.nextLine());
            if (quantity1 <= 0 || quantity1 > stockP) {
                System.out.println("So luong phai lon hon 0");
            } else {
                productService.addProduct(iProduct);
                Order order = new Order (orderId, currentCustomer, iProduct, quantity1);
                orderService.addOrder(order);
            }
        }
    }

    static void printMenu() {
        System.out.println("\n---------------------Menu----------------------");
        System.out.println("1. Thêm đơn hàng");
        System.out.println("2. Xem danh sách hàng");
        System.out.println("3. Sửa đơn hàng theo id");
        System.out.println("4. Xóa đơn hàng theo id");
        System.out.println("5. Kiểm tra sản phẩm có đắt không ");
        System.out.println("6. Thanh toán đơn hàng");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    static void checkExpensve() {
        System.out.println("Nhap vao id cua sp");
        String idP = sc.nextLine();
        Product product = productService.findById(idP);
        if (product != null) {
            if (product.isExpensive()) {
                System.out.println("San phan dat");
            } else {
                System.out.println("San pham khong dat");
            }
        } else {
            System.out.println("Khong co id san pham ");
        }
    }

    static void payOrder() {
        System.out.print("Nhap vao id don hang can thanh toan: ");
        String orderId = sc.nextLine();
        System.out.println("Chon phuong thuc thanh toan (1. MoMo | 2. HITBank): ");
        int payChoice = Integer.parseInt(sc.nextLine());

        PaymentService paymentService;
        if (payChoice == 1) {
            paymentService = new MoMoPaymentService();
        } else {
            paymentService = new BankPayMentService();
        }
        paymentService.pay(orderId);
    }

    public static void main(String[] args) {


        int choice;
        do {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addOder();
                case 2 -> orderService.printOrders();
                case 3 -> {
                    System.out.print("Nhap id don hang can sua: ");
                    String idUpdate = sc.nextLine();
                    orderService.updateOrder(idUpdate);
                }
                case 4 -> {
                    System.out.print("Nhap id don hang can xoa: ");
                    String idDelete = sc.nextLine();
                    orderService.deleteOrder(idDelete);
                }
                case 5 -> checkExpensve();
                case 6 -> payOrder();
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }
}
