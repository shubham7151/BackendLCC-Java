package uk.co.LCC_Leeds.Backend_core.service;

import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.exception.ResourceNotFound;

public interface IUserService {

    /**
     *
     * @param userDto : userDto Object
     */
    void createUser(UserDto userDto);

    Boolean updateUser(UserDto userDto, Long id) throws Exception;

    UserDto fetchUser(Long id) throws ResourceNotFound;
}
