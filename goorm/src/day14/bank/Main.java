package day14.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount b = new BankAccount("kang", "352");
        BankAccount c = new BankAccount("kim", "123");
        b.deposit(10000);
        b.transfer(c, 5000);

        c.showInfo();
    }
}
