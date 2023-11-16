package todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import gtodo.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpa")
@Primary
public class TodoJPAService implements TodoService{

    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<ToDoList> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        } else {
            throw new ResourceNotFoundException("ToDo", id);
        }
    }

    @Override
    public Todo create(Todo newTodo) {
        if(todoRepository.existsById(newTodo.getId())){
            throw new ResourceAlreadyExistsException("Todo",newTodo.getId());
        }
        else {
            return commentaireRepository.save(newCom);
        }
    }

    @Override
    public void update(Long id, Todo updatedTodo) {
        if(todoRepository.existsById(id)){
            throw new ResourceNotFoundException("Todo",id);
        }
        else {
            todoRepository.save(updatedTodo);
        }
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}