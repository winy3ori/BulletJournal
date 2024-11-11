package example.bulletjournal.emailAuth.service;

import example.bulletjournal.emailAuth.dto.EmailAuthDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmailAuthService {
    Map<String, String> sendEmail(String email);


    EmailAuthDto emailCheck(EmailAuthDto emailAuthDto);
}
