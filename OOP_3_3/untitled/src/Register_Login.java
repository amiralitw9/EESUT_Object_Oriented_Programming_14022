import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register_Login {
    ArrayList<User>users = new ArrayList<>() ;
    User login_user=null ;
    public int register_user(String name , String password){
        String regex_name = "^[A-Za-z]+$";
        if(!(getCommandMatcher(name,regex_name).find())){
            return 1 ;
        }
        String regex_password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?! )[a-zA-Z0-9!@#$%^&*]{8,20}$";
        if(!(getCommandMatcher(password,regex_password).find())){
            return 2 ;
        }
        if(getCommandMatcher(password,regex_password).find()){
            if(password.charAt(0)>=48 && password.charAt(0)<=57){
                return 2;
            }
        }
        for(User user :users){
            if(user.getName().equals(name)){
                return 3 ;
            }
        }
        User user = new User(name,password);
        users.add(user);
        return 0 ;

    }
    public int login_user(String name ,String password){
        String regex_name = "^[A-Za-z]+$";
        if(!(getCommandMatcher(name,regex_name).find())){
            return 1 ;
        }
        String regex_password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,20}$";
        if(!(getCommandMatcher(password,regex_password).find())){
            return 2 ;
        }
        if(getCommandMatcher(password,regex_password).find()){
            if(password.charAt(0)>=48 && password.charAt(0)<=57){
                return 2;
            }
        }
        boolean find = false ;
        for(User user :users){
            if(user.getName().equals(name)){
                find = true ;
                login_user = user;
                if(!(user.getPassword().equals(password))){
                    login_user =null ;
                    return 4 ;
                }
            }
        }
        if(find==false){
            return 3 ;
        }
        return 0 ;


    }
    public User get_login_user(){
        return login_user;
    }
    public void logout(){
        login_user=null ;
    }
    private Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public ArrayList<User> getUsers(){
        return users ;
    }
    public int check_username_for_new_game(String username){
        String regex_name = "^[A-Za-z]+$";
        if(!(getCommandMatcher(username,regex_name).find())){
            return 1 ;
        }
        boolean find=false ;
        for(User user :users){
            if(user.getName().equals(username)){
                find = true ;
            }
        }
        if(find==false){
            return 2 ;
        }
        return 0 ;
    }
    public int check_password_for_change(String old_pass, String new_pass){
        if(login_user.getPassword().equals(old_pass)){
            String regex_password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,20}$";
            if(!(getCommandMatcher(new_pass,regex_password).find())){
                return 2 ;
            }
            if(getCommandMatcher(new_pass,regex_password).find()){
                if(new_pass.charAt(0)>=48 && new_pass.charAt(0)<=57){
                    return 2;
                }
            }

        }
        else {
            return 1 ;
        }
        login_user.setPassword(new_pass);
        return 0;
    }
    public User give_user_with_name(String name){
        for(User user:users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }
}
