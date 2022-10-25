package lecture14.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@ToString
@Builder(builderClassName = "HomeBuilder", setterPrefix = "with", buildMethodName = "create")
@Log4j
public class Home {
    String doors;
    String color;
    String address;
    Integer windowCount;
    Boolean old;
    public static class HomeBuilder {
        public HomeBuilder() {
        }
    }
}
