package example.bulletjournal.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberSignUpDto {

    // email 회원가입시 사용할 dto

    private String email;
    private String password;
    private String nickname;
    private int age;
    private String city;

}
