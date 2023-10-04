import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
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

    public void gradeBookWriter(FileWriter fw, Scanner in, int numOfSession, String name) throws Exception {
        Session session = sessions.get(numOfSession - 1);
        for (int i = 0; i < session.getNumOfCredits(); i++){
            if (Objects.equals(session.credits.get(i).getCreditName().toLowerCase(), name)) {
                fw.write("Student Name: " + getStudentName() + " Student ID: " + getStudentID() + '\t');
                session.sessionWriter(fw, in, i, true);
            }
        }
        for (int i = 0; i < session.getNumOfExams(); i++) {
            if (Objects.equals(session.exams.get(i).getExamName().toLowerCase(), name)) {
                fw.write("Student Name: " + getStudentName() + " Student ID: " + getStudentID() + '\t');
                session.sessionWriter(fw, in, i , false);
            }
        }
    }
    class Session {
        int numOfSession;
        Vector<Exam> exams;
        Vector<Credit> credits;
        int numOfExams;
        int numOfCredits;

        Session() {
            numOfSession = 0;
            exams = new Vector<>(getNumOfExams());
            credits = new Vector<>(getNumOfCredits());
            numOfSession = 0;
            numOfCredits = 0;
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

        public void setNumOfCredits(int _numOfCredits) {
            numOfCredits = _numOfCredits;
        }

        public int getNumOfCredits() {
            return numOfCredits;
        }
        public void addExam(Exam _exam) {
            exams.add(_exam);
        }

        public void addCredit(Credit _credit){
            credits.add(_credit);
        }
        public void sessionReader(Scanner in, FileReader fr) throws Exception {
            setNumOfCredits(Integer.parseInt(in.nextLine()));
            for (int i = 0; i < getNumOfCredits(); i++) {
                Credit credit = new Credit();
                credit.creditReader(in, fr);
                addCredit(credit);
            }
            setNumOfExams(Integer.parseInt(in.nextLine()));
            for (int i = 0; i < getNumOfExams(); i++) {
                Exam exam = new Exam();
                exam.examReader(in, fr);
                addExam(exam);
            }
        }

        public void sessionWriter(FileWriter fw, Scanner in, int num, boolean flag) throws Exception {
                if (flag){
                    credits.get(num).creditWriter(fw, in);
                } else {
                    exams.get(num).examWriter(fw, in);
                }
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
                    _examName.append(words[i].toLowerCase()).append(" ");
                }

                setExamName(_examName.toString());
                setTeacherName(_teacherName);
                setExamResult(_examResult);
            }

            public void examWriter(FileWriter fw, Scanner in) throws Exception {
                fw.write(  "Teacher name: " + getTeacherName() + '\t' + "Exam result: " + getExamResult() + '\n');
            }
        }

        class Credit {
            String creditName;
            boolean creditResult;
            String teacherName;

            Credit() {
                creditName = null;
                creditResult = false;
                teacherName = null;
            }

            Credit(String _examName, boolean _examResult, String _teacherName) {
                creditResult = _examResult;
                creditName = _examName;
                teacherName = _teacherName;
            }

            public void setCreditName(String _creditName) {
                creditName = _creditName;
            }

            public String getCreditName() {
                return this.creditName;
            }

            public void setCreditResult(boolean _creditResult) {
                creditResult = _creditResult;
            }

            public boolean getCreditResult() {
                return this.creditResult;
            }

            public void setTeacherName(String _teacherName) {
                teacherName = _teacherName;
            }

            public String getTeacherName() {
                return this.teacherName;
            }

            public void creditReader(Scanner in, FileReader fr) throws Exception {
                String line = in.nextLine();
                String[] words = line.split(" ");
                String _teacherName = words[0];
                boolean _creditResult = Objects.equals(words[1], "+");
                StringBuilder _creditName = new StringBuilder();
                for (int i = 2; i < words.length; i++) {
                    _creditName.append(words[i].toLowerCase()).append(" ");
                }

                setCreditName(_creditName.toString());
                setTeacherName(_teacherName);
                setCreditResult(_creditResult);
            }

            public void creditWriter(FileWriter fw, Scanner in) throws Exception {
                fw.write(  "Teacher name: " + getTeacherName() + '\t' + "Exam result: " + getCreditResult() + '\n');
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
    public static void nameOfExamsAndCredits(Vector <GradeBook> gradeBooks,int numOfStudent, int numOfSessions, Vector <String> namesOfExams){
        for (int i = 0; i < numOfStudent; i++){
            GradeBook gradeBook = gradeBooks.get(i);
            if (numOfSessions <= gradeBook.getStudentYear() - 2) {
                GradeBook.Session session = gradeBook.sessions.get(numOfSessions);
                for (int j = 0; j < session.getNumOfCredits(); j++) {
                    String creditName = session.credits.get(j).getCreditName().toLowerCase();
                    if (!namesOfExams.contains(creditName)) {
                        namesOfExams.add(session.credits.get(j).getCreditName());
                    }
                }
                for (int j = 0; j < session.getNumOfExams(); j++) {
                    String examName = session.exams.get(j).getExamName().toLowerCase();
                    if (!namesOfExams.contains(examName)) {
                        namesOfExams.add(session.exams.get(j).getExamName());
                    }
                }
            }
        }
    }
    public static void Writer(Scanner in, FileWriter fw, int numOfStudent, Vector <GradeBook> gradeBooks, int maxYear) throws Exception{
        int count = 1;
        while (count <= maxYear - 1){
            Vector <String> namesOfExams = new Vector<>();
            nameOfExamsAndCredits(gradeBooks, numOfStudent, count - 1, namesOfExams);
            fw.write("Session number: " + count + '\n');
            for (String namesOfExam : namesOfExams) {
                String nameOfExam = namesOfExam.toLowerCase();
                fw.write("Exam Name: " + nameOfExam + '\n');
                for (int i = 0; i < numOfStudent; i++) {
                    GradeBook gradeBook = gradeBooks.get(i);
                    for (int j = 0; j < gradeBook.getStudentYear() - 1; j++) {
                        GradeBook.Session session = gradeBook.sessions.get(j);
                        if (session.getNumOfSession() == count) {
                            gradeBook.gradeBookWriter(fw, in, count, nameOfExam);
                        }
                    }
                }
                fw.write('\n');
            }
            count += 1;
        }
    }
    public static void WriterExc(Scanner in, FileWriter fw, int numOfStudent, Vector <GradeBook> gradeBooks, int maxYear) throws Exception{
        int count = 1;
        while (count < maxYear){
            fw.write("Names of student in session number " + count + ": ");
            for (int i = 0; i < numOfStudent; i++){
                GradeBook gradeBook = gradeBooks.get(i);
                if (gradeBook.getStudentYear() > count) {
                    GradeBook.Session session = gradeBook.sessions.get(count - 1);
                    boolean creditsIsExc = true;
                    boolean examsIsExc = true;
                    for (int j = 0; j < session.getNumOfCredits(); j++){
                        if (!session.credits.get(j).getCreditResult()) {
                            creditsIsExc = false;
                            break;
                        }
                    }
                    for (int j = 0; j < session.getNumOfExams(); j++){
                        if (session.exams.get(j).getExamResult() < 9){
                            examsIsExc = false;
                            break;
                        }
                    }
                    if (creditsIsExc && examsIsExc){
                        fw.write(gradeBook.getStudentName() + " ");
                    }
                }
            }
            count += 1;
            fw.write('\n');
        }
    }
    public static void main(String[] args) throws Exception {
        FileWriter fw_ExcellentStudents = new FileWriter("outputExc.txt");
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfStudent = Integer.parseInt(in.nextLine());
        Vector <GradeBook> gradeBooks = new Vector<>(numOfStudent);
        Reader(in, fr, numOfStudent, gradeBooks);
        int maxYear = MaxYear(numOfStudent, gradeBooks);
        Writer(in, fw, numOfStudent, gradeBooks, maxYear);
        WriterExc(in, fw_ExcellentStudents, numOfStudent, gradeBooks, maxYear);
        fr.close();
        fw.close();
        fw_ExcellentStudents.close();
    }
}