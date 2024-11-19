package example.bulletjournal.member.controller;

import example.bulletjournal.dto.ResultDTO;
import example.bulletjournal.enums.ApiResponseCode;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.member.dto.MemberSignUpDto;
import example.bulletjournal.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<ResultDTO> signUp(@RequestBody MemberSignUpDto memberSignUpDto) {
        try {
            MemberSignUpDto result = memberService.signUp(memberSignUpDto);
            return ResponseEntity.ok(ResultDTO.of(true, ApiResponseCode.SUCCESS.getCode(), "회원가입 완료", result));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus())
                    .body(ResultDTO.of(false, e.getCustomErrorCode().getStatusCode(), e.getDetailMessage(), null));
        }
    }

}
