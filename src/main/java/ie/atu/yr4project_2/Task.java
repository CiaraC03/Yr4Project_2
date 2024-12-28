package ie.atu.yr4project_2;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title can't be blank")
    private String title;
    @NotBlank(message = "Description can't be blank")
    private String description;
    @FutureOrPresent(message = "Date cannot be in the past")
    private LocalDateTime dueDate;
    @NotBlank(message = "Priority can't be blank")
    private int priority;
}
