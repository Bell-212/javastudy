package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainWrapper {

  public static void main(String[] args) {

    // 문제. 공공데이터포털(data.go.kr)에서 "한국전력공사_전기차 충전소 운영정보" API를 신청하고
    // 결과를 "C:/storage/한국전력공사_전기차_충전소_운영정보.xml"로 저장하시오
    
    // 요청주소 : http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList
    // 인증키   : KeHBDGqZllkSEUA+HrQ9IZ1rLNijXRak02nbKxdKpgXN2Zirzlb8qNKgCJXX4BYyO7oIw//1dt9hMawk07+pAA==
    
    // 선언부
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;
    // 스펙, 요청변수 생성
    // 요청변수 연결(필요시 인코딩)
    // 연결된 요청변수(url)로 접속
    // 접속여부 reponseCode로 확인
    // 입력스트림으로 읽기(String)
    // String을 nextLine으로 읽고 저장
    // 디렉터리,파일 생성
    // 출력 스트림으로 저장된 내용 파일에 출력
    try {
      String spec = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList";
      String serviceKey = "KeHBDGqZllkSEUA+HrQ9IZ1rLNijXRak02nbKxdKpgXN2Zirzlb8qNKgCJXX4BYyO7oIw//1dt9hMawk07+pAA==";
      String pageNo = "1";
      String numOfRows = "10";
      String addr = "전라남도 나주시 빛가람동 120";
      
      StringBuilder sb = new StringBuilder();
      sb.append(spec);
      sb.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
      sb.append("&pageNo=").append(URLEncoder.encode(pageNo, "UTF-8"));
      sb.append("&numOfRows=").append(URLEncoder.encode(numOfRows, "UTF-8"));
      sb.append("&addr=").append(URLEncoder.encode(addr, "UTF-8"));
      
      url = new URL(sb.toString());
      con = (HttpURLConnection) url.openConnection();
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sbuf = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sbuf.append(line + "\n");
      }
      
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, "한국전력공사_전기차_충전소_운영정보.xml");
      writer = new BufferedWriter(new FileWriter(file));
      writer.write(sbuf.toString());
      
      System.out.println(file.getPath() + " 파일 생성 완료");
      
    } catch(UnsupportedEncodingException e) {
      System.out.println(e.getMessage());
    } catch(MalformedURLException e) {
      System.out.println(e.getMessage());
    } catch(IOException e) {
      System.out.println(e.getMessage());
    } catch(RuntimeException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(writer != null) writer.close();
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  } // main

}
