package ex05_BankAccount;

public class BankMember {
  
  // field
  private BankAccount acc;
  private String custName;
  
  // constructor
  public BankMember(String custName, BankAccount acc) {
    this.custName = custName;
    this.acc = acc;
  }
  
  public BankMember() {
    
  }
  // Setter
  public void setCustName(String custName) {
    this.custName = custName;
  }
  public void setAcc(BankAccount acc) {
    this.acc = acc;
  }
  
  // Getter
  public String getCustName() {
    return custName;
  }
  public BankAccount getAcc() {
    return acc;
  }
  
  // method
  public void info() {
    System.out.println("고객명: " + custName);
    acc.info();
  }
  
  // 입금
  public void deposit(long money) {
    acc.deposit(money);
  }
  
  // 출금
  public long withdrawal(long money) {
    return acc.withdrawal(money);
  }
  
  // 이체
  public void transfer(BankMember member, long money) {
    member.deposit(withdrawal(money));
  }
  
}
