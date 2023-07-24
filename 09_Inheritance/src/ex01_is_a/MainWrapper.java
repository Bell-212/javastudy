package ex01_is_a;

public class MainWrapper {

  public static void main(String[] args) {

    // Student 객체를 선언 & 생성
    Student s = new Student();
    
    // Studend 객체 메소드 확인
    s.eat();    // 슈퍼 클래스로부터 상속 받은 메소드
    s.sleep();  // 슈퍼 클래스로부터 상속 받은 메소드
    s.study();  // 내 꺼
    
  }

}
