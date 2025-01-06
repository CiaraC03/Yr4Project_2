package ie.atu.yr4project_2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service", url = "${feign.user-service.url}")
public interface TaskClient {
    @GetMapping("/users/{userId}")
    String getUserById(@PathVariable Long userId);
}
