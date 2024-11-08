package example.bulletjournal.todo.service;

import example.bulletjournal.todo.dto.TodoDto;
import example.bulletjournal.todo.entity.Todo;
import example.bulletjournal.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDto createTodo(TodoDto request) {

        Todo newTodo = Todo.builder()
                .todoId(request.getTodoId())
                .userId(request.getUserId())
                .title(request.getTitle())  // 제목
                .description(request.getDescription()) // 내용
                .date(request.getDate()) // 날짜
                .priority(request.getPriority()) // 중요도
                .type(request.getType()) // 타입
                .build();

        log.info("새로운 할 일이 생성되었습니다: {}", newTodo);
        todoRepository.save(newTodo);

        return TodoDto.builder()
                .todoId(newTodo.getTodoId())
                .userId(newTodo.getUserId())
                .title(newTodo.getTitle())
                .description(newTodo.getDescription())
                .date(newTodo.getDate())
                .priority(newTodo.getPriority())
                .type(newTodo.getType())
                .build();
    }
}