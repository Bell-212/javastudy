package ex03_Bus;

public class MainWrapper {

  public static void main(String[] args) {

    Bus bus = new Bus();
    
    bus.getOn(1, new Person("고길동"));    // 첫 좌석
    bus.getOn(25, new Student("노길동"));  // 마지막 좌석
    bus.getOn(25, new Student("도길동"));  // 오류 메시지 출력
    bus.getOn(30, new Student("로길동"));  // 오류 메시지 출력
    
    bus.getOff(1);
    bus.getOff(10); // 오류 메시지 출력
    bus.getOff(30); // 오류 메시지 출력
    
    bus.info(); // 전체 좌석 출력
    
    
    
    
  }

}
