public class Department {
    private String lesson_name , teacher_name,lesson_code ;
    private int vahed_num ,day_num , time_num ;
    public void setLesson_name(String lesson_name){
        this.lesson_name=lesson_name;
    }
    public void setTeacher_name(String teacher_name){
        this.teacher_name=teacher_name;
    }
    public void setLesson_code(String lesson_code){
        this.lesson_code=lesson_code;
    }
    public void setVahed_num(String vahed_num){
        int num = Integer.parseInt(vahed_num);
        this.vahed_num=num;
    }
    public void setDay_num(String day_num){
        int num = Integer.parseInt(day_num);
        this.day_num = num ;
    }
    public void setTime_num(String time_num){
        int num = Integer.parseInt(time_num);
        this.time_num = num;
    }
    public String getLesson_name(){
        return lesson_name;
    }
    public String getTeacher_name(){
        return teacher_name;
    }
    public String getLesson_code(){
        return lesson_code;
    }
    public int getVahed_num(){
        return vahed_num;
    }
    public int getDay_num(){
        return day_num;
    }
    public int getTime_num(){
        return time_num;
    }
    public String cast_day(){
        if(day_num==1){
            return "Day : Saturday / Monday";
        }
        if(day_num==2){
            return "Day : Sunday / Tuesday" ;
        }
        return "";
    }
    public String cast_time(){
        if(time_num==1){
            return "Time : 7:30 to 9:00";
        }
        if(time_num==2){
            return"Time : 9:00 to 10:30";
        }
        if(time_num==3){
            return "Time : 10:30 to 12:00";
        }
        return "";
    }
}
