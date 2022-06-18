package webService2.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import webService2.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter             //  클래스 내 모든 필드의 Getter메소드를 자동생성
@NoArgsConstructor  //  기본 생성자 자동 추가
@Entity             //  테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity {
    @Id // 해당테이블의 PK를 타나낸다. GenerationType.IDENTITY를 함으로써 auto imcrement가 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =  500, nullable = false)    // 테이블의 컬럼을 나타내며 굳이 선언하지않아도 해당 클래스의 필드는 모두 컬림이된다.
    private String title;                       // 굳이 선언하는 이유는 기본값외에 추가로 변경이 필요한 옵션이 있을경우 사용한다.
                                                // 문자열의경우 VARCHAR(255)가 기본값인데 사이즈를 늘리거나, 타입을 변경하기위해 쓴다.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title      = title;
        this.content    = content;
        this.author     = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
