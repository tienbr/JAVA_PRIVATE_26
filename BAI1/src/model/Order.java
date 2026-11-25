package model;

public class Order {
    private String id;
    private Customer customer;
    private  Product product;
    private int quantity ;

    public void setId (String id){

        this.id = id;
    }
    public String getId() {

        return this.id;
    }
    public  Product getProduct (){
        return this.product;
    }
    public double getTotal (){
        return product.getPrice() * this.quantity;
    }
    public Order (String id , Customer customer , Product product , int quantity){
        this.id = id ;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }


    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
    @Override
    public String toString() {
        return "Khách hàng: " + customer.getName()
                + " | Số lượng: " + quantity
                + " | Tổng tiền: " + getTotal();
    }

}
