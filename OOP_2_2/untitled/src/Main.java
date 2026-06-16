import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean count_word(String input){
        String c[] = input.split("\\s+");
            switch (c[0]){
                case"-signin":
                    if(c.length<4){
                        return false;
                    }
                    break;
                case "-edit" :
                    switch (c[1]){
                        case "profile":
                            if(c.length<5){
                                return false;
                            }
                            break;
                    }
                    break;
                case "-login" :
                    if(c.length<4){
                        return false;
                    }
                    break;
                case "-select":
                case "-delete course":
                    if(c.length<2){
                        return false;
                    }
                    break;
            }
            return true;

    }
    public static void error(int i ,int j){
        switch (i) {
            case 0:
                switch (j) {
                    case 1:
                        System.out.println("First name first character should be uppercase !");
                        break;
                    case 2:
                        System.out.println("Last name first character should be uppercase !");
                        break;
                    case 3:
                        System.out.println("The ID number contains characters other than numbers or is too short !");
                        break;
                }
                break;
            case 1:
                switch (j) {
                    case 1:
                    System.out.println("Year must be a number !");
                    break;
                    case 2:
                        System.out.println("Year must be 1401 or 1402 !");
                        break;
                    case 3:
                        System.out.println("Phone must be a number and it's length should be 10 !");
                        break;
                    case 4:
                        System.out.println("Units must be a number !");
                        break;
                    case 5:
                        System.out.println("Units must be between 10 and 90 !");
                        break;

                }
                break;
        }

    }
    public static boolean Pattern_check_error(String input , Pattern patterns[][] , boolean login) {
        if (count_word(input) == true) {
            for (int i = 0; i < 10; i++) {
                if (i == 0 | ((i == 1) && login == true)) {
                    for (int j = 1; j < 6; j++) {
                        Matcher matcher = patterns[i][j].matcher(input);
                        if (matcher.find()) {
                            error(i, j);
                            return false;
                        }
                    }
                }
            }
        }
            return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern1;
        Pattern[][] patterns = new Pattern[10][6];
        Pattern pattern = Pattern.compile("^\\s*(.+)\\,\\s*(\\d)\\s*\\,\\s*(\\S+)\\s*\\,\\s*(\\d)\\s*\\,\\s*(\\d)\\s*\\,\\s*(\\S+)\\s*$");//برای ورودی اسامی دانشکده
//***********************************************************************************************************************
        patterns[0][0] = Pattern.compile("^-signin\\s+([A-Z]\\S*)\\s+([A-Z]\\S*)\\s+(\\d{9})\\s*$");
        patterns[0][1] = Pattern.compile("^-signin\\s+([^A-Z]\\S*)");
        patterns[0][2] = Pattern.compile("^-signin\\s+([A-Z]\\S*)\\s+([^A-Z]\\S*)");
        patterns[0][3] = (Pattern.compile("^-signin\\s+([A-Z]\\S*)\\s+([A-Z]\\S*)\\s+(?!\\d{9}\\b)")); //signin
        patterns[0][4] = Pattern.compile("^$");
        patterns[0][5] = Pattern.compile("^$");
//***********************************************************************************************************************
        patterns[1][0] = (Pattern.compile("^-edit profile\\s+(1402|1401)\\s+(\\d{10})\\s+([1-8][0-9])$"));
        patterns[1][1] = (Pattern.compile("^-edit profile\\s+\\d*[A-Za-z\\.]+\\d*"));
        patterns[1][2] = (Pattern.compile("^-edit profile\\s+(?!140[12]\\b)"));
        patterns[1][3] = (Pattern.compile("^-edit profile\\s+(1402|1401)\\s+(\\D+|(?!\\b\\d{10}\\b)\\d+)"));
        patterns[1][4] = (Pattern.compile("^-edit profile\\s+(1402|1401)\\s+([1-9]\\d{9})\\s+\\d*[A-Za-z\\.]+\\d*"));
        patterns[1][5] = (Pattern.compile("^-edit profile\\s+(1402|1401)\\s+(\\d{10})\\s+(?!([1-8][0-9])\\b)"));

//***********************************************************************************************************************
        patterns[2][0] = (Pattern.compile("^\\s*-\\s*login\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s*$"));
        patterns[3][0] = (Pattern.compile("^\\s*-\\s*logout\\s*$"));//logout
        patterns[4][0] = (Pattern.compile("^\\s*-\\s*show\\s+department\\s+list\\s*$"));//لیست دروس دانشکده
        patterns[5][0] = (Pattern.compile("^\\s*-\\s*show\\s+my\\s+list\\s*$"));//دروس فرد
        patterns[6][0] = (Pattern.compile("^\\s*-\\s*select\\s+(\\d+)\\s*$"));//اخذ درس
        patterns[7][0] = (Pattern.compile("^\\s*-\\s*delete course\\s+(\\d+)\\s*$"));//حذف درس
        patterns[8][0] = (Pattern.compile("^\\s*-\\s*show\\s+profile\\s*$"));//پروفایل شخص
        patterns[9][0] = (Pattern.compile("^\\s*-\\s*select\\s+all\\s+"));//اخذ چند درس
        String q = scanner.nextLine();//تعداد دروس
        int a = Integer.parseInt(q);
        Department[] department = new Department[a];//اشیا از جنس درس
        for (int i = 0; i < a; i++) {
            String input_lesson_data;
            input_lesson_data = scanner.nextLine();
            Matcher matcher = pattern.matcher(input_lesson_data);
            if (!matcher.find()) {
                System.out.println("Invalid command !");
            } else {
                department[i] = new Department();
                department[i].setLesson_name(matcher.group(1));
                department[i].setVahed_num(matcher.group(2));
                department[i].setTeacher_name(matcher.group(3));
                department[i].setDay_num(matcher.group(4));
                department[i].setTime_num(matcher.group(5));
                department[i].setLesson_code(matcher.group(6));
            }
        }
        String input;
        currentuser currentuser = new currentuser("","","");
        ArrayList<Student>students = new ArrayList<>();
        boolean login = false;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("-end"))
                break;
            if(Pattern_check_error(input, patterns,login)==true){
                boolean is_check = false;
                for(int i = 0 ; i<10 ; i++){
                    Matcher matcher =patterns[i][0].matcher(input);
                    if(matcher.find()){
                        is_check=true;
                        switch (i){
                            case 0:
                                boolean is_check_2 = false;
                                for(int j =0 ; j<students.size();j++){
                                    if(students.get(j).getStudent_ID().equals(matcher.group(3)) && students.get(j).getLast_name().equals(matcher.group(2)) && students.get(j).getFirst_name().equals(matcher.group(1))){
                                        System.out.println("A student with this name exist !");
                                        is_check_2=true;
                                    }
                                }
                                if(is_check_2==false) {
                                    students.add(new Student(matcher.group(1), matcher.group(2), matcher.group(3)));
                                    System.out.println("Student with name \"" + matcher.group(1) + " " + matcher.group(2) + "\" and ID number \"" + matcher.group(3) + "\" created !");
                                }
                                break;
                            case 1:
                                if(currentuser.getStudent_ID().equals("")){
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                for(int j = 0 ;j<students.size();j++){
                                    if(currentuser.getStudent_ID().equals(students.get(j).getStudent_ID()) && currentuser.getFirst_name().equals(students.get(j).getFirst_name()) && currentuser.getLast_name().equals(students.get(j).getLast_name())){
                                        students.get(j).setEntrance_year(matcher.group(1));
                                        students.get(j).setPhone_number(matcher.group(2));
                                        students.get(j).setPassed_unit(matcher.group(3));
                                        System.out.println("Profile edited successfully !");
                                    }
                                }
                                break;
                            case 2:
                                boolean x = false;
                                for(int j =0 ; j<students.size();j++ ){
                                    if(students.get(j).getStudent_ID().equals(matcher.group(3)) && students.get(j).getLast_name().equals(matcher.group(2)) && students.get(j).getFirst_name().equals(matcher.group(1))){
                                        currentuser.setStudent_ID(matcher.group(3));
                                        currentuser.setFirst_name(matcher.group(1));
                                        currentuser.setLast_name(matcher.group(2));
                                        System.out.println("Welcome \""+matcher.group(1)+"\"");
                                        login = true;
                                        x=true;
                                    }
                                }
                                if(x==false){
                                    System.out.println("There is no student with this name and ID !");
                                }
                                break;
                            case 3:
                                if(currentuser.getStudent_ID().equals("")){
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                else{
                                    System.out.println("Logged out successfully !");
                                    login=false;
                                    currentuser.setStudent_ID("");
                                }
                                break;
                            case 4:
                                System.out.println("Department List is :");
                                for(int j = 0 ; j<a ; j++){
                                    System.out.println(j+1+". "+department[j].getLesson_name()+" - "+department[j].getLesson_code()+" - "+department[j].getTeacher_name()+" - "+department[j].cast_time()+" - "+department[j].cast_day());
                                }
                                break;
                            case 5:
                                if(currentuser.getStudent_ID().equals("")){
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                for(int j = 0 ; j<students.size();j++){
                                    if(currentuser.getStudent_ID().equals(students.get(j).getStudent_ID()) && currentuser.getFirst_name().equals(students.get(j).getFirst_name()) && currentuser.getLast_name().equals(students.get(j).getLast_name())) {
                                       if(students.get(j).courses.size()==0){
                                           System.out.println("List is empty !");
                                       }
                                       else{
                                           System.out.println("My List is :");
                                           for(int k = 0 ; k<students.get(j).courses.size();k++){
                                               System.out.println(k+1+". "+students.get(j).courses.get(k).getLesson_name()+" - "+students.get(j).courses.get(k).getLesson_code());
                                           }
                                       }
                                    }
                                }
                                break;
                            case 6:
                                if(currentuser.getStudent_ID().equals("")){
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                boolean seen=false;
                                boolean seen_1 = false;
                                for(int j = 0 ; j<students.size();j++){
                                    if(currentuser.getStudent_ID().equals(students.get(j).getStudent_ID()) && currentuser.getFirst_name().equals(students.get(j).getFirst_name()) && currentuser.getLast_name().equals(students.get(j).getLast_name())) {
                                        if(students.get(j).getPhone_number()==null){
                                            System.out.println("Please first edit your profile !");
                                            break;
                                        }
                                        else if(students.get(j).getUnit_limit()==0) {
                                            System.out.println("Unit Limits Error !");
                                            break;
                                        }
                                        for(int k=0 ; k<a; k++){
                                            if(department[k].getLesson_code().equals(matcher.group(1))){
                                                seen_1=true;
                                                students.get(j).courses.add(department[k]);
                                                if(students.get(j).getUnit_limit()<0){ //تعداد سقف واحد
                                                    System.out.println("Unit Limits Error !");
                                                    students.get(j).courses.remove(students.get(j).courses.size()-1);
                                                    seen=true;
                                                }
                                                if(seen==false) {//برداشتن درسی که برداشته بودیم
                                                    for (int z = 0; z < students.get(j).courses.size() - 1; z++) {
                                                        String lesson_code_enter = matcher.group(1).substring(0, 5);
                                                        String lesson_code_get_past = students.get(j).courses.get(z).getLesson_code().substring(0, 5);
                                                        if (lesson_code_enter.equals(lesson_code_get_past)) {
                                                            System.out.println("Same Course Code Error !");
                                                            students.get(j).courses.remove(students.get(j).courses.size()-1);
                                                            seen=true;
                                                        }
                                                    }
                                                }
                                                if(seen==false){
                                                    for (int z=0;z<students.get(j).courses.size()-1;z++){
                                                        if(students.get(j).courses.get(z).getDay_num()==department[k].getDay_num() && students.get(j).courses.get(z).getTime_num()==department[k].getTime_num()){
                                                            System.out.println("Same Time Error !");
                                                            students.get(j).courses.remove(students.get(j).courses.size()-1);
                                                            seen=true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if(!seen_1){
                                            System.out.println("Invalid Code !");
                                        }
                                        if(seen_1==true && seen==false){
                                            System.out.println("Course added successfully !");
                                        }
                                    }
                                }
                                break;
                            case 7:
                                if(currentuser.getStudent_ID().equals("")){
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                seen = false;
                                for(int j = 0 ; j<students.size();j++){
                                    if(currentuser.getStudent_ID().equals(students.get(j).getStudent_ID()) && currentuser.getFirst_name().equals(students.get(j).getFirst_name()) && currentuser.getLast_name().equals(students.get(j).getLast_name())) {
                                        for(int k = 0 ; k<students.get(j).courses.size();k++){
                                            if(matcher.group(1).equals(students.get(j).courses.get(k).getLesson_code())){
                                                seen=true;
                                                System.out.println("Course deleted successfully !");
                                                students.get(j).courses.remove(students.get(j).courses.get(k));
                                            }
                                        }
                                        if(seen==false){
                                            System.out.println("Course with this code does not exist in your list !");
                                        }
                                    }
                                    }
                                break;
                            case 8:
                                if(currentuser.getStudent_ID().equals("")){
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                for(int j = 0 ; j<students.size();j++){
                                    if(currentuser.getStudent_ID().equals(students.get(j).getStudent_ID()) && currentuser.getFirst_name().equals(students.get(j).getFirst_name()) && currentuser.getLast_name().equals(students.get(j).getLast_name())) {
                                        if(students.get(j).getPhone_number()==null){
                                            System.out.println("Please first edit your profile !");
                                        }
                                        else {
                                            System.out.println("First name : "+students.get(j).getFirst_name());
                                            System.out.println("Last name : "+students.get(j).getLast_name());
                                            System.out.println("Student ID : "+students.get(j).getStudent_ID());
                                            System.out.println("Entrance year : "+students.get(j).getEntrance_year());
                                            System.out.println("Phone number : "+students.get(j).getPhone_number());
                                            System.out.println("Passed units : "+students.get(j).getPassed_unit());
                                            System.out.println("Units limit : "+students.get(j).getUnit_limit());
                                            System.out.println("Courses number : "+students.get(j).courses.size());
                                        }

                                    }
                                }

                                break;
                            case 9:
                                ArrayList<String>Invalid_codes = new ArrayList<>();
                                ArrayList<String>Unit_limit = new ArrayList<>();
                                ArrayList<String>Same_corse_code = new ArrayList<>();
                                ArrayList<String>Same_time = new ArrayList<>();

                                String [] chand_dars = input.split("\\s+");
                                if(currentuser.getStudent_ID().equals("") || chand_dars.length==2) {
                                    System.out.println("Invalid command !");
                                    break;
                                }
                                for(int j = 0 ; j<students.size();j++) {
                                    if (currentuser.getStudent_ID().equals(students.get(j).getStudent_ID()) && currentuser.getFirst_name().equals(students.get(j).getFirst_name()) && currentuser.getLast_name().equals(students.get(j).getLast_name())) {
                                        if (students.get(j).getPhone_number() == null) {
                                            System.out.println("Please first edit your profile !");
                                            break;
                                        }
                                        else if(students.get(j).getUnit_limit()==0) {
                                            System.out.println("You have selected 20 units already !");
                                            break;
                                        }
                                        for(int n = 2 ; n<chand_dars.length;n++){
                                            boolean is_check_3 = false ;
                                            boolean is_check_4 = false;
                                            for(int k = 0 ; k<a ; k++){
                                                if(chand_dars[n].equals(department[k].getLesson_code())){
                                                    is_check_3=true;
                                                    students.get(j).courses.add(department[k]);
                                                    if(students.get(j).getUnit_limit()<0) { //تعداد سقف واحد
                                                        students.get(j).courses.remove(students.get(j).courses.size() - 1);
                                                        Unit_limit.add(chand_dars[n]);
                                                        is_check_4=true ;
                                                    }
                                                    if(is_check_4==false){
                                                        for (int z = 0; z < students.get(j).courses.size() - 1; z++) {
                                                            String lesson_code_enter = chand_dars[n].substring(0, 5);
                                                            String lesson_code_get_past = students.get(j).courses.get(z).getLesson_code().substring(0, 5);
                                                            if (lesson_code_enter.equals(lesson_code_get_past)) {
                                                                Same_corse_code.add(chand_dars[n]);
                                                                students.get(j).courses.remove(students.get(j).courses.size()-1);
                                                                is_check_4=true;
                                                            }
                                                        }
                                                    }
                                                    if(is_check_4==false){
                                                        for (int z=0;z<students.get(j).courses.size()-1;z++){
                                                            if(students.get(j).courses.get(z).getDay_num()==department[k].getDay_num() && students.get(j).courses.get(z).getTime_num()==department[k].getTime_num()){
                                                                students.get(j).courses.remove(students.get(j).courses.size()-1);
                                                                Same_time.add(chand_dars[n]);
                                                                is_check_4=true;
                                                            }
                                                        }
                                                    }
                                                    if(is_check_4==false){
                                                        System.out.println("Course "+chand_dars[n]+ " added successfully !");

                                                    }

                                                    }
                                            }
                                            if(is_check_3==false){
                                                Invalid_codes.add(chand_dars[n]);
                                            }
                                        }
                                    }
                                }
                                if(Invalid_codes.size()!=0) {
                                    System.out.print("Invalid Codes ->");
                                    for (String as : Invalid_codes) {
                                        System.out.print(" " + as );
                                    }
                                    System.out.print("\n");
                                }
                                if(Unit_limit.size()!=0) {
                                    System.out.print("Unit Limit Codes ->");
                                    for (String as : Unit_limit) {
                                        System.out.print(" " + as );
                                    }
                                    System.out.print("\n");
                                }
                                if(Same_corse_code.size()!=0) {
                                    System.out.print("Same Course Codes ->");
                                    for (String as : Same_corse_code) {
                                        System.out.print(" " + as );
                                    }
                                    System.out.print("\n");
                                }
                                if(Same_time.size()!=0) {
                                    System.out.print("Same Time Codes ->");
                                    for (String as : Same_time) {
                                        System.out.print(" " + as );
                                    }
                                    System.out.print("\n");
                                }

                                break;
                            default:
                                System.out.println("Invalid command !");
                                break;
                        }
                    }
                }
                if(is_check==false){
                    System.out.println("Invalid command !");
                }
            }
        }
    }
}