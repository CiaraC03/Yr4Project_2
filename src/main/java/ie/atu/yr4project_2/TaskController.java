package ie.atu.yr4project_2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private List<Task> taskList = new ArrayList<>();

    private TaskService taskService;
    private TaskClient taskClient;

    @Autowired
    public TaskController(TaskService taskService, TaskClient taskClient){
        this.taskService = taskService;
        this.taskClient = taskClient;
    }

    @GetMapping("tasks")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @PostMapping("/newTask")
    public ResponseEntity<List<Task>> createTask(@Valid @RequestBody Task task){
        taskList = taskService.createTask(task);
        return ResponseEntity.ok(taskList);
    }

    @PutMapping("/updateTasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task update = taskService.updateTask(id, updatedTask);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<List<Task>> deleteTask(@PathVariable Long id) {
        List<Task> taskList = taskService.deleteTask(id);
        return ResponseEntity.ok(taskList);
    }



}
