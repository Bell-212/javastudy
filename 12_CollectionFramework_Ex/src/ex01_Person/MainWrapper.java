package ex01_Person;

import java.util.ArrayList;
import java.util.List;

public class MainWrapper {

  public static void main(String[] args) {

    List<Person> family = new ArrayList<Person>();
    
    // 가족 모두 저장하고 for문으로 돌려보기
    family.add(new Person("철수", 50));
    family.add(new Person("영희", 45));
    
    for(int i = 0, length = family.size(); i < length; i++) {
      System.out.println(family.get(i)); // Person의 toString()이 동작
      System.out.println("이름: " + family.get(i).getName());
      System.out.println("나이: " + family.get(i).getAge());
    }
    
    
  }

}
