import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int car_num = 0 , motor_num=0 , bicycle_num =0 ;
        String a="s";
        ArrayList<car> cars = new ArrayList<>();
        ArrayList<motor> motors  = new ArrayList<>();
        ArrayList<bicycle>bicycles = new ArrayList<>();
        int find = 0 ;
        Scanner scanner = new Scanner(System.in);
        while (a.equals("s")) {
            String b = scanner.nextLine();
            String[] c = b.split("\\s+");
            for(int i = 0 ; i<c.length ; i++){
                if (c[i].equals("end")){
                    a="end";
                }
            }
            switch (c[0]) {
                case "addCar":
                    find = 0 ;
                    for(int i = 0 ; i<cars.size();i++){
                        if(cars.get(i).getCar_code().equals(c[3])) {
                            System.out.print("Car with this code already exists!\n");
                            find = 1;
                        }
                    }
                    if (find==0){
                        car car_1 = new car(c[1],c[2],c[3]);
                        cars.add(car_num,car_1);
                        car_num++;
                        System.out.print("Car was added successfully!\n");
                    }
                    break;
                case "addMotorcycle":
                    find = 0 ;
                    for(int i = 0 ; i<motors.size();i++){
                        if(motors.get(i).getMotor_code().equals(c[3])){
                            System.out.print("Motorcycle with this code already exists!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        motor motor_1 = new motor(c[1],c[2],c[3]);
                        motors.add(motor_num,motor_1);
                        motor_num++;
                        System.out.print("Motorcycle was added successfully!\n");
                    }
                    break;
                case "addBike":
                    find = 0 ;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if(bicycles.get(i).getBicycle_code().equals(c[3])){
                            System.out.print("Bike with this code already exists!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        bicycle bicycle_1 = new bicycle(c[1],c[2],c[3],c[4]);
                        bicycles.add(bicycle_num,bicycle_1);
                        bicycle_num++;
                        System.out.print("Bike was added successfully!\n");
                    }
                    break;
                case "SetCarColor":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            System.out.print("CarColor is "+c[2]+"!\n");
                            cars.get(i).setCar_color(c[2]);
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcycleColor":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            System.out.print("MotorcycleColor is "+c[2]+"!\n");
                            motors.get(i).setMotor_color(c[2]);
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }
                    break;
                case "SetBikeColor":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            bicycles.get(i).setBicycle_color(c[2]);
                            System.out.print("BikeColor is "+c[2]+"!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case "SetCarOrigin":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            System.out.print("CarOrigin is "+c[2]+"!\n");
                            cars.get(i).setCar_origin(c[2]);
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcycleOrigin":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            System.out.print("MotorcycleOrigin is "+c[2]+"!\n");
                            motors.get(i).setMotor_origin(c[2]);
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }
                    break;
                case "SetBikeOrigin":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            bicycles.get(i).setBicycle_origin(c[2]);
                            System.out.print("BikeOrigin is "+c[2]+"!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case "SetCarStrength":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            double power = Double.parseDouble(c[2]);
                            if(power<100 || power>500) {
                                System.out.print("CarStrength is invalid!\n");
                            }
                            else{
                                System.out.print("CarStrength is "+c[2]+" hp!\n");
                                cars.get(i).setCarStrength(c[2]);
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcycleStrength":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            double power = Double.parseDouble(c[2]);
                            if(power>100 || power<50){
                                System.out.print("MotorcycleStrength is invalid!\n");
                            }
                            else {
                                System.out.print("MotorcycleStrength is " + c[2] + " hp!\n");
                                motors.get(i).setMotorStrength(c[2]);
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }
                    break;
                case "SetCarSpeed":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            System.out.print("CarSpeed is "+c[2]+"!\n");
                            cars.get(i).setCarSpeed(c[2]);
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcycleSpeed":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            double power = Double.parseDouble(c[2]);
                            System.out.print("MotorcycleSpeed is " + c[2] + "!\n");
                            motors.get(i).setMotorSpeed(c[2]);
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }
                    break;
                case "SetBikeWeight":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            bicycles.get(i).setBikeWeight(c[2]);
                            System.out.print("BikeWeight is "+c[2]+"!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case "SetWheelSize":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            double size = Double.parseDouble(c[2]);
                            if(size<12 || size>29){
                                System.out.print("WheelSize is invalid!\n");
                            }
                            else{
                                bicycles.get(i).setWheelSize(c[2]);
                                System.out.print("WheelSize is "+c[2]+" inches!\n");
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case"SetCarPrice":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            cars.get(i).setCarPrice(c[2]);
                            System.out.print("CarPrice is "+cars.get(i).getCarPrice()+"$!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcyclePrice":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            motors.get(i).setMotorPrice(c[2]);
                            System.out.print("MotorcyclePrice is "+motors.get(i).getMotorPrice()+"$!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }
                    break;
                case "SetBikePrice":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            bicycles.get(i).setBicyclePrice(c[2]);
                            System.out.print("BikePrice is "+bicycles.get(i).getBicyclePrice()+"$!\n");
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case "SetCarState":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            switch (c[2]){
                                case "sold":
                                    System.out.print("CarState is sold!\n");
                                    cars.remove(i);
                                    car_num--;
                                    break;
                                case "unsold":
                                    System.out.print("CarState is unsold!\n");
                                    break;
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcycleState":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            switch (c[2]){
                                case "sold":
                                    System.out.print("MotorcycleState is sold!\n");
                                    motors.remove(i);
                                    motor_num--;
                                    break;
                                case "unsold":
                                    System.out.print("MotorcycleState is unsold!\n");
                                    break;
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }
                    break;
                case "SetBikeState":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            switch (c[2]){
                                case "sold":
                                    System.out.print("BikeState is sold!\n");
                                    bicycles.remove(i);
                                    bicycle_num--;
                                    break;
                                case "unsold":
                                    System.out.print("BikeState is unsold!\n");
                                    break;
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case"CompareCars":
                    int num_1 =0 ;
                    int num_2 = 0;
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if(cars.get(i).getCar_code().equals(c[1])){
                            num_1=i;
                            find++;
                        }
                        if(cars.get(i).getCar_code().equals(c[2])){
                            num_2=i;
                            find++;
                        }
                    }
                    if(find==2){
                        if(cars.get(num_1).getCarSpeed()>cars.get(num_2).getCarSpeed()) {
                            System.out.print("CarSpeed: "+cars.get(num_1).getCar_code()+"\n");
                        }
                        if(cars.get(num_1).getCarSpeed()<cars.get(num_2).getCarSpeed()) {
                            System.out.print("CarSpeed: "+cars.get(num_2).getCar_code()+"\n");
                        }
                        if(cars.get(num_1).getCarStrength()>cars.get(num_2).getCarStrength()){
                            System.out.print("CarStrength: "+cars.get(num_1).getCar_code()+"\n");
                        }
                        if(cars.get(num_1).getCarStrength()<cars.get(num_2).getCarStrength()){
                            System.out.print("CarStrength: "+cars.get(num_2).getCar_code()+"\n");
                        }
                        if(cars.get(num_1).get_CarPrice()<cars.get(num_2).get_CarPrice()){
                            System.out.print("CarPrice: "+cars.get(num_1).getCar_code()+"\n");
                        }
                        if(cars.get(num_1).get_CarPrice()>cars.get(num_2).get_CarPrice()){
                            System.out.print("CarPrice: "+cars.get(num_2).getCar_code()+"\n");
                        }
                    }
                    else{
                        System.out.print("Input is invalid!\n");
                    }
                    break;
                case "CompareMotorcycles":
                    num_1=0;
                    num_2=0;
                    find=0;
                    for(int i = 0 ; i<motors.size();i++) {
                        if(motors.get(i).getMotor_code().equals(c[1])){
                            num_1=i;
                            find++;
                        }
                        if(motors.get(i).getMotor_code().equals(c[2])){
                            num_2=i;
                            find++;
                        }
                    }
                    if(find==2){
                        if(motors.get(num_1).getMotorSpeed()>motors.get(num_2).getMotorSpeed()) {
                            System.out.print("MotorcycleSpeed: "+motors.get(num_1).getMotor_code()+"\n");
                        }
                        if(motors.get(num_1).getMotorSpeed()<motors.get(num_2).getMotorSpeed()) {
                            System.out.print("MotorcycleSpeed: "+motors.get(num_2).getMotor_code()+"\n");
                        }
                        if(motors.get(num_1).getMotorStrength()>motors.get(num_2).getMotorStrength()){
                            System.out.print("MotorcycleStrength: "+motors.get(num_1).getMotor_code()+"\n");
                        }
                        if(motors.get(num_1).getMotorStrength()<motors.get(num_2).getMotorStrength()){
                            System.out.print("MotorcycleStrength: "+motors.get(num_2).getMotor_code()+"\n");
                        }
                        if(motors.get(num_1).get_Motorprice()<motors.get(num_2).get_Motorprice()){
                            System.out.print("MotorcyclePrice: "+motors.get(num_1).getMotor_code()+"\n");
                        }
                        if(motors.get(num_1).get_Motorprice()>motors.get(num_2).get_Motorprice()){
                            System.out.print("MotorcyclePrice: "+motors.get(num_2).getMotor_code()+"\n");
                        }
                    }
                    else {
                        System.out.print("Input is invalid!\n");
                    }
                    break;
                case"CompareBikes":
                    num_1=0;
                    num_2=0;
                    String type_1 = null;
                    String type_2=null;
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++) {
                        if(bicycles.get(i).getBicycle_code().equals(c[1])){
                            num_1=i;
                            type_1= bicycles.get(i).getBike_type();
                            find++;
                        }
                        if(bicycles.get(i).getBicycle_code().equals(c[2])){
                            num_2=i;
                            type_2= bicycles.get(i).getBike_type();
                            find++;
                        }
                    }
                    if(find==2){
                        if(type_1.equals(type_2)){
                            if(bicycles.get(num_1).getBikeWeight()>bicycles.get(num_2).getBikeWeight()){
                                System.out.print("BikeWeight: "+bicycles.get(num_1).getBicycle_code()+"\n");
                            }
                            if(bicycles.get(num_1).getBikeWeight()<bicycles.get(num_2).getBikeWeight()){
                                System.out.print("BikeWeight: "+bicycles.get(num_2).getBicycle_code()+"\n");
                            }
                            if(bicycles.get(num_1).get_bikeprice()<bicycles.get(num_2).get_bikeprice()){
                                System.out.print("BikePrice: "+bicycles.get(num_1).getBicycle_code()+"\n");
                            }
                            if(bicycles.get(num_1).get_bikeprice()>bicycles.get(num_2).get_bikeprice()){
                                System.out.print("BikePrice: "+bicycles.get(num_2).getBicycle_code()+"\n");
                            }
                        }
                        else{
                            System.out.print("Types should be the same!\n");
                        }

                    }
                    else{
                        System.out.print("Input is invalid!\n");
                    }
                    break;
                case "SetCarDiscount":
                    find=0;
                    for(int i = 0 ; i<cars.size();i++) {
                        if (cars.get(i).getCar_code().equals(c[1])){
                            double dis = Double.parseDouble(c[2]);
                            if(dis<5 || dis>15) {
                                System.out.print("Input for discount is invalid!\n");
                            }
                            else{
                                cars.get(i).setDiscountpercent(dis);
                                System.out.print("New carPrice is "+cars.get(i).getCarPrice()+"$!\n");
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No cars exist with the given code!\n");
                    }
                    break;
                case "SetMotorcycleDiscount":
                    find=0;
                    for(int i = 0 ; i<motors.size();i++){
                        if (motors.get(i).getMotor_code().equals(c[1])){
                            double dis = Double.parseDouble(c[2]);
                            if(dis<5 || dis>15) {
                                System.out.print("Input for discount is invalid!\n");
                            }
                            else{
                                motors.get(i).setDiscountpercent(dis);
                                System.out.print("New motorcyclePrice is "+motors.get(i).getMotorPrice()+"$!\n");
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No motorcycles exist with the given code!\n");
                    }

                    break;
                case "SetBikeDiscount":
                    find=0;
                    for(int i = 0 ; i<bicycles.size();i++){
                        if (bicycles.get(i).getBicycle_code().equals(c[1])){
                            double dis = Double.parseDouble(c[2]);
                            if(dis<5 || dis>15) {
                                System.out.print("Input for discount is invalid!\n");
                            }
                            else{
                                bicycles.get(i).setDiscountpercent(dis);
                                System.out.print("New bikePrice is "+bicycles.get(i).getBicyclePrice()+"$!\n");
                            }
                            find=1;
                        }
                    }
                    if (find==0){
                        System.out.print("No bikes exist with the given code!\n");
                    }
                    break;
                case"SearchCars":
                    switch (c[1]){
                        case "Color":
                            find=0;
                            for(int i =0 ; i<cars.size();i++){
                                if(cars.get(i).getCar_color().equals(c[2])){
                                    find=1;
                                    System.out.println(cars.get(i).getCar_name()+" "+cars.get(i).getCar_code());
                                }
                            }
                            if(find==0){
                                System.out.print("No cars found with the given color!\n");
                            }
                            break;
                        case "Origin":
                            find=0;
                            for(int i =0 ; i<cars.size();i++){
                                if(cars.get(i).getCar_origin().equals(c[2])){
                                    find=1;
                                    System.out.println(cars.get(i).getCar_name()+" "+cars.get(i).getCar_code());
                                }
                            }
                            if(find==0){
                                System.out.print("No cars found with the given origin!\n");
                            }
                            break;
                    }
                    break;
                case "SearchMotorcycles":
                    switch (c[1]){
                        case "Color":
                            find=0;
                            for(int i =0 ; i<motors.size();i++){
                                if(motors.get(i).getMotor_color().equals(c[2])){
                                    find=1;
                                    System.out.println(motors.get(i).getMotor_name()+" "+motors.get(i).getMotor_code());
                                }
                            }
                            if(find==0){
                                System.out.print("No motorcycles found with the given color!\n");
                            }
                            break;
                        case "Origin":
                            find=0;
                            for(int i =0 ; i<motors.size();i++){
                                if(motors.get(i).getMotor_origin().equals(c[2])){
                                    find=1;
                                    System.out.println(motors.get(i).getMotor_name()+" "+motors.get(i).getMotor_code());
                                }
                            }
                            if(find==0){
                                System.out.print("No motorcycles found with the given origin!\n");
                            }
                            break;
                    }
                    break;
                case "SearchBikes":
                    switch (c[1]){
                        case "Type":
                            find=0;
                            for(int i=0; i<bicycles.size();i++){
                                if(bicycles.get(i).getBike_type().equals(c[2])){
                                    find=1;
                                    System.out.println(bicycles.get(i).getBicycle_name()+" "+bicycles.get(i).getBicycle_code());
                                }
                            }
                            if(find==0){
                                System.out.print("No bikes found with the given type!\n");
                            }
                            break;
                        case "Origin":
                            find=0;
                            for(int i=0; i<bicycles.size();i++){
                                if(bicycles.get(i).getBicycle_origin().equals(c[2])){
                                    find=1;
                                    System.out.println(bicycles.get(i).getBicycle_name()+" "+bicycles.get(i).getBicycle_code());
                                }
                            }
                            if(find==0){
                                System.out.print("No bikes found with the given origin!\n");
                            }
                            break;
                    }
                    break;
                case"LeastCarPrice":
                    double min=cars.get(0).get_CarPrice();
                    int num_min =0 ;
                    for(int i = 1 ; i<cars.size();i++){
                        if(cars.get(i).get_CarPrice()<min){
                            min=cars.get(i).get_CarPrice();
                            num_min=i;
                        }
                    }
                    System.out.println(cars.get(num_min).getCar_name()+" "+cars.get(num_min).getCar_code()+" "+ cars.get(num_min).getCarPrice());
                    break;
                case "LeastMotorcyclePrice":
                    min = motors.get(0).get_Motorprice();
                    num_min=0;
                    for(int i = 1 ; i<motors.size();i++) {
                        if(motors.get(i).get_Motorprice()<min){
                            min = motors.get(i).get_Motorprice();
                            num_min=i;
                        }
                    }
                    System.out.println(motors.get(num_min).getMotor_name()+" "+motors.get(num_min).getMotor_code()+" "+ motors.get(num_min).getMotorPrice());
                    break;
                case "LeastBikePrice":
                    min = bicycles.get(0).get_bikeprice();
                    num_min=0;
                    for(int i =1 ; i <bicycles.size();i++) {
                        if(bicycles.get(i).get_bikeprice()<min){
                            min = bicycles.get(i).get_bikeprice();
                            num_min=i;
                        }
                    }
                    System.out.println(bicycles.get(num_min).getBicycle_name()+" "+bicycles.get(num_min).getBicycle_code()+" "+ bicycles.get(num_min).getBicyclePrice());
                    break;
                case "Show":
                    switch (c[1]){
                        case "CarProperties":
                            find=0;
                            for(int i =0 ; i<cars.size();i++) {
                                if(cars.get(i).getCar_code().equals(c[2])){
                                    find=1;
                                    System.out.println("CarBrand: "+cars.get(i).getCar_brand());
                                    System.out.println("CarName: "+cars.get(i).getCar_name());
                                    System.out.println("CarColor: "+cars.get(i).getCar_color());
                                    System.out.println("CarOrigin: "+cars.get(i).getCar_origin());
                                }
                            }
                            if(find==0){
                                System.out.print("No cars exist with the given code!\n");
                            }
                            break;
                        case "BikeProperties":
                            find=0;
                            for(int i = 0 ; i<bicycles.size();i++){
                                if(bicycles.get(i).getBicycle_code().equals(c[2])){
                                    find=1;
                                    System.out.println("BikeBrand: "+bicycles.get(i).getBicycle_brand());
                                    System.out.println("BikeName: "+bicycles.get(i).getBicycle_name());
                                    System.out.println("BikeColor: "+bicycles.get(i).getBicycle_color());
                                    System.out.println("BikeOrigin: "+bicycles.get(i).getBicycle_origin());
                                }
                            }
                            if(find==0){
                                System.out.print("No bikes exist with the given code!\n");
                            }
                            break;
                        case "MotorcycleProperties":
                            find=0;
                            for(int i = 0 ; i<motors.size();i++){
                                if(motors.get(i).getMotor_code().equals(c[2])){
                                    find=1;
                                    System.out.println("MotorcycleBrand: "+motors.get(i).getMotor_brand());
                                    System.out.println("MotorcycleName: "+motors.get(i).getMotor_name());
                                    System.out.println("MotorcycleColor: "+motors.get(i).getMotor_color());
                                    System.out.println("MotorcycleOrigin: "+motors.get(i).getMotor_origin());
                                }
                            }
                            if(find==0){
                                System.out.print("No motorcycles exist with the given code!\n");
                            }

                            break;
                    }
                    break;
            }
        }
    }
}