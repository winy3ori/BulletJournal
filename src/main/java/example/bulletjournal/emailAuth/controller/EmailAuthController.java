package example.bulletjournal.emailAuth.controller;

import example.bulletjournal.dto.ResultDTO;
import example.bulletjournal.emailAuth.service.EmailAuthService;
import example.bulletjournal.enums.ApiResponseCode;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.member.dto.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emailAuth")
public class EmailAuthController {

    private final EmailAuthService emailAuthService;

    @PostMapping("/sendEmail")
    public ResponseEntity<ResultDTO> sendEmail(@RequestParam String email) {
        try {
            Map<String, String> response = emailAuthService.sendEmail(email);
            return ResponseEntity.ok(ResultDTO.of(true, ApiResponseCode.SUCCESS.getCode(), "인증 이메일 전송 완료", response));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus())
                    .body(ResultDTO.of(false, e.getCustomErrorCode().getStatusCode(), e.getDetailMessage(), null));
        }
    }

}
