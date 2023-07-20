package ex03_Soldier;

public class Soldier {

  private Gun gun;
  
/*1*/  public Soldier(Gun gun) {
       this.gun = gun;
       }
  
/*2*/  public Soldier(int bullet) {
       gun = new Gun(bullet);
       }
  
  public void reload(int bullet) {
    gun.reload(bullet);
  }
  
  public void shoot() {
    gun.shoot();
  }
}
