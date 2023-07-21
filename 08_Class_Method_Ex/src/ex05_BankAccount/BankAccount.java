package ex05_BankAccount;

public class BankAccount {
  
  // field
  private Bank bank;
  private String bankAcc;
  private long balance;
  
  // constructor
  public BankAccount(Bank bank, String bankAcc, long balance) {
    this.bank = bank;
    this.bankAcc = bankAcc;
    this.balance = balance;
  }
  
  public BankAccount() {
   
  }
  
  // Setter
  public void setBank(Bank bank) {
    this.bank = bank;
  }
  public void setBankAcc(String bankAcc) {
    this.bankAcc = bankAcc;
  }
  public void setBalance(long balance) {
    this.balance = balance;
  }
  
  // Getter
  public Bank getBank() {
    return bank;
  }
  public String getBankAcc() {
    return bankAcc;
  }
  public long getBalance() {
    return balance;
  }
  
  // method
  public void info() {
    System.out.println("계좌번호: " + bankAcc + ", 통장잔액: " + balance + "원");
    System.out.print("개설지점: ");
    bank.info();
  }
  
  // 입금 메소드
  public void deposit(long money) {
    if(money <= 0) {
      return;
    }
    balance += money;
  }
  
  // 출금 메소드
  public long withdrawal(long money) {
    long retVal = 0;
    if(money > 0 && money <= balance) {
      balance -= money;
      retVal = money;
    }
    return retVal;
  }
  
  // 이체 메소드
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money));
  }
  
}
