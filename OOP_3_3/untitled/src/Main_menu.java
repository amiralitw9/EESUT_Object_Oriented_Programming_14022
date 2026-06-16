import card.Card;
import card.Dragon;
import card.Fireball;
import java.util.ArrayList;

public class Main_menu {
    ArrayList<User>users ;
    User current_user = null;
    public Main_menu(ArrayList<User>users , User current_user){
        this.current_user = current_user;
        this.users=users;
    }
    public int remove_from_battle_deck(String name){
        switch (name){
            case "Fireball":
                break;
            case "Archer":
                break;
            case "Dragon":
                break;
            case "Wizard":
                break;
            default:
                return 1 ;
        }
        for(Card card:current_user.get_battle_deck().getCards_in_battle_deck()){
            if(card.getName().equals(name)){
                if(current_user.get_battle_deck().getCards_in_battle_deck().size()==1){
                    return 3;
                }
                current_user.get_battle_deck().remove_card(card);
                return 0;
            }
        }
        return 2;

    }
    public int add_to_battle_deck(String name){
        switch (name){
            case "Fireball":
                break;
            case "Archer":
                break;
            case "Dragon":
                break;
            case "Wizard":
                break;
            default:
                return 1 ;
        }

        for(Card card:current_user.getCards()){
            if(card.getName().equals(name)){
                for(Card card1:current_user.get_battle_deck().getCards_in_battle_deck()){
                    if(card1.getName().equals(name)){
                        return 3;
                    }
                }
                if(current_user.get_battle_deck().getCards_in_battle_deck().size()==3){
                    return 4 ;
                }
                current_user.get_battle_deck().add_card(card);
                return 0;
            }
        }
        return 2 ;

    }

}
