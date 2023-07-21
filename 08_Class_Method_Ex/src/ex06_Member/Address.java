package ex06_Member;

public class Address {

  // field
  private String postCode;
  private String roadAddr;
  private String jibunAddr;
  private String detailAddr;
  
  // constructor
  // 디폴트생성자 자동생성
  
  // Setter
  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
  public void setRoadAddr(String roadAddr) {
    this.roadAddr = roadAddr;
  }
  public void setJibunAddr(String jibunAddr) {
    this.jibunAddr = jibunAddr;
  }
  public void setDetailAddr(String detailAddr) {
    this.detailAddr = detailAddr;
  }
  
  // Getter
  public String getPostCode() {
    return postCode;
  }
  public String getRoadAddr() {
    return roadAddr;
  }
  public String getJibunAddr() {
    return jibunAddr;
  }
  public String getDetailAddr() {
    return detailAddr;
  }
  
  // method
}
