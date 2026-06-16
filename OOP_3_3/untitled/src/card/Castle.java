package card;

public class Castle {
    int attack_hitpoint , defense_hitpoint ;
    public Castle(int user_level , int position){
        this.attack_hitpoint=450*user_level;
        switch (position){
            case 0:
                defense_hitpoint=2200*user_level;
                break;
            case 1:
                defense_hitpoint=3400*user_level;
                break;
            case 2:
                defense_hitpoint=2200*user_level;
                break;
        }
    }

    public int getDefense_hitpoint() {
        return defense_hitpoint;
    }
    public void decrease_hitpoint(Card card){
        if(defense_hitpoint>=card.attack_hitpoint){
            defense_hitpoint-= card.attack_hitpoint;
        }
        else {
            defense_hitpoint = -1 ;
        }
    }
    public void decrease_hitpoint(int num){
        if(defense_hitpoint>=num){
            defense_hitpoint-= num;
        }
        else {
            defense_hitpoint = -1 ;
        }
    }

    public int getAttack_hitpoint() {
        return attack_hitpoint;
    }
}
