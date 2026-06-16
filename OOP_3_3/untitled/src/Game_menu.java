import card.Card;
import card.Castle;

import java.util.ArrayList;

public class Game_menu {
    private boolean is_game= false ;
    private int turn;
    private User currentuser=null,guest_user=null,user_who_play=null;
    private ArrayList<Castle>castles_current_user = new ArrayList<>();
    private ArrayList<Castle>castles_guest_user = new ArrayList<>();
    ArrayList<Card> [] left_ground = new ArrayList[15];
    ArrayList<Card> [] middle_ground = new ArrayList[15];
    ArrayList<Card> [] right_ground = new ArrayList[15];


    public Game_menu(User currentuser , User guest_user,String turn){
        currentuser.setNumber_of_cards_to_play(1);
        guest_user.setNumber_of_cards_to_play(1);
        currentuser.setNumber_of_moves_left(3);
        guest_user.setNumber_of_moves_left(3);
        this.turn=Integer.parseInt(turn);
        this.currentuser=currentuser;
        this.guest_user = guest_user ;
        this.user_who_play=currentuser;
        castles_current_user.add(new Castle(currentuser.getLevel(),0));
        castles_current_user.add(new Castle(currentuser.getLevel(),1));
        castles_current_user.add(new Castle(currentuser.getLevel(),2));
        castles_guest_user.add(new Castle(guest_user.getLevel(),0));
        castles_guest_user.add(new Castle(guest_user.getLevel(),1));
        castles_guest_user.add(new Castle(guest_user.getLevel(),2));
        is_game = true ;
        for(int i = 0 ; i<15 ; i++){
            left_ground[i]=new ArrayList<Card>();
            middle_ground[i]=new ArrayList<Card>();
            right_ground[i]=new ArrayList<Card>();
        }
        for(Card card:currentuser.get_battle_deck().getCards_in_battle_deck()){
            card.setPlayer(currentuser.getName());
        }
        for(Card card : guest_user.get_battle_deck().getCards_in_battle_deck()){
            card.setPlayer(guest_user.getName());
        }

    }
    public void change_who_play(){
        if(user_who_play==currentuser){
            user_who_play=guest_user;
        }
        else {
            user_who_play=currentuser;
        }
    }
    public boolean is_game(){
        if(is_game==true){
            return true;
        }
        else
            return false;
    }
    public User getUser_who_play(){
        return user_who_play;
    }
    public ArrayList<Castle> get_castle(User who_play){
        if(who_play.equals(currentuser)){
            return castles_guest_user;
        }
        else return castles_current_user;
    }
    public ArrayList[] troops_in_game(String position){
        switch (position){
            case "right":
                return right_ground;
            case "left":
                return left_ground;
            case "middle":
                return middle_ground;
            default:
                return null;

        }
    }

    public int getNumber_of_cards_to_play() {
        return user_who_play.getNumber_of_cards_to_play();
    }

