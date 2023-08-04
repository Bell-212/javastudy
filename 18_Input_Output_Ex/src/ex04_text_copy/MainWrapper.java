package ex04_text_copy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrapper {

  public static void ex01() {
    
    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    File file = new File(dir, "alphabet.txt");
 
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
    
  }
  
  public static void ex02() {
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    
    //원본파일입력
    File dir1 = new File("C:/storage");
    if(dir1.exists() == false) {
      dir1.mkdirs();
    }
    File src = new File(dir1, "alphabet.txt");
    FileReader fr = null;
    
    //카피파일출력
    File dir2 = new File("C:/storage");
    File cp = new File(dir2, "alphabet2.txt");
    
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
    
    
    
    
    
    
  }
  
  public static void main(String[] args) {
//    ex01();
    ex02();
  }

}
