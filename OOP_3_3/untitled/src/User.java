import card.*;

import java.util.ArrayList;

public class User {
    public User(String name ,String password){
        this.name =name ;
        this.password = password ;
        gold = 80 ;
        level = 1 ;
        experience = 0 ;
        Fireball fireball = new Fireball();
        Archer archer = new Archer() ;
        cards.add(fireball);
        cards.add(archer);
        battleDeck.add_card(fireball);
        battleDeck.add_card(archer);
    }
    private String name , password ;
    private int number_of_cards_to_play,number_of_moves_left;
    private Battle_deck battleDeck = new Battle_deck();
    private ArrayList<Card>cards = new ArrayList<>();
    private ArrayList<Castle>castles = new ArrayList<>();
    private int gold , level,experience ;
    public void setName(String name){
        this.name=name ;
    }
    public void setPassword(String password){
        this.password= password ;
    }
    public String getName(){
        return name ;
    }
    public String getPassword(){
        return password ;
    }
    public int getGold(){
        return gold ;
    }
    public int getLevel(){
        return level;
    }
    public int getExperience() {
        return experience;
    }
    public Battle_deck get_battle_deck(){
        return battleDeck;
    }
    public void add_card_to_user(String name){
        switch (name){
            case "Fireball":
                cards.add(new Fireball());
            case "Archer":
                cards.add(new Archer());
                break;
            case "Dragon":
                cards.add(new Dragon());
                break;
            case "Wizard":
                cards.add(new Wizard());
                break;

        }
    }
    public void remove_card_from_user(String name){
        for(int i = 0 ; i<cards.size();i++){
            if(cards.get(i).getName().equals(name)){
                cards.remove(cards.get(i));
            }
        }
    }
    public ArrayList<Card>getCards(){
        return cards ;
    }
    public void increase_decrease_gold(int number){
        gold+=number;
    }
    public int get_castle_hitpoint(int number){
        return castles.get(number).getDefense_hitpoint();
    }

    public int getNumber_of_moves_left() {
        return number_of_moves_left;
    }

    public int getNumber_of_cards_to_play() {
        return number_of_cards_to_play;
    }

    public void setNumber_of_cards_to_play(int number_of_cards_to_play) {
        this.number_of_cards_to_play = number_of_cards_to_play;
    }

    public void setNumber_of_moves_left(int number_of_moves_left) {
        this.number_of_moves_left = number_of_moves_left;
    }
    public void add_experience(int exp){
        experience+=exp;
    }
    public void level_check_up(){
        while(experience>=(level*level*150)){
            experience-=(level*level*150);
            level+=1;
        }
    }
    public void add_gold(int num){
        gold+=num;
    }
}
