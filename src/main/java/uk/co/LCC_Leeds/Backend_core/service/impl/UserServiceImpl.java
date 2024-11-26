package uk.co.LCC_Leeds.Backend_core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.entity.User;
import uk.co.LCC_Leeds.Backend_core.exception.ResourceNotFound;
import uk.co.LCC_Leeds.Backend_core.mapper.UserMapper;
import uk.co.LCC_Leeds.Backend_core.repository.UserRepository;
import uk.co.LCC_Leeds.Backend_core.service.IUserService;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements IUserService {


    private UserRepository userRepository;
    /**
     *
     * @param userDto : userDto Object
     */
    @Override
    public UserDto createUser(UserDto userDto) {
    User user = UserMapper.toUserEntity(userDto);
    User createdUser = userRepository.save(user);
    return UserMapper.toUserDto(createdUser);
    }


    /**
     * @param userDto : Use Dto
     * @param id      : Long userId
     * @return UpdatedUser
     * @throws ResourceNotFound Resource not found
     */
    @Override
    public Long updateUser(UserDto userDto, Long id) throws ResourceNotFound {

        /*
            update should be done to existing user rather than creating new user and saving it.
         */
        User existingUser = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("User", "id", id.toString())
        );
        UserMapper.updateUserEntity(existingUser, userDto);
        User updatedUser = userRepository.save(existingUser);
        return updatedUser.getUserId();
    }

    @Override
    public UserDto fetchUser(Long id) throws ResourceNotFound {
      User user =  userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("User", "id", id.toString())
        );
        return UserMapper.toUserDto(user);
    }

    @Override
    public Long deleteUser(UserDto userDto) throws ResourceNotFound {
        User user = userRepository.findById(userDto.getId()).orElseThrow(
                ()-> new ResourceNotFound("User", "id", userDto.getId().toString())
        );
        userRepository.deleteById(user.getUserId());
        return userDto.getId();
    }


}
