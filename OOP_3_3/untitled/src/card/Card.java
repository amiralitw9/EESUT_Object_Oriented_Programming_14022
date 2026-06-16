package card;

public  class Card {
    public Card(){}
    protected int attack_hitpoint, defense_hitpoint, price;
    protected String name,player ;
    public String getName(){
        return name ;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getAttack_hitpoint() {
        return attack_hitpoint;
    }

    public int getDefense_hitpoint() {
        return defense_hitpoint;
    }
    public void decrease_hitpoint(int num){
        defense_hitpoint-=num;
    }


    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
    public Card (Card card){
        this.price=card.price;
        this.defense_hitpoint = card.defense_hitpoint;
        this.attack_hitpoint = card.attack_hitpoint;
        this.name= card.name;
        this.player = card.player;
    }
}
