package example.bulletjournal.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN("ROLE_ADMIN"),
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER");

    //todo Spring Security 에서는 권한(Role) 코드에 항상 "ROLE_" 접두사가 앞에 붙어야 하기 때문에 key 필드 추가
    private final String key;

}
