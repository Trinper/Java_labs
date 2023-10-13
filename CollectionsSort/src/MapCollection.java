import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
import java.lang.*;


public class MapCollection {
    public static void Reader(Scanner in, FileReader fr, int numOfExam, ArrayList <Exam> examsList) throws Exception {
        for (int i = 0; i < numOfExam; i++) {
            Exam exam = new Exam();
            exam.examReader(in, fr);
            examsList.add(exam);
        }
    }

    public static void WriterArray(Scanner in, FileWriter fw, int numOfExam, ArrayList <Exam> examsList) throws Exception {
        for (int i = 0; i < numOfExam; i++){
            examsList.get(i).examWriterArray(fw, in);
        }
    }

    public static void WriterMap(Scanner in, FileWriter fw, int numOfTeachers, HashMap <String, List<Exam>> teacherExams) throws Exception {
        for (HashMap.Entry<String, List<Exam>> item: teacherExams.entrySet()){
            fw.write(item.getKey() + '\n');
            List <Exam> exams = item.getValue();
            for (int i = 0; i < exams.size(); i++){
                exams.get(i).examWriterMap(fw, in);
            }
        }
    }

    public static void createTeacherExams(HashMap <String, List<Exam>> teacherExams, ArrayList <Exam> examsList, int numOfExam){
        for (int i = 0; i < numOfExam; i++){
            teacherExams.put(examsList.get(i).getTeacherName(), new ArrayList<>());
        }
        for (int i = 0; i < numOfExam; i++){
            teacherExams.get(examsList.get(i).getTeacherName()).add(examsList.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfExam = Integer.parseInt(in.nextLine());
        //Map <String, ArrayList<Exam> > examsList = new Map<>(numOfExam);
        ArrayList <Exam> examsList = new ArrayList<>(numOfExam);
        Reader(in, fr, numOfExam, examsList);
        WriterArray(in, fw, numOfExam, examsList);
        Collections.sort(examsList, new Sort());
        fw.write('\n');
        WriterArray(in, fw, numOfExam, examsList);
        fw.write('\n');
        HashMap <String, List<Exam>> teacherExams = new HashMap<>();
        createTeacherExams(teacherExams, examsList, numOfExam);
        WriterMap(in, fw, teacherExams.size(), teacherExams);
        fr.close();
        fw.close();
    }
}