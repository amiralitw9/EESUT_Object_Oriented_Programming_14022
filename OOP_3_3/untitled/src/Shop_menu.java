import card.Archer;

public class Shop_menu {
    User currentuser ;
    public Shop_menu(User user){
        currentuser = user ;
    }
    public int buy_card(String name){
        switch (name){
            case"Fireball":
                if(currentuser.getGold()<80){
                    return 2;
                }
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        return 3;
                    }
                }
                currentuser.add_card_to_user(name);
                currentuser.increase_decrease_gold(-80);
                return 0;
            case"Archer":
                if(currentuser.getGold()<80){
                    return 2;
                }
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        return 3;
                    }
                }
                currentuser.add_card_to_user(name);
                currentuser.increase_decrease_gold(-80);
                return 0;
            case"Dragon":
                if(currentuser.getGold()<160){
                    return 2;
                }
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        return 3;
                    }
                }
                currentuser.add_card_to_user(name);
                currentuser.increase_decrease_gold(-160);
                return 0;
            case"Wizard":
                if(currentuser.getGold()<140){
                    return 2;
                }
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        return 3;
                    }
                }
                currentuser.add_card_to_user(name);
                currentuser.increase_decrease_gold(-140);
                return 0;
            default:
                return 1 ;

        }
    }
    public int sell_card(String name){
        switch (name){
            case"Fireball":
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        for(int j = 0 ; j<currentuser.get_battle_deck().getCards_in_battle_deck().size();j++){
                            if(currentuser.get_battle_deck().getCards_in_battle_deck().get(j).getName().equals(name)){
                                return 3;
                            }
                        }
                        currentuser.increase_decrease_gold(currentuser.getCards().get(i).getPrice()*3/4);
                        currentuser.remove_card_from_user(name);
                        return 0;

                    }
                }
                return 2 ;
            case"Archer":
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        for(int j = 0 ; j<currentuser.get_battle_deck().getCards_in_battle_deck().size();j++){
                            if(currentuser.get_battle_deck().getCards_in_battle_deck().get(j).getName().equals(name)){
                                return 3;
                            }
                        }
                        currentuser.increase_decrease_gold(currentuser.getCards().get(i).getPrice()*3/4);
                        currentuser.remove_card_from_user(name);
                        return 0;

                    }
                }
                return 2 ;
            case"Dragon":
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        for(int j = 0 ; j<currentuser.get_battle_deck().getCards_in_battle_deck().size();j++){
                            if(currentuser.get_battle_deck().getCards_in_battle_deck().get(j).getName().equals(name)){
                                return 3;
                            }
                        }
                        currentuser.increase_decrease_gold(currentuser.getCards().get(i).getPrice()*3/4);
                        currentuser.remove_card_from_user(name);
                        return 0;

                    }
                }
                return 2 ;
            case"Wizard":
                for(int i = 0 ; i<currentuser.getCards().size();i++){
                    if(currentuser.getCards().get(i).getName().equals(name)){
                        for(int j = 0 ; j<currentuser.get_battle_deck().getCards_in_battle_deck().size();j++){
                            if(currentuser.get_battle_deck().getCards_in_battle_deck().get(j).getName().equals(name)){
                                return 3;
                            }
                        }
                        currentuser.increase_decrease_gold(currentuser.getCards().get(i).getPrice()*3/4);
                        currentuser.remove_card_from_user(name);
                        return 0;

                    }
                }
                return 2 ;
            default:
                return 1 ;

        }

    }
}
