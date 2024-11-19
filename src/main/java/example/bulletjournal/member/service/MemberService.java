package example.bulletjournal.member.service;

import example.bulletjournal.member.dto.MemberSignUpDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    MemberSignUpDto signUp(MemberSignUpDto memberSignUpDto);


}
