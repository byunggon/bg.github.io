package day14.zoo;

public class Dog extends Animal{
    public Dog(String n, String t) {
        super(n, t);
    }

    @Override
    public void speak() {
        System.out.println("왈왈");
    }

    public void bark() {
        System.out.println("왈왈");
    }
}
