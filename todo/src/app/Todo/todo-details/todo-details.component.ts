import {Component, Input} from '@angular/core';
import {Todo} from "../../model/Todo";
import {ActivatedRoute} from "@angular/router";
import {TodoService} from "../../services/todo.service";

@Component({
  selector: 'app-todo-details',
  templateUrl: './todo-details.component.html',
  styleUrls: ['./todo-details.component.css']
})
export class TodoDetailsComponent {

  todo!: Todo
  mode: String = "Edit"

  constructor(
    private todoService: TodoService,
    private route: ActivatedRoute ) {
    const id_todo: Number = Number(this.route.snapshot.paramMap.get("id"))
    this.todoService.getTodoById(id_todo).subscribe(todo => this.todo = todo)
  }

  changeMode(mode : String) {
    this.mode=mode;
  }

  update()
  {
    console.log("update")
    this.todoService.update(this.todo).subscribe(()=>this.changeMode('display'));
  }

  create()
  {
    console.log("create")
    this.todoService.create(this.todo).subscribe(()=>this.changeMode("display"));
  }

  delete()
  {
  console.log("delete")
  this.todoService.delete(this.todo)
  }
}

