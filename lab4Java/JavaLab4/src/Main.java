import javax.swing.text.DefaultHighlighter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;


class GradeBook {
    String studentName;
    int studentYear;
    String studentID;
    Vector<Session> sessions;

    GradeBook(){
        studentName = null;
        studentYear = 1;
        studentID = null;
        sessions = new Vector<>(getStudentYear() - 1);
    }

    public void setStudentName(String _studentName) {
        this.studentName = _studentName;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentID(String _studentID) {
        this.studentID = _studentID;
    }
    public String getStudentID(){
        return studentID;
    }
    public void setStudentYear(int _studentYear){
        this.studentYear = _studentYear;
    }
    public int getStudentYear(){
        return studentYear;
    }
    public void addSession(Session session){
        this.sessions.add(session);
    }

    public void gradeBookReader(Scanner in, FileReader fr) throws Exception {
        String line = in.nextLine();
        String[] words = line.split(" ");
        String _studentName = words[0];
        String _studentID = words[1];
        int _studentYear = Integer.parseInt(words[2]);
        setStudentName(_studentName);
        setStudentID(_studentID);
        setStudentYear(_studentYear);
        for (int i = 0; i < getStudentYear() - 1; i++){
            Session session = new Session();
            session.sessionReader(in, fr);
            session.setNumOfSession(i + 1);
            addSession(session);
        }
    }

    public void gradeBookWriter(FileWriter fw, Scanner in, int numOfSession) throws Exception {

        Session session = sessions.get(numOfSession - 1);
        for (int i = 0; i < session.numOfExams; i++) {
            fw.write("Student Name: " + getStudentName() + " Student ID: " + getStudentID() + '\t');
            session.sessionWriter(fw, in, i);
        }
    }
    class Session {
        int numOfSession;
        Vector<Exam> exams;
        int numOfExams;

        Session() {
            numOfSession = 0;
            exams = new Vector<>(getNumOfExams());
            numOfSession = 0;
        }

        public void setNumOfSession(int _numOfSession) {
            numOfSession = _numOfSession;
        }

        public int getNumOfSession() {
            return numOfSession;
        }

        public void setNumOfExams(int _numOfExams) {
            numOfExams = _numOfExams;
        }

        public int getNumOfExams() {
            return numOfExams;
        }

        public void addExam(Exam _exam) {
            exams.add(_exam);
        }

        public void sessionReader(Scanner in, FileReader fr) throws Exception {
            setNumOfExams(Integer.parseInt(in.nextLine()));
            for (int i = 0; i < getNumOfExams(); i++) {
                Exam exam = new Exam();
                exam.examReader(in, fr);
                addExam(exam);
            }
        }

        public void sessionWriter(FileWriter fw, Scanner in, int num) throws Exception {
                exams.get(num).examWriter(fw, in);
        }

        class Exam {
            String examName;
            int examResult;
            String teacherName;

            Exam() {
                examName = null;
                examResult = 0;
                teacherName = null;
            }

            Exam(String _examName, int _examResult, String _teacherName) {
                examResult = _examResult;
                examName = _examName;
                teacherName = _teacherName;
            }

            public void setExamName(String _examName) {
                examName = _examName;
            }

            public String getExamName() {
                return this.examName;
            }

            public void setExamResult(int _examResult) {
                examResult = _examResult;
            }

            public int getExamResult() {
                return this.examResult;
            }

            public void setTeacherName(String _teacherName) {
                teacherName = _teacherName;
            }

            public String getTeacherName() {
                return this.teacherName;
            }

            public void examReader(Scanner in, FileReader fr) throws Exception {
                String line = in.nextLine();
                String[] words = line.split(" ");
                String _teacherName = words[0];
                int _examResult = Integer.parseInt(words[1]);
                StringBuilder _examName = new StringBuilder();
                for (int i = 2; i < words.length; i++) {
                    _examName.append(words[i] + " ");
                }

                setExamName(_examName.toString());
                setTeacherName(_teacherName);
                setExamResult(_examResult);
            }

            public void examWriter(FileWriter fw, Scanner in) throws Exception {
                fw.write("Exam Name: " + getExamName() + '\t' + "Teacher name: " + getTeacherName() + '\t' + "Exam result: " + getExamResult() + '\n');
            }
        }
    }
}

public class Main {
    public static void Reader(Scanner in, FileReader fr, int numOfStudent, Vector <GradeBook> gradeBooks) throws Exception {
        for (int i = 0; i < numOfStudent; i++) {
            GradeBook gradeBook = new GradeBook();
            gradeBook.gradeBookReader(in, fr);
            gradeBooks.add(gradeBook);
        }
    }
    public static int MaxYear(int numOfStudent, Vector <GradeBook> gradeBooks){
        int maxYear = 1;
        for (int i = 0; i < numOfStudent; i++) {
            maxYear = Math.max(maxYear, gradeBooks.get(i).getStudentYear());
        }
        return  maxYear;
    }
    public static void Writer(Scanner in, FileWriter fw, int numOfStudent, Vector <GradeBook> gradeBooks, int maxYear) throws Exception{
        int count = 1;
        while (count <= maxYear - 1){
            fw.write(Integer.toString(count) + '\n');
            for (int i = 0; i < numOfStudent; i++) {
                GradeBook gradeBook = gradeBooks.get(i);
                for (int j = 0; j < gradeBook.getStudentYear() - 1; j++){
                    GradeBook.Session session = gradeBook.sessions.get(j);
                    if (session.getNumOfSession() == count){
                        gradeBook.gradeBookWriter(fw, in, count);
                    }
                }
            }
            fw.write('\n');
            count += 1;
        }
    }
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfStudent = Integer.parseInt(in.nextLine());
        Vector <GradeBook> gradeBooks = new Vector<>(numOfStudent);
        Reader(in, fr, numOfStudent, gradeBooks);
        int maxYear = MaxYear(numOfStudent, gradeBooks);
        Writer(in, fw, numOfStudent, gradeBooks, maxYear);
        fr.close();
        fw.close();
    }
}