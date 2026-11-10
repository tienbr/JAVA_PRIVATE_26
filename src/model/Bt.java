package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Bt {
    static Scanner sc = new Scanner(System.in);
    public static class Car {
        private String card ;
        private String brand;
        private String licensePlate;
        public Car (){
            this.card = "Chua co xe";
            this.brand = "Chua co du lieu";
            this.licensePlate  ="Chua co";
        }
        public Car (String initialCard , String initialBrand , String initialLicenseP){
            this.card = initialCard;
            this.brand = initialBrand;
            this.licensePlate = initialLicenseP;
        }
        public void setCard (String newCard){
            this.card = newCard;
        }
        public void setBrand (String newBrand){
            this.brand = newBrand;
        }
        public void setLicensePlate (String newlicenseP){
            this.licensePlate = newlicenseP;
        }
        public  String getCar (){
            return this.card;
        }
        public String getBrand (){
            return this.brand;
        }
        public String getLicensePlate (){
            return this.licensePlate;
        }
    }
    public static class  Student {
        private String studentId;
        private String name ;
        private int age ;
        private Car car;
        public Student (){}
        public Student (String newStudentId , String newName , int newAge, String newCard , String newBrand , String newLicenseP){
            this.car = new Car (newCard , newBrand , newLicenseP);
            this.studentId = newStudentId;
            this.name = newName;
            this.age = newAge;
        }
        public void setStudentId (String newId){
            this.studentId = newId;
        }
        public void setAge (int newAge){
            this.age = newAge;
        }
        public void setCar (Car newCar){
            this.car = newCar;
        }
        public String getStudentId (){
            return this.studentId;
        }
        public String getName (){
            return this.name;
        }
        public int getAge (){
            return this.age;
        }
        public Car getCar (){
            return this.car;
        }

        public String introduce(){
            return  "Minh ten la " +  this.name + " , Tuoi " + this.age + "tuoi " + " , Di xe "  + car.getBrand() +  "  ,Bien so xe la " + car.getCar();
        }
    }
    public static void main (String[] args){
         Student sv = new Student("202528" , "Taon" , 19 , "3q404" , "Toyota" , "b1");

        List<Student> studentList = new ArrayList<>(Arrays.asList(
                new Student("20258" , "GDn" , 19 , "3tt404" , "Toyota" , "b1")
        ));

        System.out.println("");
    }
}
