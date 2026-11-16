package model;

public class Cake extends Product {
    private String brand ;
    public Cake (String id , String name , double price , int stock , String newBrand){
        super (id , name , price , stock);
        this.brand = newBrand;
    }
    public void setBrand (String newBrand){
        this.brand = newBrand;
    }
    public String getBrand (){
        return this.brand;
    }
    @Override
    public boolean isExpensive (){
        if (getPrice() > 100000) return true;
        else return false;
    }
}
