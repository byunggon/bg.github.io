package day14.student;

public class Student {
    String name;
    int studentId;
    int[] scores;

    public Student(String name, int studentId, int[] scores) {
        this.name = name;
        this.studentId = studentId;
        this.scores = new int[3];
    }

    public void setScores(int korean, int english, int math) {
        scores[0] = korean;
        scores[1] = english;
        scores[2] = math;
    }

    public int getTotal(){
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }
        return sum;
    }

    public double getAverage() {
        return (double)getTotal() / scores.length;
    }

    public void printReport() {
        System.out.println("=== 성적표 ===");
        System.out.println("학번: " + studentId);
        System.out.println("이름: " + name);
        System.out.println("국어: " + scores[0] + ", 영어: " + scores[1] + ", 수학: " + scores[2]);
        System.out.println("총점: " + getTotal() + ", 평균: " + String.format("%.1f", getAverage()));
    }
}
