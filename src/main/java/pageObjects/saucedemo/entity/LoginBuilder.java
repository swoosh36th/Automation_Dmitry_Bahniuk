package pageObjects.saucedemo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@ToString
@Builder(builderClassName = "LoginBuilder_Lombok", setterPrefix = "with", buildMethodName = "create")
@Log4j
public class LoginBuilder {
    private String username;
    private String password;

    public static class LoginBuilder_Lombok {
        public LoginBuilder_Lombok(){
        }
    }
}


