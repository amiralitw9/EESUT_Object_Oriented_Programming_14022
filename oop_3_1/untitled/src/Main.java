import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String vorodi="" ;
        while(true){
            vorodi=scanner.nextLine();
            if(vorodi.equals("end"))
                break;
            String ghesmat[]=vorodi.split("\\s+");
            int tasmimgir = 0 ;
            if(ghesmat[0].equals("create")){
                if (ghesmat[1].toLowerCase().equals("country")) {
                    Country country = new Country(ghesmat[2], ghesmat[3]);
                    country.creat_country(ghesmat[2],ghesmat[3]);
                    tasmimgir = 1;
                }
                else if (ghesmat[1].toLowerCase().equals("corps")) {
                    int infantry_0 = Integer.parseInt(ghesmat[2]) * 1000;
                    int cavalry_0 = Integer.parseInt(ghesmat[3]) * 400;
                    int artillery_0 = Integer.parseInt(ghesmat[4]) * 10;
                    boolean x = false;
                    if ((infantry_0 + cavalry_0 + artillery_0) > 30000) {
                        System.out.println("cannot have more than 30k in a corps!");
                        x = true;
                    }
                    if (!x) {
                        int yo = 0;
                        while (yo < Country.countries.size()) {
                            if (Country.countries.get(yo).Name.toLowerCase().equals(ghesmat[7].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (yo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                x = true;
                            }
                            yo++;
                        }
                    }
                    if (!x) {
                        for (int i=0 ; i<Country.countries.size() ; i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[7].toLowerCase())) {
                                boolean is_true = false ;
                                for(int j =0 ; j<Country.countries.get(i).corps.size();j++){
                                    if(Country.countries.get(i).corps.get(j).number.equals(ghesmat[8])){
                                        System.out.println("this country already has this corps!");
                                        is_true = true ;
                                    }
                                }
                                if(is_true==false){
                                    if(MilitryRank.get(ghesmat[5]).score==0){
                                        System.out.println("invalid input!");
                                        is_true= true ;
                                    }
                                }
                                if(is_true==false){
                                    Corp corp = new Corp(infantry_0,cavalry_0,artillery_0,ghesmat[5],ghesmat[8]);
                                    Country.countries.get(i).corps.add(corp);
                                    System.out.println("corps "+ghesmat[8]+" created successfully!");
                                }

                            }
                        }
                    }

                    tasmimgir = 1;
                }
                else if (ghesmat[1].toLowerCase().equals("army")) {
                    boolean x = false;
                    int ro = 0;
                    while (ro < Country.countries.size()) {
                        if (Country.countries.get(ro).Name.toLowerCase().equals(ghesmat[5].toLowerCase())) {
                            tasmimgir = 1;
                            break;
                        }
                        if (ro == Country.countries.size() - 1) {
                            System.out.print("country was not found!"+"\n");
                            x = true;
                        }
                        ro++;
                    }
                    if (!x) {
                        for (int i=0 ; i<Country.countries.size() ; i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[5].toLowerCase())) {
                                if (ghesmat.length == 8) {
                                    boolean is_true = false ;
                                    for(int j =0 ; j<Country.countries.get(i).n_army.size();j++){
                                        if(Country.countries.get(i).n_army.get(j).getNumber().equals(ghesmat[2])){
                                            System.out.print("this country already has this army!" + "\n");
                                            is_true = true ;
                                        }
                                    }
                                    if(is_true==false){
                                        if(Country.countries.get(i).check_officer_army(ghesmat[2])==0){
                                            is_true= true ;
                                        }
                                    }
                                    if(is_true==false){
                                        if(ghesmat[7].equals("")){
                                            Army army = new Army(ghesmat[3],ghesmat[2]);
                                            Country.countries.get(i).n_army.add(army);
                                        }
                                        else{
                                            Army army = new Army(ghesmat[3],ghesmat[2],ghesmat[7]);
                                            Country.countries.get(i).n_army.add(army);
                                        }
                                        System.out.print("army created successfully!" + "\n");
                                    }

                                } else if (ghesmat.length == 6) {
                                    boolean is_true = false ;
                                    for(int j =0 ; j<Country.countries.get(i).n_army.size();j++){
                                        if(Country.countries.get(i).n_army.get(j).getNumber().equals(ghesmat[2])){
                                            System.out.print("this country already has this army!" + "\n");
                                            is_true = true ;
                                        }
                                    }
                                    if(is_true==false){
                                        if(Country.countries.get(i).check_officer_army(ghesmat[2])==0){
                                            is_true= true ;
                                        }
                                    }
                                    if(is_true==false){
                                        if("".equals("")){
                                            Army army = new Army(ghesmat[3],ghesmat[2]);
                                            Country.countries.get(i).n_army.add(army);
                                        }
                                        else{
                                            Army army = new Army(ghesmat[3],ghesmat[2],"");
                                            Country.countries.get(i).n_army.add(army);
                                        }
                                        System.out.print("army created successfully!" + "\n");
                                    }
                                }
                            }
                        }
                    }
                    tasmimgir = 1;
                }

                tasmimgir = 1;}
            else if(ghesmat[0].equals( "set") ) {
                if (ghesmat[1].toLowerCase().equals("place")) {
                    boolean x = false;
                    int ro = 0;
                    while (ro < Country.countries.size()) {
                        if (Country.countries.get(ro).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                            tasmimgir = 1;
                            break;
                        }
                        if (ro == Country.countries.size() - 1) {
                            System.out.print("country was not found!" + "\n");
                            x = true;
                        }
                        ro++;
                    }
                    if (!x) {
                        for (int i=0 ; i<Country.countries.size() ; i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                boolean is_true = false ;
                                for(int k=0 ; k< Country.countries.get(i).n_army.size() ; k++){
                                    if(Country.countries.get(i).n_army.get(k).getNumber().equals(ghesmat[4])){
                                        Country.countries.get(i).n_army.get(k).setPlace(ghesmat[6]);
                                        System.out.println("set successfully!");
                                        is_true = true ;
                                    }
                                }
                                if(is_true==false){
                                    System.out.println("army was not found!");
                                }
                            }
                        }
                    }
                    tasmimgir = 1;
                }
                else if (ghesmat[0].toLowerCase().equals("add")) {
                    boolean x = false;
                    int ro = 0;
                    while (ro < Country.countries.size()) {
                        if (Country.countries.get(ro).Name.toLowerCase().equals(ghesmat[7].toLowerCase())) {
                            tasmimgir = 1;
                            break;
                        }
                        if (ro == Country.countries.size() - 1) {
                            System.out.println("country was not found!");
                            x = true;
                        }
                        ro++;
                    }
                    if (!x) {
                        for (int i=0 ; i<Country.countries.size() ; i++) {
                            Country.countries.get(i).set_add(ghesmat[2],ghesmat[5],ghesmat[7],x);
                        }
                    }
                    tasmimgir = 1;
                }
            }
            else if(ghesmat[0].equals( "add")){
                int xo = 0 ;
                int ro = 0;
                while (ro<Country.countries.size()) {
                    if(Country.countries.get(ro).Name.toLowerCase().equals(ghesmat[7].toLowerCase())){
                        tasmimgir =1 ;
                        break;
                    }
                    if(ro==Country.countries.size()-1){
                        System.out.println("country was not found!");
                        xo=1 ;
                    }
                    ro++;
                }
                if(xo==0){
                    for (int i=0 ; i<Country.countries.size() ; i++){
                        if(Country.countries.get(i).Name.toLowerCase().equals(ghesmat[7].toLowerCase())){
                            Army army = Country.countries.get(i).find_army_in_country(ghesmat[5]);
                            if(army==null){
                                System.out.println("army was not found!");
                                xo=1 ;
                            }
                            if(xo==0){
                                Corp corp = Country.countries.get(i).find_corp_in_country(ghesmat[2]);
                                if(corp==null){
                                    System.out.println("corps was not found!");
                                    xo=1 ;
                                }
                            }
                            if(xo==0){
                                Corp corp = Country.countries.get(i).find_corp_in_country(ghesmat[2]);
                                Country.countries.get(i).add_corp_to_army(corp,army);
                            }
                        }
                    }
                }
                tasmimgir =1 ;}
            else if (ghesmat[0].toLowerCase().equals("print")) {
                if (ghesmat[1].toLowerCase().equals("army")) {
                    if (ghesmat[2].toLowerCase().equals("with")) {
                        int yo = 0;
                        int uo = 0;
                        while (uo < Country.countries.size()) {
                            if (Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[5].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (uo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                yo = 1;
                            }
                            uo++;
                        }
                        if (yo == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[5].toLowerCase())) {
                                    Army army = Country.countries.get(i).find_army_in_country(ghesmat[4]);
                                    if (army == null) {
                                        System.out.println("army was not found!");
                                        yo = 1;
                                    }
                                    if (yo ==0 ) {
                                        System.out.println(army.leader + " " + army.corps.size());
                                        army.sort_corp_and_print();
                                    }
                                }
                            }
                        }
                        tasmimgir = 1;
                    } else {
                        int zo = 0;
                        int ho = 0;
                        while (ho < Country.countries.size()) {
                            if (Country.countries.get(ho).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (ho == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                zo = 1;
                            }
                            ho++;
                        }
                        if (zo == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                    Army army = Country.countries.get(i).find_army_in_country(ghesmat[2]);
                                    if (army == null) {
                                        System.out.println("army was not found!");
                                        zo = 1;
                                    }
                                    if (zo == 0) {
                                        System.out.println(army.leader + " " + army.corps.size());
                                    }
                                }
                            }
                        }
                        tasmimgir = 1;
                    }
                } else if (ghesmat[1].toLowerCase().equals("country")) {
                    if (ghesmat[2].toLowerCase().equals("with")) {
                        int ho = 0;
                        int uo = 0;
                        while (uo < Country.countries.size()) {
                            if (Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[4].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (uo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                ho = 1;
                            }
                            uo++;
                        }
                        if (ho == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[4].toLowerCase())) {
                                    Country.countries.get(i).print_country_with_detail();
                                }
                            }
                        }
                        tasmimgir = 1;
                    } else {
                        int ro = 0;
                        int plo = 0;
                        while (plo < Country.countries.size()) {
                            if (Country.countries.get(plo).Name.toLowerCase().equals(ghesmat[2].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (plo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                ro = 1;
                            }
                            plo++;
                        }
                        if (ro == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[2].toLowerCase())) {
                                    Country.countries.get(i).print_country();
                                }
                            }
                        }
                        tasmimgir = 1;
                    }
                } else if (ghesmat[1].toLowerCase().equals("score")) {
                    if (ghesmat.length == 6) {
                        int fo = 0;
                        int uo = 0;
                        while (uo < Country.countries.size()) {
                            if (Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (uo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                fo = 1;
                            }
                            uo++;
                        }
                        if (fo == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                    Army army = Country.countries.get(i).find_army_in_country(ghesmat[4]);
                                    if (army == null) {
                                        System.out.println("army was not found!");
                                        fo = 1;
                                    }
                                    if (fo == 0) {
                                        Corp corp = Country.countries.get(i).find_corp_in_country(ghesmat[5]);
                                        if (corp == null) {
                                            System.out.println("corps was not found!");
                                            fo = 1;
                                        }
                                        if (fo == 0) {
                                            Corp corpInArmy = army.find_corp_in_army(ghesmat[5]);
                                            if (corpInArmy == null) {
                                                System.out.println("this corps is not in this army!");
                                            } else {
                                                System.out.println(corpInArmy.getScoreInCorp(army.place));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (ghesmat.length == 5) {
                        int ko  = 0;
                        int uo = 0;
                        while (uo < Country.countries.size()) {
                            if (Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (uo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                ko = 1;
                            }
                            uo++;
                        }
                        if (ko == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                    Army army = Country.countries.get(i).find_army_in_country(ghesmat[4]);
                                    if (army == null) {
                                        System.out.println("army was not found!");
                                        ko = 1;
                                    }
                                    if (ko == 0) {
                                        System.out.println(army.sum_score_army());
                                    }
                                }
                            }
                        }
                    } else if (ghesmat.length == 4) {
                        int lt = 0;
                        int uo = 0;
                        while (uo < Country.countries.size()) {
                            if (Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (uo == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                lt = 1;
                            }
                            uo++;
                        }
                        if (lt == 0) {
                            for (int i=0 ; i<Country.countries.size() ; i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                    System.out.println(Country.countries.get(i).sum_score());
                                }
                            }
                        }
                    }
                    tasmimgir = 1;
                }
                tasmimgir = 1;
            }

            else if(ghesmat[0].equals( "show")) {
                if (ghesmat[1].equals("friends")) {
                    int vo = 0;
                    int uo = 0;
                    while (uo < Country.countries.size()) {
                        if (Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                            tasmimgir = 1;
                            break;
                        }
                        if (uo == Country.countries.size() - 1) {
                            System.out.println("country was not found!");
                            vo = 1;
                        }
                        uo++;
                    }
                    if (vo == 0) {
                        for (int i=0 ; i<Country.countries.size() ; i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                Country.countries.get(i).print_friends();
                            }
                        }
                    }

                    tasmimgir = 1;
                }
                if (ghesmat[1].equals("enemies")) {
                    int hj = 0;
                    int lko = 0;
                    while (lko < Country.countries.size()) {
                        if (Country.countries.get(lko).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                            tasmimgir = 1;
                            break;
                        }
                        if (lko == Country.countries.size() - 1) {
                            System.out.println("country was not found!");
                            hj = 1;
                        }
                        lko++;
                    }
                    if (hj == 0) {
                        for (int i=0 ; i<Country.countries.size() ; i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[3].toLowerCase())) {
                                Country.countries.get(i).print_enemies();
                            }
                        }
                    }
                    tasmimgir = 1;
                }}
            else if(ghesmat[0].equals( "war")) {if(ghesmat.length==5){
                int gk=0;
                for (int i = 0; i < Country.countries.size(); i++) {
                    if(Country.countries.get(i).Name.toLowerCase().equals(ghesmat[2].toLowerCase())){
                        tasmimgir =1 ;
                        break;
                    }
                    if(i==Country.countries.size()-1){
                        System.out.println("country was not found!");
                        gk=1 ;
                    }
                }
                if(gk==0){
                    int uo = 0;
                    while (uo<Country.countries.size()) {
                        if(Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[4].toLowerCase())){
                            tasmimgir =1 ;
                            break;
                        }
                        if(uo==Country.countries.size()-1){
                            System.out.println("country was not found!");
                            gk=1 ;
                        }
                        uo++;
                    }
                }
                if(gk==0){
                    Country country_1=null,country_2=null ;
                    int uo = 0;
                    while (uo<Country.countries.size()) {
                        if(Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[2].toLowerCase())){
                            country_1=Country.countries.get(uo);
                            tasmimgir =1 ;
                        }
                        if(Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[4].toLowerCase())){
                            country_2=Country.countries.get(uo);
                            tasmimgir =1 ;
                        }
                        uo++;

                    }
                    if(country_1.sum_score()>country_2.sum_score()){
                        Character.toUpperCase(country_1.Name.charAt(0));
                        System.out.println(country_1.Name);
                        country_2.lose_in_war();
                    }
                    else {
                        Character.toUpperCase(country_2.Name.charAt(0));
                        System.out.println(country_2.Name);
                        country_1.lose_in_war();
                    }
                }

            }
                if(ghesmat.length==7){
                    int x=0;
                    int uo = 0;
                    while (uo<Country.countries.size()) {
                        if(Country.countries.get(uo).Name.toLowerCase().equals(ghesmat[2].toLowerCase())){
                            tasmimgir =1 ;
                            break;
                        }
                        if(uo==Country.countries.size()-1){
                            System.out.println("country was not found!");
                            x=1 ;
                        }
                        uo++;
                    }
                    if(x==0){
                        int juh = 0;
                        while (uo<Country.countries.size()) {
                            if(Country.countries.get(juh).Name.toLowerCase().equals(ghesmat[4].toLowerCase())){
                                tasmimgir =1 ;
                                break;
                            }
                            if(juh==Country.countries.size()-1){
                                System.out.println("country was not found!");
                                x=1 ;
                            }
                            juh++;
                        }
                    }
                    if(x==0){
                        Country country_1=null,country_2=null ;
                        int lkn = 0;
                        while (lkn<Country.countries.size()) {
                            if(Country.countries.get(lkn).Name.toLowerCase().equals(ghesmat[2].toLowerCase())){
                                country_1=Country.countries.get(lkn);
                                tasmimgir =1 ;
                            }
                            if(Country.countries.get(lkn).Name.toLowerCase().equals(ghesmat[4].toLowerCase())){
                                country_2=Country.countries.get(lkn);
                                tasmimgir =1 ;
                            }
                            lkn++;

                        }
                        if(country_1.sum_score_in_place(ghesmat[6])>country_2.sum_score_in_place(ghesmat[6])){
                            Character.toUpperCase(country_1.Name.charAt(0));
                            System.out.println(country_1.Name);
                            country_2.lose_in_war();
                        }
                        else {
                            Character.toUpperCase(country_2.Name.charAt(0));
                            System.out.println(country_2.Name);
                            country_1.lose_in_war();
                        }
                    }

                }
                tasmimgir =1 ;}
            else {
                if (ghesmat[1].equals("join")) {
                    int x = 0;
                    Pattern pattern = Pattern.compile("\\[");
                    Matcher matcher = pattern.matcher(ghesmat[4]);
                    if (matcher.find()) {
                        Pattern pattern_1 = Pattern.compile("'([^']*)'");
                        Matcher matcher1 = pattern.matcher(ghesmat[4]);
                        ArrayList<String> asami = new ArrayList<>();
                        while (matcher.find()) {
                            asami.add(matcher.group(1));
                        }
                        String[] final_countries = asami.toArray(new String[0]);
                        for (int j = 0; j < final_countries.length && x == 0; j++) {
                            for (int i = 0; i < Country.countries.size(); i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(final_countries[j].toLowerCase())) {
                                    tasmimgir = 1;
                                    break;
                                }
                                if (i == Country.countries.size() - 1) {
                                    System.out.println("country was not found!");
                                    x = 1;
                                }
                            }
                        }
                        if (x == 0) {
                            Country[] country = new Country[final_countries.length];
                            for (int j = 0; j < final_countries.length; j++) {
                                for (int i = 0; i < Country.countries.size(); i++) {
                                    if (Country.countries.get(i).Name.toLowerCase().equals(final_countries[j].toLowerCase())) {
                                        country[j] = Country.countries.get(i);
                                        tasmimgir = 1;
                                        break;
                                    }
                                }
                            }

                        }
                    } else {
                        for (int i = 0; i < Country.countries.size(); i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[0].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (i == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                x = 1;
                            }
                        }
                        if (x == 0) {
                            for (int i = 0; i < Country.countries.size(); i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[4].toLowerCase())) {
                                    tasmimgir = 1;
                                    break;
                                }
                                if (i == Country.countries.size() - 1) {
                                    System.out.println("country was not found!");
                                    x = 1;
                                }
                            }
                        }
                        if (x == 0) {
                            Country country_1 = null, country_2 = null;
                            for (int i = 0; i < Country.countries.size(); i++) {
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[4].toLowerCase())) {
                                    country_1 = Country.countries.get(i);
                                    tasmimgir = 1;
                                }
                                if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[0].toLowerCase())) {
                                    country_2 = Country.countries.get(i);
                                    tasmimgir = 1;
                                }
                            }
                            join_controller.join_united(country_1, country_2);
                        }
                    }
                    tasmimgir = 1;
                }
                if (ghesmat[1].equals("made")){
                    int x = 0;
                    for (int i = 0; i < Country.countries.size(); i++) {
                        if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[0].toLowerCase())) {
                            tasmimgir = 1;
                            break;
                        }
                        if (i == Country.countries.size() - 1) {
                            System.out.println("country was not found!");
                            x = 1;
                        }
                    }
                    if (x == 0) {
                        for (int i = 0; i < Country.countries.size(); i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[4].toLowerCase())) {
                                tasmimgir = 1;
                                break;
                            }
                            if (i == Country.countries.size() - 1) {
                                System.out.println("country was not found!");
                                x = 1;
                            }
                        }
                    }
                    if (x == 0) {
                        Country country_1 = null, country_2 = null;
                        for (int i = 0; i < Country.countries.size(); i++) {
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[4].toLowerCase())) {
                                country_1 = Country.countries.get(i);
                                tasmimgir = 1;
                            }
                            if (Country.countries.get(i).Name.toLowerCase().equals(ghesmat[0].toLowerCase())) {
                                country_2 = Country.countries.get(i);
                                tasmimgir = 1;
                            }
                        }
                        join_controller.join_enemy(country_1, country_2);
                    }

                    tasmimgir = 1;
                }
            }

            if(tasmimgir==0){
                System.out.println("invalid input!");
            }
        }
    }}


