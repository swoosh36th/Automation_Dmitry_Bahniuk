package lecture20.entity.response;

import lombok.Data;

@Data
public class UserResponse {
    String name;
    String job;
    String id;
    String createdAt;
}
