package ie.atu.yr4project_2;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public List<Task> createTask(Task task){
        taskRepository.save(task);
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find product."));
    }

    public Task updateTask(Long id, Task updatedTask){
        Task existingTask = findTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setPriority(updatedTask.getPriority());
        return taskRepository.save(existingTask);

    }

    public List<Task> deleteTask(Long id) {
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }


        return null;


    }
}
