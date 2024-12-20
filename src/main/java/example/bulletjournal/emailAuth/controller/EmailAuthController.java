package example.bulletjournal.emailAuth.controller;

import example.bulletjournal.dto.ResultDTO;
import example.bulletjournal.emailAuth.dto.EmailAuthDto;
import example.bulletjournal.emailAuth.service.EmailAuthService;
import example.bulletjournal.enums.ApiResponseCode;
import example.bulletjournal.enums.CustomExceptionCode;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.member.dto.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/emailAuth")
public class EmailAuthController {

    private final EmailAuthService emailAuthService;

    @PostMapping("/sendEmail")
    public ResponseEntity<ResultDTO> sendEmail(@RequestBody Map<String, String> emailData) {
        String email = emailData.get("email");
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body(ResultDTO.of(false, "Email is required", "이메일을 입력해주세요.", null));
        }
        try {
            Map<String, String> response = emailAuthService.sendEmail(email);
            return ResponseEntity.ok(ResultDTO.of(true, ApiResponseCode.SUCCESS.getCode(), "인증 이메일 전송 완료", response));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus())
                    .body(ResultDTO.of(false, e.getCustomErrorCode().getStatusCode(), e.getDetailMessage(), null));
        }
    }

    @PostMapping("/verifyCode")
    public ResponseEntity<ResultDTO> verifyCode(@RequestBody EmailAuthDto emailAuthDto) {
        try {
            EmailAuthDto response = emailAuthService.emailCheck(emailAuthDto);
            return ResponseEntity.ok(ResultDTO.of(true, ApiResponseCode.SUCCESS.getCode(), "이메일 인증 완료", response));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus())
                    .body(ResultDTO.of(false, e.getCustomErrorCode().getStatusCode(), e.getDetailMessage(), null));
        }
    }




}
