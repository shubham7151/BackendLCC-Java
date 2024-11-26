package uk.co.LCC_Leeds.Backend_core.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.co.LCC_Leeds.Backend_core.constants.UserConstants;
import uk.co.LCC_Leeds.Backend_core.dto.ErrorResponseDto;
import uk.co.LCC_Leeds.Backend_core.dto.ResponseDto;
import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.entity.User;
import uk.co.LCC_Leeds.Backend_core.exception.InvalidArgumentException;
import uk.co.LCC_Leeds.Backend_core.exception.ResourceNotFound;
import uk.co.LCC_Leeds.Backend_core.repository.UserRepository;
import uk.co.LCC_Leeds.Backend_core.service.IUserService;

@RestController
@RequestMapping(path = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserController {

    @Autowired
    private IUserService userService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto<UserDto>> createUser(@Valid @RequestBody UserDto userDto){

        UserDto user = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto<>(UserConstants.STATUS_201, UserConstants.MESSAGE_201, user));

    }

    @GetMapping("/fetch/")
    public void defaultFetchUser(@NotNull(message = "Bad Request : Missing Argument") @PathVariable Long id) throws InvalidArgumentException {
        if(id== null){
            throw new InvalidArgumentException("Bad Request : Missing Argument");
        }
    }

    @GetMapping("/fetch/{id:[0-9]+}")
    public ResponseEntity<ResponseDto<UserDto>> fetchUser(@NotNull(message = "Bad Request : Missing Argument") @PathVariable Long id) throws ResourceNotFound {
        UserDto userDto = userService.fetchUser(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<>(UserConstants.STATUS_200, UserConstants.MESSAGE_200, userDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto<Long>> updateUser(@Valid @RequestBody UserDto userDto, @NotNull(message = "Bad Request : Missing Argument") @PathVariable Long id) throws Exception {
        if(userDto == null || userDto.getIsUpdated()== null ){
            throw new InvalidArgumentException("Bad Request : Missing Argument");
        }
        Long updateId = userService.updateUser(userDto, id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<>(UserConstants.STATUS_200, UserConstants.MESSAGE_200, updateId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto<Long>> deleteUser(@Valid @RequestBody UserDto userDto ) throws InvalidArgumentException, ResourceNotFound {
        if(userDto==null || userDto.getIsDeleted()!= null ){
            throw new InvalidArgumentException("Bad Request : Missing Argument");
        }
        Long deletedId = userService.deleteUser(userDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<>(UserConstants.STATUS_200, UserConstants.MESSAGE_200, deletedId));
    }
}