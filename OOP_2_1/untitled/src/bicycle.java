public class bicycle {
    private String Bicycle_name="" , Bicycle_brand="" , Bicycle_code="" , Bicycle_color="" ,Bike_type="", Bicycle_origin=""  ;
    private double  BicyclePrice=0,WheelSize=0,BikeWeight=0,Discountpercent=0;
    public bicycle(String bicyclename,String bicyclebrand , String bicyclecode,String bike_type){
        this.Bicycle_name = bicyclename ;
        this.Bicycle_brand=bicyclebrand;
        this.Bicycle_code=bicyclecode;
        this.Bike_type=bike_type;
    }
    public String getBicycle_code(){
        return Bicycle_code;
    }
    public void setBicycle_color(String bicycle_color){
        this.Bicycle_color=bicycle_color;
    }
    public void setBicycle_origin(String bicycle_origin){
        this.Bicycle_origin=bicycle_origin;
    }
    public void setBikeWeight(String bikeWeight){
        double num = Double.parseDouble(bikeWeight);
        this.BikeWeight=num;
    }
    public void setWheelSize(String wheelSize){
        double num = Double.parseDouble(wheelSize);
        this.WheelSize=num;
    }
    public void setBicyclePrice(String bicyclePrice){
        double num = Double.parseDouble(bicyclePrice);
        this.BicyclePrice=num;
    }
    public int  getBicyclePrice(){//int
        return (int)BicyclePrice;
    }
    public String getBike_type(){
        return Bike_type;
    }
    public double getWheelSize(){
        return WheelSize;
    }
    public double getBikeWeight(){
        return BikeWeight;
    }
    public double get_bikeprice(){//double
        return BicyclePrice;
    }
    public void setDiscountpercent(double discount){
        this.Discountpercent=discount;
        this.BicyclePrice*=(1-(discount/100));
    }
    public String getBicycle_color(){
        return Bicycle_color;
    }
    public String getBicycle_name(){
        return Bicycle_name;
    }
    public String getBicycle_origin(){
        return Bicycle_origin;
    }
    public String getBicycle_brand(){
        return Bicycle_brand;
    }

}

