import java.util.Comparator;

class Sort implements Comparator<Exam> {
    public int compare(Exam first, Exam second) {
        return first.getTeacherName().compareTo(second.getTeacherName());
    }

}
