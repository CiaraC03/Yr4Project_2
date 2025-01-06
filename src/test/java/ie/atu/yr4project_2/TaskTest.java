package ie.atu.yr4project_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TaskTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void testNameForExistingUser() {
        Task task = new Task(1L, 321L, "", "To do", "2025-01-10T10:00:00", 3);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> taskService.createTask(task));
        assertEquals("Title cannot be blank", iae.getMessage());
    }
}
