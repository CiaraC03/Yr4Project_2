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

    private TaskClient taskClient;


    public TaskService(TaskRepository taskRepository, TaskClient taskClient)
    {
        this.taskRepository = taskRepository;
        this.taskClient = taskClient;

    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public List<Task> createTask(Task task){
        User user = taskClient.getUserId(task.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User with userId " + task.getUserId() + " does not exist.");
        }
        validateTask(task);
        taskRepository.save(task);
        return taskRepository.findAll();
    }

    public Task findTaskById(Long userId) {
        return taskRepository.findByUserId(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find product."));
    }

    public Task updateTask(Long userId, Task updatedTask){
        Task existingTask = findTaskById(userId);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setPriority(updatedTask.getPriority());
        return taskRepository.save(existingTask);

    }

    public List<Task> deleteTask(Long userId) {
        if(taskRepository.existsById(userId)){
            taskRepository.deleteById(userId);
        }


        return null;

    }

    private void validateTask(Task task){
        if (task.getTitle() == null || task.getTitle().isEmpty()){
            throw new IllegalArgumentException("Title can't be blank");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()){
            throw new IllegalArgumentException("Description can't be blank");
        }

    }
}
