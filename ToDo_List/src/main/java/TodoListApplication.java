package todo;

import geiffel.da4.issuetracker.user.Fonction;
import todo.Todo;
import todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoListApplication {

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpBDD() {
        return (args) -> {
            List<Todo> todos = new ArrayList<>(){{
                add(new Todo(1L, "Task1", true, "27-06-06"));
                add(new User(2L, "T&ask2", false, "27-06-06"));
                add(new User(3L, "Task3", false, "27-06-07"));
            }};
            todoRepository.saveAll(todos);
        };
    }
}
