package ex06_GameUnit;

public class GameUnit {

  private String name;
  private int hp;
  private boolean isAlive;
 
  
  public GameUnit() {
    
  }
  // new GameUnit("마린")
  public GameUnit(String name) {
    this.name = name;
  }
 
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getHp() {
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
    setAlive(hp > 0);
  }
  public boolean isAlive() {
    return isAlive;
  }
  private void setAlive(boolean isAlive) {
    this.isAlive = isAlive;
  }
  
  // 호출을 위한 attack 메소드는 실행되지 않는다.
  public void attack(GameUnit other) {
    
  }
  
  
  
  
  
}
