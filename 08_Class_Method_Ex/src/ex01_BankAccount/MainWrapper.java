package ex01_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {

    // BankAccount my 객체 선언 & 생성
    BankAccount my = new BankAccount();
    
    // my 객체에 계좌번호 등록하기
    my.setAccNO("012-34-5678-999");
  
    // my 객체에 입금하기
    my.deposit(50000);
  
    // my 객체에 출금하기
    my.withdrawal(10000);
    
    // my 객체 조회하기
    my.inquiry();
    
    // BankAccount you 객체 선언 & 생성
    BankAccount you = new BankAccount();
    
    // you 객체에 계좌번호 등록하기
    you.setAccNO("111-11-1111-111");
    
    // my 에서 you로 30000원 이체하기
    my.transfer(you, 30000);
  
    // my, you 객체 조회하기
    my.inquiry();  // 통장잔액이 10000원
    you.inquiry(); // 통장잔액이 30000원
  }

}
