package example.bulletjournal.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TodoType {
    NOTE,
    TASK,
    EVENT;

    @JsonCreator
    public static TodoType fromValue(String value) {
        try {
            return TodoType.valueOf(value);
        } catch (IllegalArgumentException e) {
            return TodoType.TASK; // 기본값 처리
        }
    }
}