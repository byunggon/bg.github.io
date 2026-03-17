package day14.person;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
    }

    public void greet(String targetName) {
        System.out.println(name + "이(가) " + targetName + "에게 인사합니다.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
