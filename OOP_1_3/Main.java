import java.util.Scanner;

public class Main {
    public static void f(string sudoku[][],int i , int j){
        int arr_1 [] = new int [2];
        int arr_2 [] = new int [2];
        int arr_row[]  = new int [6];
        int arr_col[]  = new int [6];
        for(int o =0 ; o <2 ; o++) {
            arr_1[o]=0;
            arr_2[o]=0;
        }
        for(int o =0 ; o <6 ; o++) {
            arr_col[o]=0;
            arr_row[o]=0;
        }
        for(int o = 0 ; o < 6 ; o++){
            switch(sudoku[i][o]){
                case "1":
                    arr_row[0]=1;
                    break;
                case "2":
                    arr_row[1]=1;
                    break;
                case "3":
                    arr_row[2]=1;
                    break;
                case "4":
                    arr_row[3]=1;
                    break;
                case "5":
                    arr_row[4]=1;
                    break;
                case "6" :
                    arr_row[5]=1;
                    break;
                case "x":
                    break ;
            }
            switch(sudoku[o][j]){
                case "1":
                    arr_col[0]=1;
                    break;
                case "2":
                    arr_col[1]=1;
                    break;
                case "3":
                    arr_col[2]=1;
                    break;
                case "4":
                    arr_col[3]=1;
                    break;
                case "5":
                    arr_col[4]=1;
                    break;
                case "6" :
                    arr_col[5]=1;
                    break;
                case "x":
                    break ;
            }
        }
        int z = 0 ;
        for(int o = 0 ; o<6 ; o++) {
            if (arr_row[o]==0){
                arr_1[z]=o+1;
                z++;
            }
        }
        z=0;
        for(int o=0 ; o<6 ; o++) {
            if(arr_col[o]==0){
                arr_2[z]=o+1;
                z++;
            }
        }
        if(arr_1[0]==arr_2[0]) {
            sudoku[i][j]=arr_1[0];
        }
        else if (arr_1[0]==arr_2[1]){
            sudoku[i][j]=arr_1[0];
        }
        else if (arr_1[1]==arr_2[0]) {
            sudoku[i][j]=arr_1[1];
        }
        else if (arr_1[1]==arr_2[1]) {
            sudoku[i][j]=arr_1[1];
        }
        else {}
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] sudoku = new String[6][6];
        for (int i = 0; i < 6; i++) {
            String a = scanner.nextLine();
            enter_sudoku(sudoku, a, i);
        }
        boolean con = true;
        while (con) {
            con = false;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (sudoku[i][j].equals("x")) {
                        con = true;
                        f(sudoku,i,j);
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
