package example.bulletjournal.todo.service;

import example.bulletjournal.enums.CustomExceptionCode;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.todo.dto.TodoDto;
import example.bulletjournal.todo.entity.Todo;
import example.bulletjournal.todo.repository.TodoRepository;
import example.bulletjournal.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository userRepository;

    @Override
    public TodoDto createTodo(TodoDto request) {

        Todo newTodo = Todo.builder()
                .todoId(request.getTodoId())
                .memberId(request.getMemberId())
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
                .memberId(newTodo.getMemberId())
                .title(newTodo.getTitle())
                .description(newTodo.getDescription())
                .date(newTodo.getDate())
                .priority(newTodo.getPriority())
                .type(newTodo.getType())
                .build();
    }

    @Override
    public void deleteTodo(Long todoId, Long userId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.NOT_FOUND_TODO));

        userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(CustomExceptionCode.NOT_FOUND));

        if (!todo.getMemberId().equals(userId)) {
            throw new CustomException(CustomExceptionCode.UNAUTHORIZED_USER);
        }

        todoRepository.delete(todo);
    }
}