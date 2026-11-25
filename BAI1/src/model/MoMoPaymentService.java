package model;

public class MoMoPaymentService implements PaymentService {
    @Override
    public void pay (String OrderPayId){
        System.out.println("Đơn hàng" + OrderPayId + " của bạn đã được thanh toán thành công qua MoMo");
    }
}
