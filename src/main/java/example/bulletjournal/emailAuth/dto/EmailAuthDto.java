package example.bulletjournal.emailAuth.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmailAuthDto {

    private String email;
    private String verifyCode;

}
