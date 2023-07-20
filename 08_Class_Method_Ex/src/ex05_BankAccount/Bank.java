package ex05_BankAccount;

public class Bank {

  private String bankName;
  private String bankTel;
  
  public Bank(String bankName, String bankTel) {
    this.bankName = bankName;
    this.bankTel = bankTel;
  }
  
  // Setter
//  public void setBankName(String bankName) {
//    this.bankName = bankName;
//  }
//  public void setBankTel(String bankTel) {
//    this.bankTel = bankTel;
//  }
  
  public void info() {
    System.out.println(bankName + "(" + bankTel + ")");
  }
  
}
