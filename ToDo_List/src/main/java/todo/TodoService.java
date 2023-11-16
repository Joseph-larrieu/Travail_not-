package todo;

import java.util.Collection;
import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    Todo getById(Long id);

    Todo create(Todo todo);

    void update(Long id, Todo todoUpdate);

    void delete(Long id);
}
