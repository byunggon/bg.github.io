package day14.zoo;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("밍키", "개");
        Animal cat = new Cat("나비", "고양이");

        Zoo groomZoo = new Zoo();

        Animal[] animals = {dog, cat};
        groomZoo.allSpeak(animals);
        }

}
