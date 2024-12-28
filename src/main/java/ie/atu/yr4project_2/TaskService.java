package ie.atu.yr4project_2;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    private UserRepository userRepository;

    public TaskService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<Task> getTasks(){
        return userRepository.findAll();
    }

    public List<Task> createTask(Task task){
        userRepository.save(task);
        return userRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find product."));
    }

    public Task updateTask(Long id, Task updatedTask){
        Task existingTask = findTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setPriority(updatedTask.getPriority());
        return userRepository.save(existingTask);

    }

    public List<Task> deleteTask(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }


        return null;


    }
}
