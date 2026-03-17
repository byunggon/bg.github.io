package day14.student;

public class StudentMain {
    public static void main(String[] args) {
        int[] emptyScores = new int[3];
        Student a = new Student("강병곤", 20132674, emptyScores);
        a.setScores(100, 100, 100);

        a.getTotal();
        a.getAverage();

        a.printReport();
    }
}
