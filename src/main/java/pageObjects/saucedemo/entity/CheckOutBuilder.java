package pageObjects.saucedemo.entity;

public class CheckOutBuilder {
    private String firstName;
    private String lastName;
    private String zipCode;

    public static class Builder {
        private CheckOutBuilder checkOutBuilder;

        public Builder withFirstName(String firstName) {
            checkOutBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            checkOutBuilder.lastName = lastName;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            checkOutBuilder.zipCode = zipCode;
            return this;
        }

        public Builder() {
            this.checkOutBuilder = new CheckOutBuilder();
        }

        public CheckOutBuilder build() {
            return checkOutBuilder;
        }

    }

    @Override
    public String toString() {
        return "CheckOutBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
