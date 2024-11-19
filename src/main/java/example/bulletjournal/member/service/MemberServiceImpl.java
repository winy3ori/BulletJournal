package example.bulletjournal.member.service;

import example.bulletjournal.emailAuth.entity.EmailAuth;
import example.bulletjournal.emailAuth.repository.EmailAuthRepository;
import example.bulletjournal.enums.CustomExceptionCode;
import example.bulletjournal.enums.EmailAuthStatus;
import example.bulletjournal.enums.Role;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.member.dto.MemberSignUpDto;
import example.bulletjournal.member.entity.Member;
import example.bulletjournal.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final EmailAuthRepository emailAuthRepository;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;


    @Override
    public MemberSignUpDto signUp(MemberSignUpDto memberSignUpDto) {

            // 이메일 인증 여부 확인
            EmailAuth emailAuth = emailAuthRepository.findByEmail(memberSignUpDto.getEmail())
                    .orElseThrow(() -> new CustomException(CustomExceptionCode.NOT_COMPLETE_AUTH));

            if (!emailAuth.getEmailAuthStatus().equals(EmailAuthStatus.VERIFIED)) {
                throw new CustomException(CustomExceptionCode.NOT_COMPLETE_AUTH);
            }

            // 이메일 중복 체크
            if (memberRepository.findByEmail(memberSignUpDto.getEmail()).isPresent()) {
                throw new CustomException(CustomExceptionCode.DUPLICATED_EMAIL);
            }

            String password = passwordEncoder.encode(memberSignUpDto.getPassword());

            Member member = Member.builder()
                    .email(memberSignUpDto.getEmail())
                    .password(password)
                    .username(memberSignUpDto.getUsername())
                    .role(Role.USER)
                    .build();

            // 멤버 저장
            memberRepository.save(member);


            return memberSignUpDto;
    }


}