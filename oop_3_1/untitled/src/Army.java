import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Army extends Regiment {
    public  String getNumber() {
        return number;
    }

    private String leader ,place ;
    public ArrayList<Corp>corps = new ArrayList<>();
    public Army(String leader , String number){
        this.leader=leader;
        this.number=number ;
    }
    public Army(String leader , String number,String place){
        this.leader=leader;
        this.number=number ;
        this.place = place ;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLeader() {
        return leader;
    }
    public void setPlace(String place){
        this.place=place;
    }

    public void add_corp_in_army(Corp corp){
        corps.add(corp);
    }
    public Corp find_corp_in_army(String number){
        for(Corp corp : corps){
            if(corp.getNumber().equals(number)){
                return corp ;
            }
        }
        return null ;
    }
    public int number_of_corp(){
        return corps.size();
    }
    public void sort_corp_and_print(){
        Comparator<Corp>comparator = Comparator.comparing(Corp::getNumber_in_int);
        Collections.sort(corps,comparator);
        for(Corp corp:corps){
            corp.print_corp();
        }
    }
    public int sum_score_army(){
        int num =0 ;
        for(Corp corp:corps){
            num+=corp.get_score_in_corp(place);
        }
        return num ;
    }
    public String getPlace(){
        return place ;
    }
}
