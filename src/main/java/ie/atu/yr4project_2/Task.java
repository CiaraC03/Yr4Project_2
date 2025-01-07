package ie.atu.yr4project_2;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tasks")
public class Task {
    @NotNull(message = "User Id can't be blank")
    private Long userId;
    @NotBlank(message = "Title can't be blank")
    private String title;
    @NotBlank(message = "Description can't be blank")
    private String description;
    @NotBlank(message = "Date can't be blank")
    private String dueDate;
    @NotNull(message = "Priority can't be blank")
    private int priority;
}
