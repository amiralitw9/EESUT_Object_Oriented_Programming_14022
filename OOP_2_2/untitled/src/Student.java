import java.util.ArrayList;

public class Student {
    private String First_name,Last_name,Student_ID,Entrance_year, Phone_number ;
    private int Unit_limit,Passed_unit ;
    public Student(String first_name,String last_name,String student_ID ){
        this.First_name=first_name;
        this.Last_name=last_name;
        this.Student_ID=student_ID;
    }
    ArrayList<Department> courses = new ArrayList<>();


    public void setStudent_ID(String student_ID){
        this.Student_ID=student_ID;
    }
    public void setFirst_name(String first_name){
        this.First_name=first_name;
    }
    public void setLast_name(String last_name){
        this.Last_name=last_name;
    }
    public void setPhone_number(String phone_number){
        this.Phone_number=phone_number;
    }
    public void setEntrance_year(String entrance_year){
        this.Entrance_year=entrance_year;
    }
    public void setUnit_limit(String unit_limit){
        int num = Integer.parseInt(unit_limit);
        this.Unit_limit=num;
    }
    public void setPassed_unit(String passed_unit){
        int num = Integer.parseInt(passed_unit);
        this.Passed_unit=num;
    }
    public String getStudent_ID(){
        return Student_ID;
    }
    public String getFirst_name(){
        return First_name;
    }
    public String getLast_name(){
        return Last_name;
    }
    public String getEntrance_year(){
        return Entrance_year;
    }
    public String getPhone_number(){
        return Phone_number;
    }
    public int getUnit_limit(){
        int num = 0;
        for(int i = 0 ; i<courses.size();i++){
            num+=courses.get(i).getVahed_num();
        }
        Unit_limit=20-num;
        return Unit_limit;
    }
    public  int getPassed_unit(){
        return Passed_unit;
    }
    public static void add_course(ArrayList<Department> courses,Department lesson){
    }

}
