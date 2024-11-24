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
        User.UserBuilder  user = User.builder();
        applyIfNotNull(userDto.getId(), user::userId);
        applyIfNotNull(userDto.getFirstName(), user::firstName);
        applyIfNotNull(userDto.getLastName(), user::lastName);
        applyIfNotNull(userDto.getEmail(), user::email);
        applyIfNotNull(userDto.getImageURL(), user::imageURL);
        applyIfNotNull(userDto.getPosition(), user::position);
        applyIfNotNull(userDto.getInfo(), user::info);

        return user.build();
    }

    public static void updateUserEntity(User existingUser, UserDto userDto) {
        applyIfNotNull(userDto.getFirstName(), existingUser::setFirstName);
        applyIfNotNull(userDto.getLastName(), existingUser::setLastName);
        applyIfNotNull(userDto.getEmail(), existingUser::setEmail);
        applyIfNotNull(userDto.getImageURL(), existingUser::setImageURL);
        applyIfNotNull(userDto.getPosition(), existingUser::setPosition);
        applyIfNotNull(userDto.getInfo(), existingUser::setInfo);

    }

    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .imageURL(user.getImageURL())
                .position(user.getPosition())
                .info(user.getInfo())
                .build();
    }
}
