import card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Battle_deck {
    private ArrayList<Card> cards = new ArrayList<>();
    public void add_card(Card card){
        if(cards.size()<3){
            cards.add(card);
        }
    }
    public void remove_card(Card card){
        for(int i = 0 ;i<cards.size();i++){
            if(cards.get(i).getName().equals(card.getName())){
                cards.remove(i);
            }
        }
    }
    public void print_battle_deck(){
        Comparator<Card> comparator = Comparator.comparing(Card::getName);
        Collections.sort(cards,comparator);
        for(Card card: cards){
            System.out.println(card.getName());
        }
    }
    public ArrayList<Card>getCards_in_battle_deck(){
        return cards;
    }
}
