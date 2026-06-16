public class currentuser extends Student{
    private static Student student;
    private static currentuser instance;

    public currentuser(String first_name, String last_name, String student_ID) {
        super(first_name, last_name, student_ID);
    }
}
