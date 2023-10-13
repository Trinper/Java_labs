import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

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

    public void teacherNameWriter(FileWriter fw, Scanner in) throws Exception {
        fw.write("Teacher name: " + getTeacherName());
    }

    public void examNameWriter(FileWriter fw, Scanner in) throws Exception {
        fw.write("Name of exam: " + getExamName());
    }

    public void examResultWriter(FileWriter fw, Scanner in) throws Exception {
        fw.write("Result of Exam: " + getExamResult());
    }

    public void examWriter(FileWriter fw, Scanner in) throws Exception{
        teacherNameWriter(fw, in);
        fw.write('\t');
        examNameWriter(fw, in);
        fw.write('\t');
        examResultWriter(fw, in);
        fw.write('\n');
    }
}