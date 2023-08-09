package ex04_delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connect.DB_Connect;
import dto.UserDto;

public class MainWrapper {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("삭제할 USER_NO >>> ");
    int user_no = sc.nextInt();
    sc.close();
    
    UserDto user = new UserDto();
    user.setUser_no(user_no);
    
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      con = DB_Connect.getConnection();
      
      String sql = "";
      sql += "DELETE FROM USER_T";
      sql += " WHERE USER_NO = ?";
      
      ps = con.prepareStatement(sql);
      
      ps.setInt(1, user_no);
      
      int insertResult = ps.executeUpdate();
      
      System.out.println(insertResult + "개 행이 삭제되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(ps != null) ps.close();
        if(con != null) con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }

}
