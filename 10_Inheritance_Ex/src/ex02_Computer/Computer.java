package ex02_Computer;

public class Computer {

  private String model;
  
  public Computer(String model) {
    this.model = model;
    System.out.println("Computer(String model) 호출");
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
}
