package ex04_text_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrapper {

  public static void ex01() {
    
    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    
    // 파일 객체
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    File file = new File(dir, "alphabet.txt");
 
    // 버퍼출력스트림 생성 (close가 필요없는 try - catch - resources)
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      
      // 알파벳 순차적으로 하나씩 저장
      for(char ch = 'A'; ch <= 'Z'; ch++) {
        writer.write(ch);
      }
      
      // 버퍼출력스트림에 (혹시) 남아 있는 모든 데이터를 보내기
      writer.flush();
    
      // 결과 메시지
      System.out.println(file.getPath() + " 파일 생성 완료");
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    /* 내풀이
    FileWriter fw = null;
    
    try {
      
      fw = new FileWriter(file);
      char[] cbuf = new char[26];
      for(int i = 0; i < cbuf.length; i++) {
        cbuf[i] = (char)(65 + i);
      }
      fw.write(cbuf);
      
      System.out.println(file.getPath() + "생성 완료");
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fw != null) fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    */
    
  }
  
  public static void ex02() {
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    
    //원본파일입력
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    File src = new File(dir, "alphabet.txt");
    
    //카피파일출력
    File cp = new File(dir, "alphabet2.txt");
    
    // try - catch - resources
    try (BufferedReader br = new BufferedReader(new FileReader(src)); 
         BufferedWriter bw = new BufferedWriter(new FileWriter(cp))){
      
      // 복사 단위 5 char
      char[] cbuf = new char[5];
      
      // 실제로 읽은 char 수
      int readChar = 0;
      
      // 복사
      while((readChar = br.read(cbuf)) != -1) {
        bw.write(cbuf, 0, readChar);
      }
      
      System.out.println(cp.getPath() + " 파일 생성 완료");
      
    } catch(IOException e) {
      e.printStackTrace();
    }
    
    
    /* 내풀이
    FileReader fr = null;
    FileWriter fw = null;
    
    try {
      // 원본 입력
      fr = new FileReader(src);
      
      // 카피 출력
      fw = new FileWriter(cp);
      
      int ch = 0;
      StringBuffer sb = new StringBuffer();
      
      while((ch = fr.read()) != -1 ) {
        sb.append((char)ch);
      }
      fw.write(sb.toString());
      
      System.out.println(src.getPath() + " >>> " + cp.getPath() + " 복사 완료");
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fw != null) fw.close();
        if(fr != null) fr.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
    */
    
    
    
    
    
  }
  
  public static void main(String[] args) {
//    ex01();
    ex02();
  }

}
