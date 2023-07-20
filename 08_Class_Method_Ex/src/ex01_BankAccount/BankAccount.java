package ex01_BankAccount;

/**
 * 입금, 출금, 계좌조회, 이체 기능을 제공하는 클래스
 * 
 * @author GDJ
 * @since 2023.07.19
 * @version 1.0
 */
public class BankAccount {

  /**
   * long balance 이 필드는 계좌 잔액을 의미한다.<br>
   * 초깃값으로 0이 저장된다.
   */
  private long balance;
  
  /**
   * String accNO 이 필드는 계좌 번호이다.<br>
   * 초깃값으로 null이 저장된다.
   */
  private String accNO;
  
  /**
   * 계좌번호와 통장잔액을 조회하는 메소드
   */
  public void inquiry() {
    System.out.println("계좌번호: " + accNO);
    System.out.println("통장잔액: " + balance + "원");
  }
  
  /**
   * 입금 메소드<br>
   * 파라미터가 0보다 작거나 같으면 동작하지 않는다.
   * @param money 입금할 금액
   */
  public void deposit(long money) {
    if(money <= 0) {
      return;
    }
    balance += money;
  }
  
  /**
   * 출금 메소드<br>
   * 파라미터가 0보다 작거나 같으면 출금된 금액이 없으므로 0을 반환한다.
   * 파라미터가 통장잔액(balance)보다 크면 출금된 금액이 없으므로 0을 반환한다. 
   * @param money 출금할 금액
   * @return  실제로 출금된 금액
   */
  public long withdrawal(long money) {
    long retVal = 0;
    if(money <= 0 || money > balance) {
      retVal = 0;
    } else {
      balance -= money;
      retVal = money;
    }
    return retVal;
  }
  
  //TODO transfer 메소드 만들기
  /**
   * 이체 메소드
   * 다른 계좌로 이체하는 메소드로 기존의 입금 메소드와 출금 메소드를 활용한다.<br>
   * 내 계좌에서 출금을 먼저 수행하고, 출금된 금액만큼 다른계좌로 입금한다.
   * @param acc   다른계좌
   * @param money 이체할 금액
   */
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money));
  }
  
  //setter
  public void setBalance(long balance) {
    this.balance = balance;
  }
  public void setAccNO(String accNO) {
    this.accNO = accNO;
  }
  
  //getter
  public long getBalance() {
    return balance;
  }
  public String getAccNO() {
    return accNO;
  }
  
}
