package ex04_Singer;

public class MainWrapper {

  public static void main(String[] args) {

    Song song = new Song();
    
    song.setTitle("Butterfly");
    song.setGenre("rock");
    song.setPlayTime(3.5);
    
    song.info();  // 제목: ㅇ, 장르: ㅇ, 재생시간: 3.5분
    
    Singer singer = new Singer();
    
    singer.setName("전영호");
    singer.setTitleSong(song);
    
    singer.info();  // 이름: 김흥국
                    // 제목: Butterfly, 장르: rock, 재생시간: 3.5분

    
    
    
  }

}
