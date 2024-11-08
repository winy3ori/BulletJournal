package example.bulletjournal.todo.controller;

import example.bulletjournal.dto.ResultDTO;
import example.bulletjournal.enums.ApiResponseCode;
import example.bulletjournal.exception.CustomException;
import example.bulletjournal.todo.dto.TodoDto;
import example.bulletjournal.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<ResultDTO> createTodo(@RequestBody TodoDto request) {
        try {
            TodoDto result = todoService.createTodo(request);
            return ResponseEntity.ok(ResultDTO.of(true, ApiResponseCode.SUCCESS.getCode(), "Todo 생성 완료", result));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus())
                    .body(ResultDTO.of(false, e.getCustomErrorCode().getStatusCode(), e.getDetailMessage(), null));
        }
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<ResultDTO> deleteTodo(@RequestParam Long todoId, @RequestParam Long memberId) {
        try {
            todoService.deleteTodo(todoId, memberId);
            return ResponseEntity.ok(ResultDTO.of(true, ApiResponseCode.SUCCESS.getCode(), "Todo 삭제 완료", null));
        } catch (CustomException e) {
            return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus())
                    .body(ResultDTO.of(false, e.getCustomErrorCode().getStatusCode(), e.getDetailMessage(), null));
        }
    }

}
