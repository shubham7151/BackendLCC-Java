package uk.co.LCC_Leeds.Backend_core.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String info;
    private String imageURL;
    private String position;
    private Boolean isUpdated;
    private Boolean isDeleted;
}
