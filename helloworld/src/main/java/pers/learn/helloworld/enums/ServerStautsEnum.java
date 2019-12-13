package pers.learn.helloworld.enums;

public enum ServerStautsEnum {
    SUCCESS("SUCCESS", "SUCCESS"),
    SERVER_ERROR("SERVER_ERROR", "服务器开小差");

    private String statusCode;

    private String description;

    ServerStautsEnum(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }
}
