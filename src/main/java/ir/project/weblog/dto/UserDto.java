package ir.project.weblog.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {

    private final String username;
    private final String password;
    private final String fullName;
    private final String email;

    public UserDto(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    @NotBlank(message = "username.is.blank")
    public String getUsername() {
        return username;
    }

    @NotBlank(message = "password.is.blank")
    public String getPassword() {
        return password;
    }

    @NotBlank(message ="fullName.is.blank")
    public String getFullName() {
        return fullName;
    }

    @NotBlank(message = "email.is.blank")
    public String getEmail() {
        return email;
    }
}
