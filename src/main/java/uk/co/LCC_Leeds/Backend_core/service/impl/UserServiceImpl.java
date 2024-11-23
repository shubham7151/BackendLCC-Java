package uk.co.LCC_Leeds.Backend_core.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.entity.User;
import uk.co.LCC_Leeds.Backend_core.exception.ResourceNotFound;
import uk.co.LCC_Leeds.Backend_core.mapper.UserMapper;
import uk.co.LCC_Leeds.Backend_core.repository.UserRepository;
import uk.co.LCC_Leeds.Backend_core.service.IUserService;

import java.util.Optional;

@Service
@AllArgsConstructor
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

    @Override
    public Boolean updateUser(UserDto userDto, Long id) throws Exception {

        userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("User", "id", id.toString())
        );
        User user = UserMapper.toUserEntity(userDto);
        user.setUserId(id);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDto fetchUser(Long id) throws ResourceNotFound {
        userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("User", "id", id.toString())
        );

        Optional<User> user = userRepository.findById(id);
        return UserMapper.toUserDto(user.get());
    }


}
