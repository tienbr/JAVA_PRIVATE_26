package model;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    Scanner sc = new Scanner(System.in);
    final List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
            System.out.println("Thêm đơn hàng thành công!");
            return;
        }
    }

    @Override
    public void printOrders() {
        System.out.println("Danh sach hang mua la: ");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getId() + " | " + orders.get(i).toString());
            System.out.println(orders.get(i).getProduct().toString());
        }
    }

    @Override
    public void updateOrder(String id) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id)) {
                System.out.println("Nhập số lượng mới: ");
                int newQuantity;
                do {
                    newQuantity = Integer.parseInt(sc.nextLine());
                } while (newQuantity <= 0);

                order.setQuantity(newQuantity);
                System.out.println("Cập nhật đơn hàng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng có ID: " + id);
    }

    @Override
    public void deleteOrder(String id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equalsIgnoreCase(id)) {
                orders.remove(i);
                System.out.println("Đã xóa đơn hàng ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng có ID: " + id);
    }
}
