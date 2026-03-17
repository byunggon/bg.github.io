package day14.zoo;

public class Cat extends Animal{

    public Cat(String name, String type) {
        super(name, type);
    }

    @Override
    public void speak() {
        System.out.println("냐옹");
    }
}
