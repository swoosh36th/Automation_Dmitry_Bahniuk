package task_20.entity.request;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}
