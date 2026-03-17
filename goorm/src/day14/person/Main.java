package day14.person;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("강병곤", 32);
        Person p2 = new Person("김영희", 35);

        p1.introduce();
        p1.greet(p2.getName());
    }
}