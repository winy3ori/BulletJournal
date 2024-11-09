package example.bulletjournal.emailAuth.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmailAuthService {
    Map<String, String> sendEmail(String email);
}
