package ex06_Member;

public class MainWrapper {

  public static void main(String[] args) {

    
    Address address = new Address();
    address.setPostCode("07252");
    address.setRoadAddr("새빛5길");
    address.setJibunAddr("새빛동 55");
    address.setDetailAddr("101호");
    
    Contact contact = new Contact();
    contact.setHomeTel("02-123-4567");
    contact.setMobile("010-1111-1111");
    contact.setAddress(address);
    
    
    Member member = new Member();
    member.setName("홍길동");
    member.setContact(contact);
    
    // Member member 객체 정보 확인 (Getter 활용)
    System.out.println("이름: " + member.getName());
    System.out.println("집전화: " + member.getContact().getHomeTel());
    System.out.println("모바일: " + member.getContact().getMobile());
    System.out.println("우편번호: " + member.getContact().getAddress().getPostCode());
    System.out.println("도로명: " + member.getContact().getAddress().getRoadAddr());
    System.out.println("지번: " + member.getContact().getAddress().getJibunAddr());
    System.out.println("상세주소: " + member.getContact().getAddress().getDetailAddr());
  }
  

}
