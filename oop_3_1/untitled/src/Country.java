import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Country {
    private String Name , Nationality ;
    private ArrayList<Corp> corps = new ArrayList<>();
    private ArrayList<Army> armies = new ArrayList<>();
    public ArrayList<Country>union = new ArrayList<>();
    public ArrayList<Country> enemy = new ArrayList<>();
        public Country(String name , String nationality){
            this.Name=name;
            this.Nationality=nationality;
        }

    public void setName(String name){
        this.Name = name ;
    }
    public void setNationality(String nationality){
        this.Nationality=nationality;
    }
    public void setCountry_corp(Corp corp){
            corps.add(corp);
    }
    public String getName(){
        return Character.toUpperCase(Name.charAt(0)) + Name.substring(1);
    }
    public String getNationality(){
        return this.Nationality;
    }
    public int check_officer_corp(String officer){
        switch (officer){
            case "corporal":
                return 1;
            case "sergent":
                return 4;
            case "lieutenant":
                return 7;
            case "capitan":
                return 12;
            case "colonel":
                return 18;
            case "general":
                return 22;

            case "marshal":
                return 25;
        }
        return 0 ;
    }
    public int check_officer_army(String officer){
        try {
            Integer.parseInt(officer);
            return Integer.parseInt(officer);
        } catch (NumberFormatException e) {
            System.out.println("army was not found!");
            return 0;
        }
    }
    public void add_corp(int infantry , int cavalry , int artillery , String ranked_officer , String number){
        boolean is_true = false ;
        for(int i =0 ; i<corps.size();i++){
            if(corps.get(i).getNumber().equals(number)){
                System.out.println("this country already has this corps!");
                is_true = true ;
            }
        }
        if(is_true==false){
            if(check_officer_corp(ranked_officer)==0){
                System.out.println("invalid input!");
                is_true= true ;
            }
        }
        if(is_true==false){
            Corp corp = new Corp(infantry,cavalry,artillery,check_officer_corp(ranked_officer),number);
            corps.add(corp);
            System.out.println("corps "+number+" created successfully!");
        }

    }
    public void add_army(String number , String leader , String place ){
        boolean is_true = false ;
        for(int i =0 ; i<armies.size();i++){
            if(armies.get(i).getNumber().equals(number)){
                System.out.println("this country already has this army!");
                is_true = true ;
            }
        }
        if(is_true==false){
            if(check_officer_army(number)==0){
                is_true= true ;
            }
        }
        if(is_true==false){
            if(place.equals("")){
                Army army = new Army(leader,number);
                armies.add(army);
            }
            else{
                Army army = new Army(leader,number,place);
                armies.add(army);
            }
            System.out.println("army created successfully!");
        }

    }
    public void set_place_for_army(String number,String place){
            boolean is_true = false ;
            for(Army army:armies){
                if(army.getNumber().equals(number)){
                    army.setPlace(place);
                    System.out.println("set successfully!");
                    is_true = true ;
                }
            }
            if(is_true==false){
                System.out.println("army was not found!");
            }
    }
    public Army find_army_in_country(String number){
            for(Army army:armies){
                if(army.getNumber().equals(number)){
                    return army;
                }
            }
            return null;
    }
    public Corp find_corp_in_country(String number){
            for(Corp corp:corps){
                if(corp.getNumber().equals(number)){
                    return corp;
                }
            }
            return null;
    }
    public void add_corp_to_army(Corp corp_1 , Army army_1){
            for(Army army :armies){
                if(army.getNumber().equals(army_1.getNumber())){
                    Corp corp = army.find_corp_in_army(corp_1.getNumber());
                    if(corp==(null)){
                        army.add_corp_in_army(corp_1);
                        System.out.println("corps added to army successfully!");
                    }
                    else{
                        System.out.println("this corps is in an army!");
                    }
                }
            }
    }
    public void print_country(){
        System.out.print(getNationality()+" "+armies.size()+" ");
        int[]array = new int[armies.size()];
        for(int i = 0 ; i<armies.size() ; i++){
            array[i]=armies.get(i).number_of_corp();
        }
        Arrays.sort(array);
        for(int i = 0 ; i<armies.size();i++){
            System.out.print(array[i]);
        }
        System.out.print("\n");
    }
    public void print_country_with_detail(){
        System.out.print(getNationality()+" "+armies.size()+" ");
        Comparator<Army>comparator = Comparator.comparing(Army::getNumber);
        Collections.sort(armies,comparator);
        for(int i = 0 ; i<armies.size();i++){
            System.out.print(armies.get(i).number_of_corp()+" ");
        }
        System.out.println();
        for(int i = 0 ; i<armies.size() ;i++){
            System.out.print(armies.get(i).getLeader()+" ");
        }
        System.out.println();
    }
    public int sum_score(){
            int score = 0 ;
            for(Army army :armies){
                score+=army.sum_score_army();
            }
            return score ;
    }
    public boolean is_enemy(Country country){
            for(Country i: enemy){
                if(country.getName().equalsIgnoreCase(i.getName())){
                    return true;
                }
            }
            return false ;
    }
    public boolean is_union(Country country){
            for(Country i: union){
                if(country.getName().equalsIgnoreCase(i.getName())){
                    return true ;
                }
            }
            return false;
    }
    public void add_union(Country country){
            union.add(country);
    }
    public void add_enemy(Country country){
            enemy.add(country);
    }
    public void print_friends(){
            Comparator<Country>comparator = Comparator.comparing(Country::sum_score);
            Collections.sort(union,comparator);
            for(Country i : union){
                System.out.println(i.getName());
            }
    }
    public void print_enemies(){
        Comparator<Country>comparator = Comparator.comparing(Country::sum_score);
        Collections.sort(enemy,comparator);
        for(Country i : enemy){
            System.out.println(i.getName());
        }
    }
    public void lose_in_war(){
            for(Army army:armies){
                for (Corp corp :army.corps){
                    corp.half_infantry_and_cavalry();
                }
            }
    }
    public int sum_score_in_place(String place){
            int sum = 0 ;
            for(Army army :armies){
                if(army.getPlace().equals(place)){
                    sum+=army.sum_score_army();
                }
            }
            return sum ;
    }

}
