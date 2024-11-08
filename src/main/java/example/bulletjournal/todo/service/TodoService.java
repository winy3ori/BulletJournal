package example.bulletjournal.todo.service;

import example.bulletjournal.todo.dto.TodoDto;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {


    TodoDto createTodo(TodoDto request);
}
