package example.bulletjournal.enums;

import org.springframework.http.HttpStatus;

public enum CustomExceptionCode {

    // Todo
    NOT_FOUND_TODO("NOT_FOUND_TODO", "TODO를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),

    // Member
    NOT_FOUND_MEMBER("NOT_FOUND_MEMBER", "사용자를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATED_NICKNAME("DUPLICATED_NICKNAME", "이미 존재하는 닉네임입니다.", HttpStatus.BAD_REQUEST),

    //Email 인증
    DUPLICATED_EMAIL("DUPLICATED_EMAIL", "이미 존재하는 이메일입니다.", HttpStatus.BAD_REQUEST),

    UNAUTHORIZED_USER("UNAUTHORIZED_USER", "권한이 없는 사용자입니다.", HttpStatus.BAD_REQUEST),
    EXPIRED_JWT("EXPIRED_JWT","만료된 토큰입니다.", HttpStatus.BAD_REQUEST),
    PAYMENT_EXPIRED_JWT("PAYMENT_EXPIRED_JWT", "만료된 결제 토큰입니다.", HttpStatus.BAD_REQUEST),
    INVALID_JWT("INVALID_JWT", "올바른 형식의 토큰이 아닙니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_EMAIL("NOT_FOUND_EMAIL", "이메일을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_REPLIES("NOT_FOUND_REPLIES", "댓글을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND("NOT_FOUND","해당 정보를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_BOARD("NOT_FOUND","해당 게시글을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),
    SERVER_ERROR("SERVER_ERROR", "요청중 서버 문제가 발생했습니다.", HttpStatus.BAD_REQUEST),
    DUPLICATED("DUPLICATED","중복된 정보가 존재합니다.", HttpStatus.BAD_REQUEST),
    SAME_NICKNAME("DUPLICATED_NICKNAME","이미 같은 닉네임을 사용중입니다.", HttpStatus.BAD_REQUEST),
    DIFFERENT_PASSWORD("DIFFERENT_PASSWORD","잘못된 비밀번호입니다.", HttpStatus.BAD_REQUEST),
    CHARACTER_LIMIT("CHARACTER_LIMIT", "글자 수 제한", HttpStatus.BAD_REQUEST),
    INACTIVE_USER("INACTIVE_USER", "비활성화 된 회원입니다.", HttpStatus.BAD_REQUEST),
    DEACTIVATED_USER("DEACTIVATED_USER", "탈퇴한 회원입니다.", HttpStatus.BAD_REQUEST),
    BANNED_USER("BANNED_USER", "관리자에 의해 정지된 회원입니다.", HttpStatus.BAD_REQUEST),


    //메일 인증
    DUPLICATED_MEMBER("DUPLICATED_MEMBER", "이미 존재하는 회원", HttpStatus.BAD_REQUEST),
    VERIFIED_MEMBER("VERIFIED_MEMBER", "이미 인증이 완료된 회원", HttpStatus.BAD_REQUEST),
    INVALID_AUTH("INVALID_AUTH", "유효하지 않은 인증", HttpStatus.BAD_REQUEST),
    EXPIRED_AUTH("EXPIRED_AUTH", "만료된 인증", HttpStatus.BAD_REQUEST),
    NOT_COMPLETE_AUTH("NOT_COMPLETE_AUTH","인증이 완료되지 않음", HttpStatus.BAD_REQUEST),
    NOT_FOUND_CLUB("NOT_COMPLETE_CLUB","존재하지 않는 모임입니다.", HttpStatus.BAD_REQUEST),
    INVALID_VERIF_CODE("NOT_COMPLETE_AUTH","유효하지않은 인증번호", HttpStatus.BAD_REQUEST);




    // 추후에 추가될 다른 업로드 타입들

    private final String statusCode;
    private final String statusMessage;

    // 추가: HttpStatus 열거 값을 저장할 필드
    private final HttpStatus httpStatus;

    CustomExceptionCode(String statusCode, String statusMessage, HttpStatus httpStatus) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.httpStatus = httpStatus; // HttpStatus를 생성자로 받아서 저장
    }
    public String getStatusCode() {
        return statusCode;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}