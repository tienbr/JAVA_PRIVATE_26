import java.util.Scanner;

public class product {
    public  static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println ("Nhap vao ten hang hoa");
        String hangHoa = sc.nextLine();
        System.out.println ("Nhap vao don gia");
        double donGia = sc.nextDouble();
        System.out.println ("Nhap vao so luong");
        int soLuong = sc.nextInt();
        double thanhTien = soLuong * donGia;
        final float VAT_RATE = 0.1F;
        final int SHIPPING_FEE = 20000;
        double tongThanhTien = thanhTien * (1 + VAT_RATE) + SHIPPING_FEE;
        System.out.println ("Thong tin don hang la : ");
        System.out.println ("Ten  hang la : " + hangHoa);
        System.out.println("Don gia la " + donGia);
        System.out.println ("Thanh tien la " + thanhTien);
        System.out.println("Tong thanh tien la " + tongThanhTien);
    }
}

