package day14.bank;

public class BankAccount {

    String owner;
    String accountNumber;
    int balance;

    public BankAccount(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + "원 입금. 잔액: " + balance + "원");
        }
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액 부족! 현재 잔액: " + balance + "원");
        } else {
            balance -= amount;
            System.out.println(amount + "원 출금. 잔액: " + balance + "원");
        }
    }

    public void transfer(BankAccount target, int amount) {
        if (amount > balance) {
            System.out.println("잔액 부족으로 이체 실패");
        } else {
            this.balance -= amount;
            target.balance += amount;
            System.out.println(target.owner + "에게" + amount + "원 이체 완료");
        }
    }

    public void showInfo() {
        System.out.println("계좌: " + accountNumber + " |소유자: " + owner + " | 잔액: " + balance + "원");
    }
}
