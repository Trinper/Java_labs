import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class TreeSetCollection {
    public static void Reader(Scanner in, FileReader fr, int numOfExam, TreeSet<Exam> examsSet) throws Exception {
        for (int i = 0; i < numOfExam; i++) {
            Exam exam = new Exam();
            exam.examReader(in, fr);
            examsSet.add(exam);
        }
    }

    public static void WriterSet(Scanner in, FileWriter fw, TreeSet<Exam> examsSet) throws Exception {
        for (Exam exam: examsSet){
            exam.examWriter(fw, in);
        }
    }

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfExam = Integer.parseInt(in.nextLine());
        TreeSet <Exam> examsSet = new TreeSet<Exam>(new Sort());
        Reader(in, fr, numOfExam, examsSet);
        WriterSet(in, fw, examsSet);
        fr.close();
        fw.close();
    }
}