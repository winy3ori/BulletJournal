package example.bulletjournal.member.service;

import example.bulletjournal.enums.CustomExceptionCode;
import example.bulletjournal.enums.Role;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.member.dto.MemberSignUpDto;
import example.bulletjournal.member.entity.Member;
import example.bulletjournal.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberSignUpDto signUp(MemberSignUpDto memberSignUpDto) {
        // 이메일 중복 체크
        if (memberRepository.findByEmail(memberSignUpDto.getEmail()).isPresent()) {
            throw new CustomException(CustomExceptionCode.DUPLICATED_EMAIL);
        }

        // 닉네임 중복 체크
        if (memberRepository.findByNickname(memberSignUpDto.getNickname()).isPresent()) {
            throw new CustomException(CustomExceptionCode.DUPLICATED_NICKNAME);
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberSignUpDto.getPassword());

        // Member 엔티티 생성

        Member member = Member.builder()
                .email(memberSignUpDto.getEmail())
                .password(encodedPassword)  // 암호화된 비밀번호 사용
                .nickname(memberSignUpDto.getNickname())
                .age(memberSignUpDto.getAge())
                .city(memberSignUpDto.getCity())
                .role(Role.USER)  // 기본 역할 USER
                .build();

        memberRepository.save(member);
        return memberSignUpDto;
    }
}