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

import java.util.Optional;

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
    public void createUser(UserDto userDto) {
    User user = UserMapper.toUserEntity(userDto);
    User savedUser =  userRepository.save(user);
    }


    /**
     * @param userDto : Use Dto
     * @param id      : Long userId
     * @return UpdatedUser
     * @throws Exception Resource not found
     */
    @Override
    public Long updateUser(UserDto userDto, Long id) throws Exception {

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


}
