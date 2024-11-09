package example.bulletjournal.emailAuth.entity;

import example.bulletjournal.enums.EmailAuthStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class EmailAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;


    private LocalDateTime regDt;
    private String email;
    private String verityCode;

    @Enumerated(EnumType.STRING)
    private EmailAuthStatus emailAuthStatus;

}
