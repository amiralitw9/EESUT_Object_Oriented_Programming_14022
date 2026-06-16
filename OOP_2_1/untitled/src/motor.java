public class motor {
    private String Motor_name="" , Motor_brand="" , Motor_code="" , Motor_color="" , Motor_origin=""  ;
    private double MotorStrength=0,MotorSpeed=0,MotorPrice=0,  Discountpercent=0;

    public motor(String motorname,String motorbrand , String motorcode){
        this.Motor_name = motorname ;
        this.Motor_brand=motorbrand;
        this.Motor_code=motorcode;
    }
    public String getMotor_code(){
        return Motor_code;
    }
    public void setMotor_color(String motor_color){
        this.Motor_color=motor_color;
    }
    public void setMotor_origin(String motor_origin){
        this.Motor_origin=motor_origin;
    }
    public void setMotorStrength(String motorStrength){
        double num = Double.parseDouble(motorStrength);
        this.MotorStrength=num;
    }
    public void setMotorSpeed(String motorspeed){
        double num = Double.parseDouble(motorspeed);
        this.MotorSpeed=num;
    }
    public void setMotorPrice(String motorPrice){
        double num = Double.parseDouble(motorPrice);
        this.MotorPrice=num;
    }
    public int getMotorPrice(){//int
        return (int)MotorPrice;
    }
    public double getMotorStrength(){
        return MotorStrength;
    }
    public double getMotorSpeed(){
        return MotorSpeed;
    }
    public double get_Motorprice(){//double
        return MotorPrice;
    }
    public void setDiscountpercent(double discount){
        this.Discountpercent = discount;
        this.MotorPrice*=(1-(discount/100));
    }
    public String getMotor_color(){
        return Motor_color;
    }
    public String getMotor_name(){
        return Motor_name;
    }
    public String getMotor_origin(){
        return Motor_origin;
    }
    public String getMotor_brand(){
        return Motor_brand;
    }


}
