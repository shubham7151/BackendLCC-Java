package uk.co.LCC_Leeds.Backend_core.service;

import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.entity.User;
import uk.co.LCC_Leeds.Backend_core.exception.ResourceNotFound;

public interface IUserService {

    /**
     *
     * @param userDto : userDto Object
     */
    UserDto createUser(UserDto userDto);

    Long updateUser(UserDto userDto, Long id) throws ResourceNotFound;

    UserDto fetchUser(Long id) throws ResourceNotFound;

    Long deleteUser(UserDto userDto) throws ResourceNotFound;
}
