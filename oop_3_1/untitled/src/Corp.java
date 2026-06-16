public class Corp extends Regiment {
    private int infantry,cavalry,artillery,officer_rank,tedad_niroo,number_in_int;
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValueOfRomanNumeral(s.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }
    private int getValueOfRomanNumeral(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public Corp(int infantry , int cavalry , int artillery , int officer_rank , String number){
        this.number=number;
        this.artillery=artillery;
        this.cavalry=cavalry;
        this.infantry=infantry;
        this.officer_rank = officer_rank ;
        tedad_niroo = artillery+cavalry+infantry ;
        number_in_int=romanToInt(number);
    };
    public String check_officer_corp(int officer){
        switch (officer){
            case 1:
                return "corporal";
            case 4:
                return "sergent";
            case 7:
                return "lieutenant";
            case 12:
                return "capitan";
            case 18:
                return "colonel";
            case 22:
                return "general";

            case 25:
                return "marshal";
        }
        return null ;
    }

        public String getNumber() {
            return number;
        }
        public  void setNumber(String number){
            this.number=number;
        }
        public int getTedad_niroo(){
        return tedad_niroo ;
        }
        public void print_corp(){
            System.out.println("\t"+infantry/1000+" "+ cavalry/400 +" "+ artillery/10+" "+ check_officer_corp(officer_rank) +" "+tedad_niroo );
        }
        public int getNumber_in_int(){
        return number_in_int ;
        }
        public int get_score_in_corp(String place){
        int score = 0 ;
        switch (place){
            case "Forest":
                score = infantry*2+cavalry*5+artillery*2+tedad_niroo;
                break;
            case "Plain":
                score = infantry*2+cavalry*0+artillery*1+tedad_niroo;
                break;
            case "Hill":
                score = infantry*3+cavalry*-1+artillery*1+tedad_niroo;
                break;
            case "Mountain":
                score = infantry*1+cavalry*-2+artillery*1+tedad_niroo;
                break;
        }
        score+=officer_rank*1000;
        return score ;
        }
        public void half_infantry_and_cavalry(){
            infantry/=2;
            cavalry/=2;
        }

}

