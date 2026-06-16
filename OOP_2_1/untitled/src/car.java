import java.util.ArrayList;

public class car {
    private String Car_name="" , Car_brand="" , Car_code="" , Car_color="" , Car_origin=""  ;
    private double CarStrength=0,CarSpeed=0,CarPrice=0,Discountpercent=0;
    public car(String carname,String carbrand , String carcode){
        this.Car_name = carname ;
        this.Car_brand=carbrand;
        this.Car_code=carcode;
    }
    public String getCar_code(){
        return Car_code;
    }
    public void setCar_color(String car_color){
        this.Car_color=car_color;
    }
    public void setCar_origin(String car_origin){
        this.Car_origin=car_origin;
    }
    public void setCarStrength(String carStrength){
        double num  = Double.parseDouble(carStrength);
        this.CarStrength=num;
    }
    public void setCarSpeed(String carSpeed){
        double num = Double.parseDouble(carSpeed);
        this.CarSpeed=num;
    }
    public double getCarStrength(){
        return CarStrength;
    }
    public void setCarPrice(String carPrice){
        double num = Double.parseDouble(carPrice);
        this.CarPrice=num;
    }
    public int getCarPrice(){//int
        return (int) CarPrice;
    }
    public double getCarSpeed(){
        return CarSpeed;
    }
    public double get_CarPrice(){//double
        return CarPrice;
    }
    public void setDiscountpercent(double discount ){
        this.Discountpercent=discount;
        this.CarPrice*=(1-(discount/100));
    }
    public String getCar_color(){
        return Car_color;
    }
    public String getCar_name(){
        return Car_name;
    }
    public String getCar_origin(){
        return Car_origin;
    }
    public String getCar_brand(){
        return Car_brand;
    }
}


