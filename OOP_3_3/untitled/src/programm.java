import card.Archer;
import card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class programm {
    Register_Login register_login = new Register_Login();
    private Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        //menu of register/login
        while(true){
            boolean is_true = false;
            String input = scanner.nextLine();
            if(input.equals("Exit")){
                is_true=true ;
                return;
            }
            if(input.equals("show current menu")){
                is_true=true ;
                System.out.println("Register/Login Menu");
            }
            String regex_register = "register username (?<username>.*) password (?<password>.*)";
            Matcher matcher = getCommandMatcher(input , regex_register);
            if(matcher.find()){
                is_true=true ;
                String username = matcher.group("username");
               int error = register_login.register_user(matcher.group("username"),matcher.group("password"));
                switch (error){
                case 0:
                    System.out.println("User "+username+" created successfully!");
                    break;
                case 1:
                    System.out.println("Incorrect format for username!");
                    break;
                case 2:
                    System.out.println("Incorrect format for password!");
                    break;
                case 3:
                    System.out.println("Username already exists!");
                    break;
            }
            }
            String regex_login = "login username (?<username>.*) password (?<password>.*)";
            Matcher matcher1 = getCommandMatcher(input , regex_login);
            if(matcher1.find()){
                is_true=true ;
                String username = matcher1.group("username");
                int error = register_login.login_user(matcher1.group("username"),matcher1.group("password"));
                switch (error){
                    case 0:
                        System.out.println("User "+username+" logged in!");
                        break;
                    case 1:
                        System.out.println("Incorrect format for username!");
                        break;
                    case 2:
                        System.out.println("Incorrect format for password!");
                        break;
                    case 3:
                        System.out.println("Username doesn't exist!");
                        break;
                    case 4:
                        System.out.println("Password is incorrect!");
                        break;
                }

            }
            //main menu
            while(register_login.get_login_user()!=null){
                Main_menu main_menu = new Main_menu(register_login.getUsers(),register_login.get_login_user());
                is_true = false ;
                input = scanner.nextLine();
                if(input.equals("logout")){
                    is_true=true ;
                    System.out.println("User "+register_login.get_login_user().getName()+" logged out successfully!");
                    register_login.logout();
                }
                if(input.equals("show current menu")){
                    is_true=true ;
                    System.out.println("Main Menu");
                }
                if(input.equals("list of users")){
                    is_true=true ;
                    ArrayList<User> users = register_login.getUsers();
                    for(int i = 0 ; i<users.size() ;i++){
                        System.out.println("user "+(i+1)+": "+users.get(i).getName());
                    }
                }
                if(input.equals("scoreboard")){
                    is_true=true ;
                    ArrayList<User>users = register_login.getUsers();
                    Collections.sort(users, new Comparator<User>() {
                        @Override
                        public int compare(User u1, User u2) {
                            if (u1.getLevel() != u2.getLevel()) {
                                return Integer.compare(u2.getLevel(), u1.getLevel());
                            } else if (u1.getExperience() != u2.getExperience()) {
                                return Integer.compare(u2.getExperience(), u1.getExperience());
                            } else {
                                return u1.getName().compareTo(u2.getName());
                            }
                        }
                    });
                    int counter =1 ;
                    if(users.size()<5){
                        for(int i = 0 ; i< users.size() ; i++){
                            System.out.println(counter+"- username: "+users.get(i).getName()+" level: "+users.get(i).getLevel()+" experience: "+users.get(i).getExperience());
                            counter++;
                        }
                    }
                    else {
                        for(int i = 0 ; i<5; i++){
                            System.out.println(counter+"- username: "+users.get(i).getName()+" level: "+users.get(i).getLevel()+" experience: "+users.get(i).getExperience());
                            counter++;
                        }
                    }
                }
                if(input.equals("profile menu")){
                    is_true=true ;
                    System.out.println("Entered profile menu!");
                    while(true){//profile menu
                        is_true = false;
                        input = scanner.nextLine();
                        if(input.equals("back")){
                            is_true=true ;
                            System.out.println("Entered main menu!");
                            break;
                        }
                        if(input.equals("show current menu")){
                            is_true=true ;
                            System.out.println("Profile Menu");
                        }
                        String regex_change_pass = "change password old password (?<oldpass>.*) new password (?<newpass>.*)";
                        Matcher matcher3 = getCommandMatcher(input , regex_change_pass);
                        if(matcher3.find()){
                            is_true=true ;
                            int num  = register_login.check_password_for_change(matcher3.group("oldpass"),matcher3.group("newpass"));
                            switch (num){
                                case 0:
                                    System.out.println("Password changed successfully!");
                                    break;
                                case 1:
                                    System.out.println("Incorrect password!");
                                    break;
                                case 2:
                                    System.out.println("Incorrect format for new password!");
                                    break;
                            }
                        }
                        if(input.equals("Info")){
                            is_true=true ;
                            System.out.println("username: "+register_login.get_login_user().getName());
                            System.out.println("password: "+register_login.get_login_user().getPassword());
                            System.out.println("level: "+register_login.get_login_user().getLevel());
                            System.out.println("experience: "+register_login.get_login_user().getExperience());
                            System.out.println("gold: "+register_login.get_login_user().getGold());
                            ArrayList<User>users = register_login.getUsers();
                            Collections.sort(users, new Comparator<User>() {
                                @Override
                                public int compare(User u1, User u2) {
                                    if (u1.getLevel() != u2.getLevel()) {
                                        return Integer.compare(u2.getLevel(), u1.getLevel());
                                    } else if (u1.getExperience() != u2.getExperience()) {
                                        return Integer.compare(u2.getExperience(), u1.getExperience());
                                    } else {
                                        return u1.getName().compareTo(u2.getName());
                                    }
                                }
                            });
                            for(int i = 0 ; i<users.size();i++){
                                if(users.get(i).getName().equals(register_login.get_login_user().getName())){
                                    System.out.println("rank: "+(i+1));
                                }
                            }
                        }
                        String regex_remove_from_battle_deck="remove from battle deck (?<cardname>.*)";
                        Matcher matcher4 = getCommandMatcher(input,regex_remove_from_battle_deck);
                        if(matcher4.find()){
                            is_true = true ;
                            int num = main_menu.remove_from_battle_deck(matcher4.group("cardname"));
                            switch (num){
                                case 0:
                                    System.out.println("Card "+matcher4.group("cardname")+" removed successfully!");
                                    break;
                                case 1:
                                    System.out.println("Invalid card name!");
                                    break;
                                case 2:
                                    System.out.println("This card isn't in your battle deck!");
                                    break;
                                case 3:
                                    System.out.println("Invalid action: your battle deck will be empty!");
                                    break;
                            }
                        }
                        String regex_add_to_battle_deck= "add to battle deck (?<cardname>.*)";
                        Matcher matcher5  = getCommandMatcher(input,regex_add_to_battle_deck);
                        if(matcher5.find()){
                            is_true = true ;
                            int num = main_menu.add_to_battle_deck(matcher5.group("cardname"));
                            switch (num){
                                case 0:
                                    System.out.println("Card "+matcher5.group("cardname")+" added successfully!");
                                    break;
                                case 1:
                                    System.out.println("Invalid card name!");
                                    break;
                                case 2:
                                    System.out.println("You don't have this card!");
                                    break;
                                case 3:
                                    System.out.println("This card is already in your battle deck!");
                                    break;
                                case 4:
                                    System.out.println("Invalid action: your battle deck is full!");
                                    break;
                            }
                        }
                        if(input.equals("show battle deck")){
                            is_true=true;
                            Battle_deck battleDeck = main_menu.current_user.get_battle_deck();
                            ArrayList<Card>cards = battleDeck.getCards_in_battle_deck();
                            Comparator<Card>comparator = Comparator.comparing(Card::getName);
                            Collections.sort(cards,comparator);
                            for(Card card:cards){
                                System.out.println(card.getName());
                            }
                        }
                        if(is_true==false){
                            System.out.println("Invalid command!");
                        }
                    }
                }
                if(input.equals("shop menu")){
                    is_true=true ;
                    Shop_menu shop_menu = new Shop_menu(register_login.get_login_user());
                    System.out.println("Entered shop menu!");
                    while (true){//shop menu
                        is_true=false ;
                        input=scanner.nextLine();
                        if(input.equals("back")){
                            is_true=true;
                            System.out.println("Entered main menu!");
                            break;
                        }
                        if(input.equals("show current menu")){
                            is_true=true ;
                            System.out.println("Shop Menu");
                        }
                        String regex_buy_card = "buy card (?<cardname>.*)";
                        Matcher matcher6 = getCommandMatcher(input,regex_buy_card);
                        if(matcher6.find()){
                            is_true=true;
                            int num =shop_menu.buy_card(matcher6.group("cardname"));
                            switch (num){
                                case 0:
                                    System.out.println("Card "+matcher6.group("cardname")+" bought successfully!");
                                    break;
                                case 1:
                                    System.out.println("Invalid card name!");
                                    break;
                                case 2:
                                    System.out.println("Not enough gold to buy "+matcher6.group("cardname")+"!");
                                    break;
                                case 3:
                                    System.out.println("You have this card!");
                                    break;

                            }
                        }
                        String regex_sell_card = "sell card (?<cardname>.*)";
                        Matcher matcher7 = getCommandMatcher(input,regex_sell_card);
                        if(matcher7.find()){
                            is_true= true ;
                            int num = shop_menu.sell_card(matcher7.group("cardname"));
                            switch (num){
                                case 0:
                                    System.out.println("Card "+matcher7.group("cardname")+" sold successfully!");
                                    break;
                                case 1:
                                    System.out.println("Invalid card name!");
                                    break;
                                case 2:
                                    System.out.println("You don't have this card!");
                                    break;
                                case 3:
                                    System.out.println("You cannot sell a card from your battle deck!");
                                    break;

                            }
                        }
                        if(is_true==false){
                            System.out.println("Invalid command!");
                        }
                    }
                }
                String regex_newgame ="start game turns count (?<turnscount>.*) username (?<username>.*)";
                Matcher matcher2 = getCommandMatcher(input,regex_newgame);
                if (matcher2.find()){
                    is_true=true ;
                    boolean is_check = false ;
                    try{
                        int turn = Integer.parseInt(matcher2.group("turnscount"));
                        is_check = true ;
                        if(turn>30 ||turn<5){
                            is_check=false ;
                            System.out.println("Invalid turns count!");
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid turns count!");
                    }
                    if(is_check==true){
                        int num = register_login.check_username_for_new_game(matcher2.group("username"));
                        switch (num){
                            case 0:
                                System.out.println("Battle started with user "+matcher2.group("username"));
                                break;
                            case 1:
                                System.out.println("Incorrect format for username!");
                                break;
                            case 2:
                                System.out.println("Username doesn't exist!");
                                break;

                        }
                        if(num==0){
                            Game_menu game_menu = new Game_menu(register_login.get_login_user(),register_login.give_user_with_name(matcher2.group("username")),matcher2.group("turnscount"));
                            while (game_menu.is_game()==true){//game_menu
                                is_true = false ;
                                input = scanner.nextLine();
                                if(input.equals("show current menu")){
                                    is_true=true ;
                                    System.out.println("Game Menu");
                                }
                                if(input.equals("show the hitpoints left of my opponent")){
                                    is_true=true;
                                    System.out.println("middle castle: "+game_menu.get_castle(game_menu.getUser_who_play()).get(1).getDefense_hitpoint());
                                    System.out.println("left castle: "+game_menu.get_castle(game_menu.getUser_who_play()).get(0).getDefense_hitpoint());
                                    System.out.println("right castle: "+game_menu.get_castle(game_menu.getUser_who_play()).get(2).getDefense_hitpoint());
                                }
                                String regex_show_line_info="show line info (?<linedirection>.*)";
                                Matcher matcher8= getCommandMatcher(input,regex_show_line_info);
                                if(matcher8.find()){
                                    is_true=true;
                                    ArrayList<Card>[] ans = game_menu.troops_in_game(matcher8.group("linedirection"));
                                    if(ans==null){
                                        System.out.println("Incorrect line direction!");
                                    }
                                    else{
                                        System.out.println(matcher8.group("linedirection")+" line:");
                                        for(int i = 0 ; i<15 ; i++){
                                            if(ans[i].size()!=0){
                                                System.out.print("row "+(i+1)+":");
                                                for(int j =0 ; j<ans[i].size();j++){
                                                    System.out.print(" "+ans[i].get(j).getName()+": "+ans[i].get(j).getPlayer()+" ");
                                                }
                                                System.out.println();
                                            }
                                        }
                                    }
                                }
                                if(input.equals("number of cards to play")){
                                    is_true=true;
                                    System.out.println("You can play "+game_menu.getNumber_of_cards_to_play()+" cards more!");
                                }
                                if(input.equals("number of moves left")){
                                    is_true=true;
                                    System.out.println("You have "+game_menu.getNumber_of_moves_left()+" moves left!");
                                }
                                String regex_move_troop = "move troop in line (?<linedirection>.*) and row (?<rownumber>.*) (?<direction>.*)";
                                Matcher matcher9 = getCommandMatcher(input,regex_move_troop);
                                if(matcher9.find()){
                                    is_true=true;
                                    String name = game_menu.name_of_troop_in_move(matcher9.group("linedirection"),matcher9.group("rownumber"));
                                    int error = game_menu.move_troop(matcher9.group("linedirection"),matcher9.group("rownumber"),matcher9.group("direction"));
                                    switch (error){
                                        case 0:
                                            System.out.println(name+" moved successfully to row "+game_menu.final_row_after_move(matcher9.group("rownumber"),matcher9.group("direction"))+" in line "+matcher9.group("linedirection"));
                                            break;
                                        case 1:
                                            System.out.println("Incorrect line direction!");
                                            break;
                                        case 2:
                                            System.out.println("Invalid row number!");
                                            break;
                                        case 3:
                                            System.out.println("you can only move troops upward or downward!");
                                            break;
                                        case 4:
                                            System.out.println("You are out of moves!");
                                            break;
                                        case 5:
                                            System.out.println("You don't have any troops in this place!");
                                            break;
                                        case 6:
                                            System.out.println("Invalid move!");
                                            break;

                                    }
                                }
                                String regex_deploy_troops="deploy troop (?<troopname>.*) in line (?<linedirection>.*) and row (?<rownumber>.*)";
                                Matcher matcher10 = getCommandMatcher(input,regex_deploy_troops);
                                if(matcher10.find()){
                                    is_true=true;
                                    int error = game_menu.deploy_troop(matcher10.group("troopname"),matcher10.group("linedirection"),matcher10.group("rownumber"));
                                    switch (error){
                                        case 0:
                                            System.out.println("You have deployed "+matcher10.group("troopname")+" successfully!");
                                            break;
                                        case 1:
                                            System.out.println("Invalid troop name!");
                                            break;
                                        case 2:
                                            System.out.println("You don't have "+matcher10.group("troopname")+" card in your battle deck!");
                                            break;
                                        case 3:
                                            System.out.println("Incorrect line direction!");
                                            break;
                                        case 4:
                                            System.out.println("Invalid row number!");
                                            break;
                                        case 5:
                                            System.out.println("Deploy your troops near your castles!");
                                            break;
                                        case 6:
                                            System.out.println("You have deployed a troop or spell this turn!");
                                            break;
                                    }
                                }
                                String regex_deploy_fireball="deploy spell Fireball in line (?<linedirection>.*)";
                                Matcher matcher11 = getCommandMatcher(input,regex_deploy_fireball);
                                if(matcher11.find()){
                                    is_true=true;
                                    int error = game_menu.deploy_fireball(matcher11.group("linedirection"));
                                    switch (error){
                                        case 0:
                                            System.out.println("You have deployed Fireball successfully!");
                                            break;
                                        case 1:
                                            System.out.println("Incorrect line direction!");
                                            break;
                                        case 2:
                                            System.out.println("You don't have Fireball card in your battle deck!");
                                            break;
                                        case 3:
                                            System.out.println("You have deployed a troop or spell this turn!");
                                            break;
                                        case 4:
                                            System.out.println("This castle is already destroyed!");
                                            break;

                                    }
                                }
                                if(input.equals("next turn")){
                                    is_true = true ;
                                    game_menu.next_turn();
                                    if(game_menu.is_finished()==true){
                                        break;
                                    }
                                }
                                if(is_true==false){
                                    System.out.println("Invalid command!");
                                }

                            }
                        }
                    }
                }
                if(is_true==false){
                    System.out.println("Invalid command!");
                }
            }
            Archer archer = new Archer();
            if(is_true==false){
                System.out.println("Invalid command!");
            }
        }
    }
//    User current_user = register_login;

}
