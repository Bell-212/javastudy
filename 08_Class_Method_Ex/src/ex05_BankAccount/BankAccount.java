package ex05_BankAccount;

public class BankAccount {
  
  private Bank bank;
  private String bankAcc;
  private long balance;
  
  public BankAccount(Bank bank, String bankAcc, long balance) {
    this.bank = bank;
    this.bankAcc = bankAcc;
    this.balance = balance;
  }
  
  public void info() {
    System.out.println("계좌번호: " + bankAcc + ", 통장잔액: " + balance);
    bank.info();
  }
  
}
