package pageObjects.saucedemo.entity;

public class LoginBuilder {
    private String username;
    private String password;

    public static class Builder {
        private LoginBuilder loginBuilder;

        public Builder withUserName(String username) {
            loginBuilder.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            loginBuilder.password = password;
            return this;
        }
        public Builder() {
            this.loginBuilder = new LoginBuilder();
        }

        public LoginBuilder build() {
            return loginBuilder;
        }
    }

    @Override
    public String toString() {
        return "LoginBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
