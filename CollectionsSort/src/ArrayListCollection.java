import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class ArrayListCollection {
    public static void Reader(Scanner in, FileReader fr, int numOfExam, ArrayList <Exam> examsList) throws Exception {
        for (int i = 0; i < numOfExam; i++) {
            Exam exam = new Exam();
            exam.examReader(in, fr);
            examsList.add(exam);
        }
    }

    public static void Writer(Scanner in, FileWriter fw, int numOfExam, ArrayList <Exam> examsList) throws Exception {
        for (int i = 0; i < numOfExam; i++){
            examsList.get(i).examWriter(fw, in);
        }
    }
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfExam = Integer.parseInt(in.nextLine());
        ArrayList <Exam> examsList = new ArrayList<>(numOfExam);
        Reader(in, fr, numOfExam, examsList);
        Writer(in, fw, numOfExam, examsList);
        Collections.sort(examsList, new Sort());
        fw.write('\n');
        Writer(in, fw, numOfExam, examsList);
        String examFindName = in.nextLine();
        examFindName = examFindName.toLowerCase();
        examFindName += " ";
        int index = Collections.binarySearch(examsList, new Exam(examFindName, 0, null), new Sort());
        fw.write('\n' + Integer.toString(index));
        fr.close();
        fw.close();
    }
}