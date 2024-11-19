package example.bulletjournal.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberSignUpDto {

    // email 회원가입시 사용할 dto

    private String email;
    private String password;

    private String username;

}
