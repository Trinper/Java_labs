import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
class Pair{
    int first;
    int second;
    public Pair(int first_, int second_){
        this.first = first_;
        this.second = second_;
    }

}

class ArraySortComparator{
    static void sort(Pair[] arr){
        Comparator<Pair> comparator = new Comparator<>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.first - p2.first;
            }
        };

        Arrays.sort(arr, comparator);
    }
}

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
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++){
            int jMax = -1;
            int Max = -1;
            for (int j = 0; j < m; j++){
                if (Matrix[i][j] > Max){
                    Max = Matrix[i][j];
                    jMax = j;
                }
            }
            arr[i] = new Pair(Matrix[i][jMax], i);
        }
        ArraySortComparator.sort(arr);
        int [][] NewMatrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                NewMatrix[i][j] = Matrix[arr[i].second][j];
            }
            fw.write('\n');
        }
        fr.close();
        fw.close();
    }
}