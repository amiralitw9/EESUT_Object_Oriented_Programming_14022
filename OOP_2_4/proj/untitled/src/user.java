public class user {

        private String username;
        private String password;
        private String nickname;
        private int bonous;
        private int money;
        private int moves;
        private int userbooster_free_switch;
        private int userbooster_striped_brush;
        private int userbooster_color_bomb_brush;
        private int userbooster_lollipop_hammer;
        private int userbooster_wrapped_brush;

        public void setPassword(String password){
            this.password = password ;
        }
        public String getPassword(){
            return password ;
        }
        public  void setpassword(String username)
        {
            this.username = username;
        }


        public  void setNickname(String nickname)
        {
            this.nickname = nickname ;
        }


        public  void setBonous(int bonous)
        {
            this.bonous = bonous;
        }


        public  String getUsernameName()
        {
            return username;
        }


        public  String getNickname()
        {
            return nickname ;
        }



        public int getBonous()
        {
            return bonous ;
        }


        public final int getMoney()
        {
            return money ;
        }


        public final void addMoney(int money)
        {
            this.money+=money ;
        }


        public final void addMove(int addmove)
        {
            this.moves+=addmove ;
        }



        public final void setbooster_free(int num)
        {
            userbooster_free_switch+=num;
        }


        public final void setbooster_striped(int num)
        {
            userbooster_striped_brush+=num ;
        }


        public final void setbooster_color(int num)
        {
            userbooster_color_bomb_brush+=num ;
        }


        public final void setbooster_lollipop(int num)
        {
            userbooster_lollipop_hammer+=num ;
        }



        public final void setbooster_wrapped(int num) {
            userbooster_wrapped_brush+=num ;
        }
}
