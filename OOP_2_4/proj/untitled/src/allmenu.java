import java.util.ArrayList;

public class allmenu {
    private game_menu game_menu = new game_menu() ;
    private login_menu login_menu = new login_menu() ;
    private profile_menu profile_menu = new profile_menu();
    private shop_menu shop_menu = new shop_menu() ;
    private signin_menu signin_menu = new signin_menu();
    private main_menu main_menu = new main_menu();
    private ArrayList<user> users = new ArrayList<>();
    private static int current_menu=1 ;
    public static void current_menu(int i){
        current_menu =i ;
    }
    public void get_current_menu(){
        switch (current_menu)
    }
}
