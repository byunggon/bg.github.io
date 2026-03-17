package day14.zoo;

public class Zoo {
    public void allSpeak(Animal[] animals) {
        for (Animal animal : animals) {
            animal.speak();
        }
    }
}
