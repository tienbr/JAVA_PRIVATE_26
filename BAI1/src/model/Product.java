package model;

import java.util.Scanner;

public class Product {
   private String id ;
   private String name;
   private  double price ;
   private int stock ;
   private static int count =0 ;
   public String getId (){
        return this.id;
    }
   public String getName (){
       return this.name;
   }
    public double getPrice (){
        return this.price;
    }
    public int getStock (){
        return this.stock;
    }

   public  void setId (String newId){
       this.name = newId;
   }
    public  void setName (String newName){
        if (!newName.isEmpty()){
            this.name = newName;
        }
    }
    public  void setPrice (double newPrice){
       if (newPrice > 0){
        this.price = newPrice;
       }
    }
    public  void setStock (int newStock){
       if (newStock >= 0) {
           this.stock = newStock;
       }
    }
   public Product (String id , String name , double price , int stock){
       this.id = id;
       this.id = id;
       this.name = name;
       this.price = price;
       this.stock = stock;
       count ++;
   }
   public static int getCount (){
       return count ;
   }

   public String toString (){
       return this.id   + " | " + this.name + " | " + this.price + "  |  " + this.stock;
   }
}