public class join_controller {
    public static void join_united2(int b){
        switch (b){
            case 1:
                System.out.println("something went wrong!");
                break;


        }
    }
    public static void join_united(Country country_1 , Country country_2){
        int b=0;
        if(country_1.is_united_of_countries(country_2)){
            b=1;
            join_united2(b);
            return;
        }
        if(country_2.is_enemy(country_1)){
            b=1;
            join_united2(b);
            return;
        }
        for(int i =0 ; i<country_1.united_of_countries.size() ; i++){
            if(country_1.united_of_countries.get(i).is_enemy(country_2)==true){
                b=1;
                join_united2(b);
                return;
            }
        }
        for(int i=0 ; i<country_1.enemy.size() ; i++ ){
            if(country_1.enemy.get(i).is_united_of_countries(country_2)==true){
                b=1;
                join_united2(b);
                return;
            }
        }
        for(int i=0; i < country_2.united_of_countries.size() ; i++){
            if(country_2.united_of_countries.get(i).is_enemy(country_1)==true){
                b=1;
                join_united2(b);
                return;
            }
        }
        for(int i =0 ; i<country_2.enemy.size() ; i++){
            if(country_2.enemy.get(i).is_united_of_countries(country_1)==true){
                b=1;
                join_united2(b);
                return;
            }
        }
        country_1.united_of_countries.add(country_2);
        country_2.united_of_countries.add(country_1);
        System.out.println("unionized successfully!");
    }
    public static void join_enemy_2(int a){
        switch (a){
            case 1:
                System.out.println("something went wrong!");
                break;

        }
    }
    public static void join_enemy(Country country_1 , Country country_2){
        int a =0 ;
        if(country_1.is_united_of_countries(country_2)){
            a=1;
            join_enemy_2(a);
            return;
        }
        if(country_2.is_enemy(country_1)){
            a=1;
            join_enemy_2(a);
            return;
        }
        for(int i =0 ; i<country_1.united_of_countries.size();i++){
            if(country_1.united_of_countries.get(i).is_united_of_countries(country_2)==true){
                a=1;
                join_enemy_2(a);
                return;
            }
        }
        for(int i=0 ; i<country_1.enemy.size() ; i++ ){
            if(country_1.enemy.get(i).is_enemy(country_2)==true){
                a=1;
                join_united2(a);
                return;
            }
        }
        for(int i=0; i < country_2.united_of_countries.size() ; i++){
            if(country_2.united_of_countries.get(i).is_united_of_countries(country_1)==true){
                a=1;
                join_united2(a);
                return;
            }
        }
        for(int i =0 ; i<country_2.enemy.size() ; i++){
            if(country_2.enemy.get(i).is_enemy(country_1)==true){
                a=1;
                join_united2(a);
                return;
            }
        }
        country_1.enemy.add(country_2);
        country_2.enemy.add(country_1);
        System.out.println("enemy made successfully!");

    }
}
public class infantry_corp extends corps {
    int score ;
    int num =0;
    void mohasebe(String terrain) {
        switch (terrain) {
            case "Forest":
                this.score = 2;
                break;
            case "Plain":
                this.score = 2;
                break;
            case "Hill":
                this.score = 3;
                break;
            case "Mountain":
                this.score = 1;
                break;
        }
    }}import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.Comparator;

