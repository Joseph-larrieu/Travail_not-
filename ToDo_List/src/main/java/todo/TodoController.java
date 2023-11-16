package todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("ToDoList")
public class TodoController {

    private TodeService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("{id}")
    public Todo getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody Todo todo) {
        Todo created = todoService.create(todo);
        return ResponseEntity.created(URI.create("/ToDoList/"+created.getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Todo todo) {
        todoService.update(id, todo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
