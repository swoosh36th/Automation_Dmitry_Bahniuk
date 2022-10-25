package pageObjects.saucedemo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@ToString
@Builder(builderClassName = "CheckOutBuilder_Lombok", setterPrefix = "with", buildMethodName = "create")
@Log4j
public class CheckOutBuilder {
    private String firstName;
    private String lastName;
    private String zipCode;

    public static class CheckOutBuilder_Lombok {
        public CheckOutBuilder_Lombok() {
        }
    }
}
