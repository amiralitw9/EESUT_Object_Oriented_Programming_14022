import java.text.DecimalFormat;
import java.util.Scanner;

public class Main{
	public static void main(String []args){
		Scanner scanner = new Scanner(System.in);
		double v = scanner.nextDouble();
		int type = scanner.nextInt();
		if (type !=1 && type != 2 ){
			System.out.println("Invalid Input");
			System.exit(0);
		}
		int num = scanner.nextInt();
		boolean short_circut=false;
		double []r = new double [num];
		for(int i = 0 ; i<num ; i++){
			r[i]= scanner.nextDouble();
		}
		double r_t = 0 ;
		if (type==1){
			for(int i = 0 ; i<num ; i++){
				r_t+=r[i];
			}
			}
		if(type==2){
			for(int i = 0 ; i<num ; i++){
				if(r[i]==0){
					short_circut=true;
				}
				r_t+=1/r[i];
			}
			r_t=1/r_t;
		}
		if(r_t==0){
			System.out.format("Total Res: 0 Kohm\nShort Circuit") ;
		}
		else{
			double power = ((v*v)/r_t)*1000;
			r_t = r_t/1000;
			DecimalFormat r_t_2 = new DecimalFormat("#.##");
			String formattedNumber_1 = r_t_2.format(r_t);
			String formattedNumber_2 = r_t_2.format(power);

			if(short_circut==true){
				System.out.format("Total Res: 0 Kohm\nShort Circuit") ;
			}
			else {
				System.out.format("Total Res: %s Kohm \nTotal Pow: %s mW",formattedNumber_1,formattedNumber_2);
			}	
	}
}

		
}