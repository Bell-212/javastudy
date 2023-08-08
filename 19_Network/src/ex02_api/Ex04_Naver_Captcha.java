package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Ex04_Naver_Captcha {

  private static final String CLIENT_ID = "rjH76EEaARpAfAoMykHW";
  private static final String CLIENT_SECRET = "";
  
  private static String getKey() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      String spec = "https://openapi.naver.com/v1/captcha/nkey";
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
          
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      
      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return result;
    
  }
  
  public static String getImage() {

    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    String key = null;
    
    try {
      key = getKey();
      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;

      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      bin = new BufferedInputStream(con.getInputStream());
      
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, System.currentTimeMillis() + ".jpg");  // 중복방지를 위해 파일명을 timestamp + .jpg로 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];  // 1KB씩
      int readByte = 0;   // 실제로 읽은 바이트 수 
      while((readByte = bin.read(b)) != -1 ) {  // 실제 읽은 내용 b 에 저장됨
        bout.write(b, 0, readByte);       // b의 인덱스 0부터 readByte만큼 출력
      }
      
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return key;
    
  }
  
  private static void validInput() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
      String key = getImage();
      
      Scanner sc = new Scanner(System.in);
      System.out.println("입력 >> ");
      String value = sc.next();
      
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
     
      JSONObject obj = new JSONObject(sb.toString());
      System.out.println("응답시간: " + obj.getDouble("responseTime"));
      if(obj.getBoolean("result")) {
        System.out.println("맞습니다.");
      } else {
        System.out.println("틀렸습니다.");
      }
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  
  
  
  public static void main(String[] args) {
    validInput();
    
    
    
  } // main()

}
