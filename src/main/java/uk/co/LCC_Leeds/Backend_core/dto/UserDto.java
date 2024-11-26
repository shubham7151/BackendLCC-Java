package uk.co.LCC_Leeds.Backend_core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
    @NotEmpty(message = "Missing argument : Id")
    private Long id;
    private String firstName;
    private String lastName;
    @Email(message = "Email should be valid")
    private String email;
    private String info;
    private String imageURL;
    private String position;
    @NotNull
    private Boolean isUpdated;
    @NotNull
    private Boolean isDeleted;
}
