import javax.swing.text.DefaultHighlighter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

class Session{
    int numOfSession;
    public Vector <Exam> exams ;
    int numOfExams;
    Session(){
        numOfSession = 0;
        exams = new Vector<>(getNumOfExams());
        numOfSession = 0;
    }

    public void setNumOfSession(int _numOfSession){
        numOfSession = _numOfSession;
    }
    public int getNumOfSession(){
        return numOfSession;
    }

    public void setNumOfExams(int _numOfExams){
        numOfExams = _numOfExams;
    }
    public int getNumOfExams(){
        return numOfExams;
    }
    public void addExam(Exam _exam){
        exams.add(_exam);
    }
    public void sessionReader(Scanner in, FileReader fr, FileWriter fw) throws  Exception{
        setNumOfExams(Integer.parseInt(in.nextLine()));
        for (int i = 0; i < getNumOfExams(); i++){
            Exam exam = new Exam();
            exam.examReader(in, fr);
            addExam(exam);
        }
    }
    public void sessionWriter(FileWriter fw, Scanner in) throws Exception{

        for (int i = 0; i < getNumOfExams(); i++) {
            exams.get(i).examWriter(fw, in);
            fw.write('\n');
        }
    }
    class Exam{
        String examName;
        int examResult;
        String teacherName;

        Exam(){
            examName = null;
            examResult = 0;
            teacherName = null;
        }
        Exam(String _examName, int _examResult, String _teacherName){
            examResult = _examResult;
            examName = _examName;
            teacherName = _teacherName;
        }

        public void setExamName (String _examName){
            examName = _examName;
        }

        public String getExamName() {
            return this.examName;
        }

        public void setExamResult(int _examResult){
            examResult = _examResult;
        }

        public int getExamResult(){
            return this.examResult;
        }

        public void setTeacherName(String _teacherName){
            teacherName = _teacherName;
        }

        public String getTeacherName(){
            return this.teacherName;
        }

        public void examReader(Scanner in, FileReader fr) throws  Exception{
                String line = in.nextLine();
                String[] words = line.split(" ");
                String _teacherName = words[0];
                int _examResult = Integer.parseInt(words[1]);
                StringBuilder _examName = new StringBuilder();
                for (int i = 2; i < words.length; i++){
                    _examName.append(words[i] + " ");
                }

                setExamName(_examName.toString());
                setTeacherName(_teacherName);
                setExamResult(_examResult);
        }
        public void examWriter(FileWriter fw, Scanner in) throws Exception{
            fw.write("Exam Name: " + getExamName() + '\n' + "Teacher name: " + getTeacherName() + '\n'+ "Exam result: " + getExamResult() + '\n');
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        Session session = new Session();
        session.sessionReader(in, fr, fw);
        session.sessionWriter(fw, in);
        fr.close();
        fw.close();
    }
}