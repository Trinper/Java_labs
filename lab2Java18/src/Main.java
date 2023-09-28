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
        int count = 0;
        for (int j = 0; j < m; j++){
            HashSet <Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++){
                set.add(Matrix[i][j]);
            }
            if (set.size() == n){
                count++;
            }
        }
        fw.write(Integer.toString(count));
        fr.close();
        fw.close();
    }
}