package uk.co.LCC_Leeds.Backend_core.mapper;

import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.entity.User;

import java.util.function.Consumer;

public class UserMapper {

    private static <T> void applyIfNotNull(T value , Consumer<T> setter){
        if(value!=null){
            setter.accept(value);
        }
    }
    public static User toUserEntity(UserDto userDto){


    }

    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .imageURL(user.getImageURL())
                .position(user.getPosition())
                .info(user.getInfo())
                .build();
    }
}
