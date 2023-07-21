package ex05_BankAccount;

public class Bank {

  // field
  private String bankName;
  private String bankTel;
  
  // constructor
  public Bank(String bankName, String bankTel) {
    this.bankName = bankName;
    this.bankTel = bankTel;
  }

  public Bank() {
   
  }
  
  
  // Setter
  public void setBankName(String bankName) {
    this.bankName = bankName;
  }
  public void setBankTel(String bankTel) {
    this.bankTel = bankTel;
  }
  
  
  // Getter
  public String getBankName() {
    return bankName;
  }
  public String getBankTel() {
    return bankTel;
  }
  
  
  
  
  
  
  // method
  public void info() {
    System.out.println(bankName + "(" + bankTel + ")");
  }
  
}
