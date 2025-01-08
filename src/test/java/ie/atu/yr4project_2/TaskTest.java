package ie.atu.yr4project_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Mock
    private TaskClient taskClient;

    @BeforeEach
    void setUp(){
        User mockUser = new User();
        mockUser.setUserId(321L);
        when(taskClient.getUserId(321L)).thenReturn(mockUser);

    }

    @Test
    void testTitleForExistingTask() {
        Task task = new Task(321L, "", "To do", "2025-01-10", 3);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> taskService.createTask(task));
        assertEquals("Title can't be blank", iae.getMessage());
    }
    @Test
    void testDescriptionForExistingTask() {
        Task task = new Task(321L, "Title", "", "2025-01-10", 3);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> taskService.createTask(task));
        assertEquals("Description can't be blank", iae.getMessage());
    }

}
