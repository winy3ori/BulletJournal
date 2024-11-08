package example.bulletjournal.member.entity;

import example.bulletjournal.enums.Role;
import example.bulletjournal.enums.SocialType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@Table(name = "Member")
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String email;
    private String password;
    private String nickname;
    private String imageUrl;
    private int age;
    private String city;

    @Enumerated(EnumType.STRING)    //todo DB에 값 문자열로 저장
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType; // KAKAO, NAVER, GOOGLE

    private String socialId;    // 로그인한 소셜 타입 식별자 값 (jwt 로그인 = null)
    private String refreshToken;

    public void authorizeUser() {   // 유저 권한 설정 메서드
        this.role = Role.USER;
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

}
