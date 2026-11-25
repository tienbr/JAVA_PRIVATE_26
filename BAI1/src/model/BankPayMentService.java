package model;

public class BankPayMentService implements PaymentService{
    @Override
    public void pay (String orderPayId){
        System.out.println("Đơn hàng " + orderPayId +" của bạn đã được thanh toán thành công qua HitBank");
    }
}
