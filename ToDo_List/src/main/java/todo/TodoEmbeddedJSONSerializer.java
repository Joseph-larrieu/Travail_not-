package todo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import todo.Todo;

import java.io.IOException;

public class TodoEmbeddedJSONSerializer extends JsonSerializer<Todo> {

    @Override
    public void serialize(Todo todo, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("url","/ToDoList/"+todo.getId());
        gen.writeEndObject();

    }
}
