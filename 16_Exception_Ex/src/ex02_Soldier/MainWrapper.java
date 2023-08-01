package ex02_Soldier;

public class MainWrapper {

  public static void main(String[] args) throws RuntimeException{    // main이 예외를 던지면 Java가 예외처리한다.
    Gun gun = new Gun(0);
    Soldier s = new Soldier(gun);
      s.reload(6); // 20발이 장전되었습니다. 현재 50발이 들어있습니다.
      for(int n = 0; n < 50; n++) {
        s.shoot();
      }
  }

}
