package ir.project.weblog.dto;

public class ExceptionDto {
private final String message;
private final String code;

public ExceptionDto(String message, String code) {
    this.message = message;
    this.code = code;
}

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
