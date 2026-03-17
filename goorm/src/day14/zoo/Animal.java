package day14.zoo;

public class Animal {
    private final String name;
    private final String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void speak() {
        System.out.println("");
    }

    public void bark() {
        System.out.println("왈왈");
    }
}
