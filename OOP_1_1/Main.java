import java.util.Scanner;

public class Main{
	public static void main(String []args) {
		Scanner scanner = new Scanner (System.in);
		int n = scanner.nextInt();
		String road = scanner.next();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		boolean seen = false ;
		int counter =0 ;
		int counter_1=0 ;
 		for(int i = a-1 ; i<b ; i++) {
			if (road.charAt(i)=='P'){
				seen = false ; 
			}
			if (counter_1 != 0 && seen==false ){
				String binary = Integer.toBinaryString(counter_1);
//				System.out.println(binary);
				for(int j = 0 ; j<binary.length(); j++) {
					if (binary.charAt(j)=='1'){
						counter++;
					}
				}
				counter_1=0;
			}
			if (road.charAt(i)=='S'){
				seen=true;
				counter_1++;
			}
		}
		System.out.println(counter);
	}
}