    public int getNumber_of_moves_left() {
        return user_who_play.getNumber_of_moves_left();
    }
    public int move_troop(String line_direction,String row_number,String direction){
        try {
            int rownumber = Integer.parseInt(row_number);
            if(rownumber>15 || rownumber<1){
                return 2;
            }
        }
        catch (NumberFormatException e){
            return 2 ;
        }
        switch (line_direction){
            case "right":
                break;
            case "left":
                break;
            case "middle":
                break;
            default:
                return 1;
        }
        switch (direction){
            case "upward":
                break;

            case "downward":
                break;
            default:
                return 3;
        }
        if(user_who_play.getNumber_of_moves_left()==0){
            return 4;
        }
        int rownumber = Integer.parseInt(row_number);
        switch (line_direction) {
            case "right":
                for(int i=0 ; i<right_ground[rownumber-1].size();i++){
                    if(right_ground[rownumber-1].get(i).getPlayer().equals(user_who_play.getName())){
                        if(rownumber==15 && direction.equals("upward")){
                            return 6;
                        }
                        if(rownumber==1 && direction.equals("downward")){
                            return 6;
                        }
                        switch (direction){
                            case "upward":
                                right_ground[rownumber].add(right_ground[rownumber-1].get(i));
                                right_ground[rownumber-1].remove(i);
                                user_who_play.setNumber_of_moves_left(user_who_play.getNumber_of_moves_left()-1);
                                break;
                            case "downward":
                                right_ground[rownumber-2].add(right_ground[rownumber-1].get(i));
                                right_ground[rownumber-1].remove(i);
                                user_who_play.setNumber_of_moves_left(user_who_play.getNumber_of_moves_left()-1);
                                break;
                        }
                        return 0;
                    }
                }
                return 5;
            case "left":
                for(int i=0 ; i<left_ground[rownumber-1].size();i++){
                    if(left_ground[rownumber-1].get(i).getPlayer().equals(user_who_play.getName())){
                        if(rownumber==15 && direction.equals("upward")){
                            return 6;
                        }
                        if(rownumber==1 && direction.equals("downward")){
                            return 6;
                        }
                        switch (direction){
                            case "upward":
                                left_ground[rownumber].add(left_ground[rownumber-1].get(i));
                                left_ground[rownumber-1].remove(i);
                                user_who_play.setNumber_of_moves_left(user_who_play.getNumber_of_moves_left()-1);
                                break;
                            case "downward":
                                left_ground[rownumber-2].add(left_ground[rownumber-1].get(i));
                                left_ground[rownumber-1].remove(i);
                                user_who_play.setNumber_of_moves_left(user_who_play.getNumber_of_moves_left()-1);
                                break;
                        }
                        return 0;
                    }
                }
                return 5;
            case "middle":
                for(int i=0 ; i<middle_ground[rownumber-1].size();i++){
                    if(middle_ground[rownumber-1].get(i).getPlayer().equals(user_who_play.getName())){
                        if(rownumber==15 && direction.equals("upward")){
                            return 6;
                        }
                        if(rownumber==1 && direction.equals("downward")){
                            return 6;
                        }
                        switch (direction){
                            case "upward":
                                middle_ground[rownumber].add(middle_ground[rownumber-1].get(i));
                                middle_ground[rownumber-1].remove(i);
                                user_who_play.setNumber_of_moves_left(user_who_play.getNumber_of_moves_left()-1);
                                break;
                            case "downward":
                                middle_ground[rownumber-2].add(middle_ground[rownumber-1].get(i));
                                middle_ground[rownumber-1].remove(i);
                                user_who_play.setNumber_of_moves_left(user_who_play.getNumber_of_moves_left()-1);
                                break;
                        }
                        return 0;
                    }
                }
                return 5;
        }
        return 6;
        }
    public String name_of_troop_in_move(String line_direction,String row_number){
        int rownumber = Integer.parseInt(row_number);
        if(rownumber>0 && rownumber<15){
            switch (line_direction) {
                case "right":
                    for(int i=0 ; i<right_ground[rownumber-1].size();i++){
                        if(right_ground[rownumber-1].get(i).getPlayer().equals(user_who_play.getName())){
                            return right_ground[rownumber-1].get(i).getName();
                        }
                    }
                case "left":
                    for(int i=0 ; i<left_ground[rownumber-1].size();i++){
                        if(left_ground[rownumber-1].get(i).getPlayer().equals(user_who_play.getName())){
                            return left_ground[rownumber-1].get(i).getName();
                        }
                    }
                case "middle":
                    for(int i=0 ; i<middle_ground[rownumber-1].size();i++){
                        if(middle_ground[rownumber-1].get(i).getPlayer().equals(user_who_play.getName())){
                            return middle_ground[rownumber-1].get(i).getName();
                        }
                    }
            }
        }
        return null;

    }
    public int final_row_after_move(String row_number,String direction) {
        int rownumber = Integer.parseInt(row_number);
        switch (direction) {
            case "upward":
                return rownumber + 1;
            case "downward":
                return rownumber - 1;
        }
        return 0;
    }
    public int deploy_troop(String troop_name , String line_direction, String row_number){
        switch (troop_name){
            case "Wizard":
                break;
            case "Archer":
                break;
            case "Dragon":
                break;
            default:
                return 1 ;
        }
        boolean is_find = false;
        for(int i = 0 ; i<user_who_play.get_battle_deck().getCards_in_battle_deck().size();i++){
            if(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i).getName().equals(troop_name)){
                is_find=true;
            }
        }
        if(is_find==false){
            return 2;
        }
        switch (line_direction){
            case "right":
                break;
            case "left":
                break;
            case "middle":
                break;
            default:
                return 3;

        }
        try{
            int rownumber = Integer.parseInt(row_number);
        }
        catch (NumberFormatException e){
            return 4;
        }
        int rownumber = Integer.parseInt(row_number);
        if(rownumber<1 || rownumber>15){
            return 4;
        }
        if(user_who_play.equals(currentuser)){
            if(rownumber>4){
                return 5;
            }
        }
        if(user_who_play.equals(guest_user)){
            if(rownumber<12){
                return 5;
            }
        }
        if(user_who_play.getNumber_of_cards_to_play()==0){
            return 6;
        }
// توابع مربوطه به اجرا
        for(int i = 0 ; i<user_who_play.get_battle_deck().getCards_in_battle_deck().size();i++){
            if(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i).getName().equals(troop_name)){
                switch (line_direction){
                    case "right":
                        right_ground[rownumber-1].add(new Card(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i)));
                        user_who_play.setNumber_of_cards_to_play(0);
                        break;
                    case "left":
                        left_ground[rownumber-1].add(new Card(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i)));
                        user_who_play.setNumber_of_cards_to_play(0);
                        break;
                    case "middle":
                        middle_ground[rownumber-1].add(new Card(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i)));
                        user_who_play.setNumber_of_cards_to_play(0);
                        break;
                }
            }
        }

        return 0;
    }
    public int deploy_fireball(String line_direction){
        switch (line_direction){
            case "middle":
                break;
            case "left":
                break;
            case "right":
                break;
            default:
                return 1;

        }
        boolean is_find = false ;
        for(int i = 0 ; i<user_who_play.get_battle_deck().getCards_in_battle_deck().size();i++){
            if(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i).getName().equals("Fireball")){
                is_find=true;
            }
        }
        if(is_find==false){
            return 2;
        }
        if(user_who_play.getNumber_of_cards_to_play()==0){
            return 3;
        }
        if(user_who_play.equals(currentuser)){
            switch (line_direction){
                case "left":
                    if(castles_guest_user.get(0).getDefense_hitpoint()==-1){
                        return 4 ;
                    }
                    break;
                case "middle":
                    if(castles_guest_user.get(1).getDefense_hitpoint()==-1){
                        return 4 ;
                    }
                    break;
                case "right":
                    if(castles_guest_user.get(2).getDefense_hitpoint()==-1){
                        return 4 ;
                    }
                    break;
            }
        }
        else {
            switch (line_direction){
                case "left":
                    if(castles_current_user.get(0).getDefense_hitpoint()==-1){
                        return 4 ;
                    }
                    break;
                case "middle":
                    if(castles_current_user.get(1).getDefense_hitpoint()==-1){
                        return 4 ;
                    }
                    break;
                case "right":
                    if(castles_current_user.get(2).getDefense_hitpoint()==-1){
                        return 4 ;
                    }
                    break;

            }
        }
        if(user_who_play.equals(currentuser)){
            for(int i = 0 ; i<user_who_play.get_battle_deck().getCards_in_battle_deck().size();i++){
                if(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i).getName().equals("Fireball")){
                    switch (line_direction){
                        case "left":
                            castles_guest_user.get(0).decrease_hitpoint(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i));
                            break;
                        case "middle":
                            castles_guest_user.get(1).decrease_hitpoint(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i));
                            break;
                        case "right":
                            castles_guest_user.get(2).decrease_hitpoint(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i));
                            break;
                    }

                }
            }
        }
        else {
            for(int i = 0 ; i<user_who_play.get_battle_deck().getCards_in_battle_deck().size();i++){
                if(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i).getName().equals("Fireball")){
                    switch (line_direction){
                        case "left":
                            castles_current_user.get(0).decrease_hitpoint(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i));
                            break;
                        case "middle":
                            castles_current_user.get(1).decrease_hitpoint(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i));
                            break;
                        case "right":
                            castles_current_user.get(2).decrease_hitpoint(user_who_play.get_battle_deck().getCards_in_battle_deck().get(i));
                            break;

                    }
                }
            }
        }
        user_who_play.setNumber_of_cards_to_play(0);
        return 0;
    }
    boolean is_finish = false ;
    public boolean is_finished(){
        return is_finish ;
    }
    public void next_turn(){
        if (user_who_play.equals(currentuser)){
            change_who_play();
            System.out.println("Player "+user_who_play.getName()+" is now playing!");
        }
        else {
                turn-=1;
                ArrayList<Card>card_of_currentuser_left = new ArrayList<>();
                ArrayList<Card>card_of_currentuser_middle = new ArrayList<>();
                ArrayList<Card>card_of_currentuser_right = new ArrayList<>();
                ArrayList<Card>card_of_guestuser_left = new ArrayList<>();
                ArrayList<Card>card_of_guestuser_middle = new ArrayList<>();
                ArrayList<Card>card_of_guestuser_right = new ArrayList<>();
                for(int k = 0 ; k<15 ; k++){
                    for(int z = 0 ; z<left_ground[k].size();z++){
                        if(left_ground[k].get(z).getPlayer().equals(currentuser.getName())){
                            card_of_currentuser_left.add(left_ground[k].get(z));
                        }
                        else {
                            card_of_guestuser_left.add(left_ground[k].get(z));
                        }
                    }
                    for(int z = 0 ; z<middle_ground[k].size();z++){
                        if(middle_ground[k].get(z).getPlayer().equals(currentuser.getName())){
                            card_of_currentuser_middle.add(middle_ground[k].get(z));
                        }
                        else {
                            card_of_guestuser_middle.add(middle_ground[k].get(z));
                        }
                    }
                    for(int z = 0 ; z<right_ground[k].size();z++){
                        if(right_ground[k].get(z).getPlayer().equals(currentuser.getName())){
                            card_of_currentuser_right.add(right_ground[k].get(z));
                        }
                        else {
                            card_of_guestuser_right.add(right_ground[k].get(z));
                        }
                    }

                }
                if(castles_current_user.get(0).getDefense_hitpoint()>=0){
                    if(card_of_guestuser_left.size()>0){
                        int decrese = castles_current_user.get(0).getAttack_hitpoint()/card_of_guestuser_left.size();
                        for(int i = 0 ; i<card_of_guestuser_left.size(); i++){
                            card_of_guestuser_left.get(i).decrease_hitpoint(decrese);
                        }
                    }
                }
                if(castles_current_user.get(1).getDefense_hitpoint()>=0){
                    if(card_of_guestuser_middle.size()>0){
                        int decrese = castles_current_user.get(1).getAttack_hitpoint()/card_of_guestuser_middle.size();
                        for(int i = 0 ; i<card_of_guestuser_middle.size(); i++){
                            card_of_guestuser_middle.get(i).decrease_hitpoint(decrese);
                        }
                    }
            }
                if(castles_current_user.get(2).getDefense_hitpoint()>=0){
                    if(card_of_guestuser_right.size()>0){
                        int decrese = castles_current_user.get(2).getAttack_hitpoint()/card_of_guestuser_right.size();
                        for(int i = 0 ; i<card_of_guestuser_right.size(); i++){
                            card_of_guestuser_right.get(i).decrease_hitpoint(decrese);
                        }
                    }
            }
                if(castles_guest_user.get(0).getDefense_hitpoint()>=0){
                    if(card_of_currentuser_left.size()>0){
                        int decrese = castles_guest_user.get(0).getAttack_hitpoint()/card_of_currentuser_left.size();
                        for(int i = 0 ; i<card_of_currentuser_left.size(); i++){
                            card_of_currentuser_left.get(i).decrease_hitpoint(decrese);
                        }
                    }
            }
                if(castles_guest_user.get(1).getDefense_hitpoint()>=0){
                    if(card_of_currentuser_middle.size()>0){
                        int decrese = castles_guest_user.get(1).getAttack_hitpoint()/card_of_currentuser_middle.size();
                        for(int i = 0 ; i<card_of_currentuser_middle.size(); i++){
                            card_of_currentuser_middle.get(i).decrease_hitpoint(decrese);
                        }
                    }
            }
                if(castles_guest_user.get(2).getDefense_hitpoint()>=0){
                    if(card_of_currentuser_right.size()>0){
                        int decrese = castles_guest_user.get(2).getAttack_hitpoint()/card_of_currentuser_right.size();
                        for(int i = 0 ; i<card_of_currentuser_right.size(); i++){
                            card_of_currentuser_right.get(i).decrease_hitpoint(decrese);
                        }
                    }
            }
            for(int i = 0 ; i<15 ; i++){
                    boolean card_of_current_user_at_first= false ;
                    boolean card_of_guestuser_user_at_end= false ;
                    ArrayList<Card>card_of_current_user = new ArrayList<>();
                    ArrayList<Card>card_of_guest_user = new ArrayList<>();
                    for(int z = 0 ; z<left_ground[0].size();z++){
                        if(left_ground[0].get(z).getPlayer().equals(currentuser.getName())){
                            card_of_current_user_at_first = true ;
                        }
                    }
                    for(int z = 0 ; z<left_ground[14].size();z++){
                        if(left_ground[14].get(z).getPlayer().equals(guest_user.getName())){
                            card_of_guestuser_user_at_end = true;
                        }
                    }
                    int sum_current_user=0 ,sum_guest_user=0;
                    for(int j = 0 ; j<left_ground[i].size();j++){
                        if(left_ground[i].get(j).getPlayer().equals(currentuser.getName())){
                            card_of_current_user.add(left_ground[i].get(j));
                            sum_current_user+=left_ground[i].get(j).getAttack_hitpoint();
                        }
                        if(left_ground[i].get(j).getPlayer().equals(guest_user.getName())){
                            card_of_guest_user.add(left_ground[i].get(j));
                            sum_guest_user+=left_ground[i].get(j).getAttack_hitpoint();
                        }
                    }
                    if((card_of_guestuser_user_at_end==false)&&(card_of_current_user.size()!=0)&&i==14){
                        castles_guest_user.get(0).decrease_hitpoint(sum_current_user);
                    }
                    if((card_of_guest_user.size()!=0)&&(card_of_current_user_at_first==false)&&i==0){
                        castles_current_user.get(0).decrease_hitpoint(sum_guest_user);
                    }
                if((card_of_guest_user.size()!=0)&&(card_of_current_user.size()!=0)){
                    if(sum_current_user>sum_guest_user){
                        card_of_guest_user.get(i).decrease_hitpoint(sum_current_user-sum_guest_user);
                    }
                    if(sum_guest_user>sum_current_user){
                        card_of_current_user.get(i).decrease_hitpoint(sum_guest_user-sum_current_user);
                    }
                }

                }
            for(int i = 0 ; i<15 ; i++){
                ArrayList<Card>card_of_current_user_at_first= new ArrayList<>();
                ArrayList<Card>card_of_guestuser_user_at_end= new ArrayList<>();
                ArrayList<Card>card_of_current_user = new ArrayList<>();
                ArrayList<Card>card_of_guest_user = new ArrayList<>();
                for(int z = 0 ; z<middle_ground[0].size();z++){
                    if(middle_ground[0].get(z).getPlayer().equals(currentuser.getName())){
                        card_of_current_user_at_first.add(middle_ground[0].get(z));
                    }
                }
                for(int z = 0 ; z<middle_ground[14].size();z++){
                    if(middle_ground[14].get(z).getPlayer().equals(guest_user.getName())){
                        card_of_guestuser_user_at_end.add(middle_ground[14].get(z));
                    }
                }
                int sum_current_user=0 ,sum_guest_user=0;
                for(int j = 0 ; j<middle_ground[i].size();j++){
                    if(middle_ground[i].get(j).getPlayer().equals(currentuser.getName())){
                        card_of_current_user.add(middle_ground[i].get(j));
                        sum_current_user+=middle_ground[i].get(j).getAttack_hitpoint();
                    }
                    if(middle_ground[i].get(j).getPlayer().equals(guest_user.getName())){
                        card_of_guest_user.add(middle_ground[i].get(j));
                        sum_guest_user+=middle_ground[i].get(j).getAttack_hitpoint();
                    }
                }
                if((card_of_guestuser_user_at_end.size()==0)&&(card_of_current_user.size()!=0)&&i==14){
                    castles_guest_user.get(1).decrease_hitpoint(sum_current_user);
                }
                if((card_of_guest_user.size()!=0)&&(card_of_current_user_at_first.size()==0)&&i==0){
                    castles_current_user.get(1).decrease_hitpoint(sum_guest_user);
                }
                if((card_of_guest_user.size()!=0)&&(card_of_current_user.size()!=0)){
                    if(sum_current_user>sum_guest_user){
                        card_of_guest_user.get(i).decrease_hitpoint(sum_current_user-sum_guest_user);
                    }
                    if(sum_guest_user>sum_current_user){
                        card_of_current_user.get(i).decrease_hitpoint(sum_guest_user-sum_current_user);
                    }
                }

            }
            for(int i = 0 ; i<15 ; i++){
                boolean card_of_current_user_at_first= false;
                boolean card_of_guestuser_user_at_end= false;
                ArrayList<Card>card_of_current_user = new ArrayList<>();
                ArrayList<Card>card_of_guest_user = new ArrayList<>();
                for(int z = 0 ; z<right_ground[0].size();z++){
                    if(right_ground[0].get(z).getPlayer().equals(currentuser.getName())){
                        card_of_current_user_at_first=true;
                    }
                }
                for(int z = 0 ; z<right_ground[14].size();z++){
                    if(right_ground[14].get(z).getPlayer().equals(guest_user.getName())){
                        card_of_guestuser_user_at_end=true;
                    }
                }
                int sum_current_user=0 ,sum_guest_user=0;
                for(int j = 0 ; j<right_ground[i].size();j++){
                    if(right_ground[i].get(j).getPlayer().equals(currentuser.getName())){
                        card_of_current_user.add(right_ground[i].get(j));
                        sum_current_user+=right_ground[i].get(j).getAttack_hitpoint();
                    }
                    if(right_ground[i].get(j).getPlayer().equals(guest_user.getName())){
                        card_of_guest_user.add(right_ground[i].get(j));
                        sum_guest_user+=right_ground[i].get(j).getAttack_hitpoint();

                    }
                }
                if((card_of_guestuser_user_at_end==false)&&(card_of_current_user.size()!=0)&&i==14){
                    castles_guest_user.get(2).decrease_hitpoint(sum_current_user);
                }
                if((card_of_guest_user.size()!=0)&&(card_of_current_user_at_first==false)&&i==0){
                    castles_current_user.get(2).decrease_hitpoint(sum_guest_user);
                }
                if((card_of_guest_user.size()!=0)&&(card_of_current_user.size()!=0)){
                    if(sum_current_user>sum_guest_user){
                        card_of_guest_user.get(i).decrease_hitpoint(sum_current_user-sum_guest_user);
                    }
                    if(sum_guest_user>sum_current_user){
                        card_of_current_user.get(i).decrease_hitpoint(sum_guest_user-sum_current_user);
                    }
                }

            }
            for(int k = 0 ; k<15 ; k++){
                for(int z = 0 ; z<left_ground[k].size();z++){
                    if(left_ground[k].get(z).getDefense_hitpoint()<=0){
                        left_ground[k].remove(z);
                    }
                }
                for(int z = 0 ; z<middle_ground[k].size();z++){
                    if(middle_ground[k].get(z).getDefense_hitpoint()<=0){
                        middle_ground[k].remove(z);
                    }
                }
                for(int z = 0 ; z<right_ground[k].size();z++){
                    if(right_ground[k].get(z).getDefense_hitpoint()<=0){
                        right_ground[k].remove(z);
                    }
                }

            }// حذف کارت های سوخته
            if(castles_current_user.get(0).getDefense_hitpoint()==-1 && castles_current_user.get(1).getDefense_hitpoint()==-1 && castles_current_user.get(2).getDefense_hitpoint()==-1){
                int exp=0;
                for (int j = 0 ; j<3 ; j++){
                    if(castles_guest_user.get(j).getDefense_hitpoint()!=-1){
                        exp+=castles_guest_user.get(j).getDefense_hitpoint();
                    }
                }
                guest_user.add_experience(exp);
                guest_user.level_check_up();
                is_finish=true ;
            }
            if(castles_guest_user.get(0).getDefense_hitpoint()==-1 && castles_guest_user.get(1).getDefense_hitpoint()==-1 && castles_guest_user.get(2).getDefense_hitpoint()==-1){
                int exp=0;
                for (int j = 0 ; j<3 ; j++){
                    if(castles_current_user.get(j).getDefense_hitpoint()!=-1)
                    exp+=castles_current_user.get(j).getDefense_hitpoint();
                }
                currentuser.add_experience(exp);
                currentuser.level_check_up();
                is_finish=true ;
            }

            if(turn==0){
                int exp=0;
                for (int j = 0 ; j<3 ; j++){
                    if(castles_guest_user.get(j).getDefense_hitpoint()!=-1){
                        exp+=castles_guest_user.get(j).getDefense_hitpoint();
                    }
                }
                guest_user.add_experience(exp);
                guest_user.level_check_up();
                exp = 0 ;
                for (int j = 0 ; j<3 ; j++){
                    if(castles_current_user.get(j).getDefense_hitpoint()!=-1){
                        exp+=castles_current_user.get(j).getDefense_hitpoint();
                    }
                }
                currentuser.add_experience(exp);
                currentuser.level_check_up();

                is_finish = true;
//کدهای مربوط به experience
            }
            if(is_finish==false){
                change_who_play();
                System.out.println("Player "+user_who_play.getName()+" is now playing!");
            }
            if(is_finish==true){
                int exp_1 = 0 ;
                int exp_2 = 0 ;
                for(int i =0 ; i<3 ; i++){
                    if(castles_current_user.get(i).getDefense_hitpoint()>0){
                        exp_1+=castles_current_user.get(i).getDefense_hitpoint();
                    }
                    if(castles_guest_user.get(i).getDefense_hitpoint()>0){
                        exp_2+=castles_guest_user.get(i).getDefense_hitpoint();
                    }
                }
                if(exp_2>exp_1){
                    System.out.println("Game has ended. Winner: "+guest_user.getName());
                }
                if(exp_2==exp_1){
                    System.out.println("Game has ended. Result: Tie");
                }
                if(exp_1>exp_2){
                    System.out.println("Game has ended. Winner: "+currentuser.getName());
                }
                int cas_1 = 0 ;
                int cas_2 = 0 ;
                for(int i = 0 ; i<3 ; i++){
                    if(castles_guest_user.get(i).getDefense_hitpoint()==-1){
                        cas_1+=1;
                    }
                    if(castles_guest_user.get(i).getDefense_hitpoint()==-1){
                        cas_2+=1;
                    }
                }
                guest_user.add_gold(cas_1*20);
                currentuser.add_gold(cas_2*20);
            }
        }
        currentuser.setNumber_of_moves_left(3);
        guest_user.setNumber_of_moves_left(3);
        currentuser.setNumber_of_cards_to_play(1);
        guest_user.setNumber_of_cards_to_play(1);
    }
}
