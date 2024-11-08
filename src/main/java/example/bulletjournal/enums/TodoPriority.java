package example.bulletjournal.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TodoPriority {

    HIGH,
    MEDIUM,
    LOW,
    NONE;

    @JsonCreator
    public static TodoPriority fromValue(String value) {
        try {
            return TodoPriority.valueOf(value);
        } catch (IllegalArgumentException e) {
            // 기본값 처리 (없으면 NONE을 기본값으로 설정)
            return TodoPriority.NONE;
        }
    }

}
