package designPatterns.lectureExampleBuilder;

public class Driver {
    private String licenseNumber;
    private String name;

    public Driver() {

    }

    public Driver(String licenseNumber, String name) {
        this.licenseNumber = licenseNumber;
        this.name = name;
    }

    public static Builder builder() {
        return new Driver().new Builder();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withLicenseNumber(String licenseNumber) {
            Driver.this.licenseNumber = licenseNumber;
            return this;
        }

        public Builder withName(String name) {
            Driver.this.name = name;
            return this;
        }

        public Driver build() {
            return Driver.this;
        }

    }

}
