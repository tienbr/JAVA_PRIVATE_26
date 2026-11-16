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
    public double getTotal (){
        return product.getPrice() * this.quantity;
    }

}
