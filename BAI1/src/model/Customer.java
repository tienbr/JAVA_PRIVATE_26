package model;

import java.util.Formatter;

public class Customer {
    private String id ;
    private String name;
    private String phone;
    public Customer (String id , String name , String phone){
        this.id = id ;
        this.name = name ;
        this.phone = phone;
    }

    public void setName (String newName){
        this.name = newName;
    }
    public void setPhone (String newPhone){
        this.phone = newPhone;
    }
    public String getId (){
        return this.id;
    }
    public String getName (){
        return this.name;
    }
    public String getPhone (){
        return this.phone;
    }
    public String toString (){
        return this.id + " | " + this.name + " | " + this.phone ;
    }
}