public class Country {
    public String Name , Nationality ;
    public static ArrayList<Country>countries = new ArrayList<>();
    public ArrayList<Corp> corps = new ArrayList<>();
    public ArrayList<Army> n_army = new ArrayList<>();
    public ArrayList<Country>united_of_countries = new ArrayList<>();
    public ArrayList<Country> enemy = new ArrayList<>();
    public Country(String name , String nationality){
        setName(name);
        setNationality(nationality);
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setNationality(String Nationality){
        this.Nationality = Nationality;
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
    public Army find_army_in_country(String number){
        for(int i=0;i<n_army.size();i++){
            if(n_army.get(i).number.equals(number)){
                return n_army.get(i);
            }
        }
        return null;
    }
    public Corp find_corp_in_country(String number){
        for(int i =0 ; i<corps.size() ; i++){
            if(corps.get(i).number.equals(number)){
                return corps.get(i);
            }
        }
        return null;
    }
    public void add_corp_to_army(Corp corp_1 , Army army_1){
        for(int i=0;i<n_army.size();i++){
            if(n_army.get(i).number.equals(army_1.number)){
                Corp corp = n_army.get(i).find_corp_in_army(corp_1.number);
                if(corp==null){
                    n_army.get(i).corps.add(corp_1);
                    System.out.println("corps added to army successfully!");
                }
                else{
                    System.out.println("this corps is in an army!");
                }
            }
        }
    }
    public void print_country(){
        System.out.print(Nationality+" "+n_army.size()+" ");
        int[]array = new int[n_army.size()];
        for(int i = 0 ; i<n_army.size() ; i++){
            array[i]=n_army.get(i).corps.size();
        }
        Arrays.sort(array);
        for(int i = 0 ; i<n_army.size();i++){
            System.out.print(array[i]);
        }
        System.out.print("\n");
    }
    public void print_country_with_detail(){
        System.out.print(Nationality+" "+n_army.size()+" ");
        Comparator<Army> comparator = Comparator.comparing(Army::getNumber);
        Collections.sort(n_army,comparator);
        for(int i = 0 ; i<n_army.size();i++){
            System.out.print(n_army.get(i).corps.size()+" ");
        }
        System.out.println();
        for(int i = 0 ; i<n_army.size() ;i++){
            System.out.print(n_army.get(i).leader+" ");
        }
        System.out.println();
    }
    public int sum_score(){
        int score = 0 ;
        for(int i=0 ; i<n_army.size() ; i++){
            score+=n_army.get(i).sum_score_army();
        }
        return score ;
    }
    public boolean is_enemy(Country country){
        for(int i=0 ; i<enemy.size() ; i++){
            Character.toUpperCase(Name.charAt(0));
            if(country.Name.equalsIgnoreCase(enemy.get(i).Name)){
                return true;
            }
        }
        return false ;
    }
    public boolean is_united_of_countries(Country country){
        for(int i=0 ; i<united_of_countries.size() ; i++){
            Character.toUpperCase(Name.charAt(0));
            if(country.Name.equalsIgnoreCase(united_of_countries.get(i).Name)){
                return true ;
            }
        }
        return false;
    }
    public void print_friends(){
        Comparator<Country>comparator = Comparator.comparing(Country::sum_score);
        Collections.sort(united_of_countries,comparator);
        for(int i =0 ; i<united_of_countries.size() ; i++){
            Character.toUpperCase(Name.charAt(0));
            System.out.println(united_of_countries.get(i).Name);
        }
    }
    public void print_enemies(){
        Comparator<Country>comparator = Comparator.comparing(Country::sum_score);
        Collections.sort(enemy,comparator);
        for(int i =0 ; i<enemy.size() ; i++ ){
            Character.toUpperCase(Name.charAt(0));
            System.out.println(enemy.get(i).Name);
        }
    }
    public void lose_in_war(){
        for(int i =0 ; i < n_army.size() ; i++){
            for (int j =0 ; j <n_army.get(i).corps.size() ; j++){
                corps.get(j).half_infantry_and_cavalry();
            }
        }
    }
    public int sum_score_in_place(String place){
        int sum = 0 ;
        for(int i =0 ; i<n_army.size() ; i++){
            if(n_army.get(i).place.equals(place)){
                sum+=n_army.get(i).sum_score_army();
            }
        }
        return sum ;
    }
    public void creat_country (String y,String z){
        boolean x = false;
        int po = 0;
        Character.toUpperCase(Name.charAt(0));
        while (!x && po < Country.countries.size()) {
            if (Country.countries.get(po).Name.toLowerCase().equals(y.toLowerCase())) {
                System.out.println("country was created");
                x = true;
            }
            po++;
        }
        if (!x) {
            Country country_2 = new Country(y, z);
            countries.add(country_2);
            System.out.println("country " + y + " created");
        }}
    public void set_add (String h,String y,String z,boolean x){
        if (this.Name.toLowerCase().equals(z.toLowerCase())) {
            Army army = this.find_army_in_country(y);
            if (army == null) {
                System.out.println("army was not found!");
                x = true;
            } else {
                Corp corp = this.find_corp_in_country(h);
                if (corp == null) {
                    System.out.println("corps was not found!");
                    x = true;
                } else {
                    this.add_corp_to_army(corp, army);
                }
            }
        }
    }

}
abstract class corps {
    abstract void mohasebe(String noa) ;
}public class Cavarly_corp extends corps {
    int score =0 ;
    int num =0;

    void mohasebe(String terrain ) {
        switch (terrain) {
            case "Forest":
                score = 2;
                break;
            case "Plain":
                score = 2;
                break;
            case "Hill":
                score = 3;
                break;
            case "Mountain":
                score = 1;
                break;
        }

    }
}

public class Corp {
    public infantry_corp infantry = new infantry_corp();
    public Cavarly_corp cavalry = new Cavarly_corp();
    public Artillery artillery = new Artillery();
    public MilitryRank officer_rank;
    public int tedad_niroo;
    public String number;
    public Corp(int infantrynum, int cavalrynum, int artillerynum, String officer_rank, String number) {
        setNumber(number);
        infantry.num = infantrynum ;
        cavalry.num = cavalrynum ;
        artillery.num = artillerynum;
        setOfficer_rank(officer_rank);
        setTedad_niroo(artillerynum + cavalrynum + infantrynum);
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getInfantry() {
        return infantry.num;
    }
    public int getCavalry() {
        return cavalry.num;
    }
    public int getArtillery() {
        return artillery.num;
    }
    public void setOfficer_rank( String str) {
        this.officer_rank = MilitryRank.get( str);
    }
    public void setTedad_niroo(int tedad_niroo) {
        this.tedad_niroo = tedad_niroo;
    }

    public int getScoreInCorp(String place) {
        switch (place) {
            case "Forest":
                return   getCavalry() * 5 + getArtillery() * 2 + tedad_niroo+getInfantry()*2+officer_rank.score * 1000 ;
            case "Plain":
                return   getCavalry() * 0 + getArtillery() * 1 + tedad_niroo+ getInfantry() * 2+officer_rank.score * 1000;
            case "Hill":
                return    getCavalry() * -1 + getArtillery() * 1 + tedad_niroo+ getInfantry() * 3+officer_rank.score * 1000;
            case "Mountain":
                return   getCavalry() * -2 + getArtillery() * 1 + tedad_niroo+getInfantry() * 1+officer_rank.score * 1000;
        }
        return 0;
    }
    public void half_infantry_and_cavalry() {
        infantry.num = getInfantry()/2;
        cavalry.num = getCavalry()/2;
    }

}
public class Artillery extends corps {
    int score =0 ;
    int num =0 ;

    void mohasebe(String terrain ) {
        switch (terrain) {
            case "Forest":
                score = 2;
                break;
            case "Plain":
                score = 2;
                break;
            case "Hill":
                score = 3;
                break;
            case "Mountain":
                score = 1;
                break;
        }

    }
}

import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;

public class Army {

    public String leader , number,place ;
    public ArrayList<Corp>corps = new ArrayList<>();
    public Army(String leader , String number){
        setLeader(leader);
        setNumber(number);
    }
    public Army(String leader , String number,String place){
        setPlace(place);
        setLeader(leader);
        setNumber(number);
    }
    public void setLeader(String leader){
        this.leader=leader;
    }
    public void setNumber(String number){this.number = number;}
    public void setPlace(String place){
        this.place=place;
    }
    public String getNumber() {
        return number;
    }
    public Corp find_corp_in_army(String number){
        for(int i =0 ; i<corps.size() ; i++){
            if(corps.get(i).number.equals(number)){
                return corps.get(i) ;
            }
        }
        return null ;
    }
    public void sort_corp_and_print(){
        Comparator<Corp>comparator = Comparator.comparing(Corp::getNumber_in_int);
        Collections.sort(corps,comparator);
        for(int i=0;i<corps.size() ; i++){
            System.out.println("\t"+corps.get(i).getInfantry()/1000+" "+ corps.get(i).getCavalry()/400 +" "+ corps.get(i).getArtillery()/10+" "+ corps.get(i).officer_rank +" "+corps.get(i).tedad_niroo );
        }
    }
    public int sum_score_army(){
        int num =0 ;
        for(int i=0 ; i< corps.size() ; i++){
            num+=corps.get(i).getScoreInCorp(place);
        }
        return num ;
    }


}
