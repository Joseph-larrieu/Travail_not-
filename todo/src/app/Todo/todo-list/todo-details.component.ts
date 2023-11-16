import { Component } from '@angular/core';
import {TodoService} from "../../services/todo.service";
import {Todo} from "../../model/Todo";

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {

  todo: Todo[]

  constructor(
    private todoService: TodoService
  ) {
    this.todos = []
    todoService.getTodos()
      .subscribe(todos => this.todos = todos)
  }
}
