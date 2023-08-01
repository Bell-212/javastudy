package ex02_Soldier;

public class Soldier {

  private Gun gun;
  
/*1*/  public Soldier(Gun gun) {
       this.gun = gun;
       }
  
/*2*/  public Soldier(int bullet) {
       gun = new Gun(bullet);
       }
  
  public void reload(int bullet) throws RuntimeException {
    gun.reload(bullet);
  }
  
  public void shoot() throws RuntimeException {
    gun.shoot();
  }
}
