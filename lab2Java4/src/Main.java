import java.io.*;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] Matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Matrix[i][j] = in.nextInt();
            }
        }
        int Max = -1;
        int iMax = -1;
        for (int i = 0; i < n; i++){
            int sum = 0;
            int k = 0;
            for (int j = 0; j < m ; j++){
                if (Matrix[i][j] % 2 != 0){
                    k++;
                }
                sum += Math.abs(Matrix[i][j]);
            }
            if (sum > Max && k == m){
                Max = sum;
                iMax = i;
            }
        }

        for (int j = 0; j < m; j++) {
            fw.write(Integer.toString(Matrix[iMax][j]) + " ");
        }
        fr.close();
        fw.close();
    }
}