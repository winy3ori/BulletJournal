package example.bulletjournal.todo.entity;

import example.bulletjournal.enums.TodoPriority;
import example.bulletjournal.enums.TodoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
@Builder
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    private Long memberId;

    private String title;
    private String description;
    private TodoType type;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  // LocalDateTime 포맷
    private LocalDateTime date;

    private TodoPriority priority;
}