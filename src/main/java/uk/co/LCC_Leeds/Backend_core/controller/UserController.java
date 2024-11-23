package uk.co.LCC_Leeds.Backend_core.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.LCC_Leeds.Backend_core.constants.UserConstants;
import uk.co.LCC_Leeds.Backend_core.dto.ResponseDto;
import uk.co.LCC_Leeds.Backend_core.dto.UserDto;
import uk.co.LCC_Leeds.Backend_core.exception.InvalidArgumentException;
import uk.co.LCC_Leeds.Backend_core.exception.ResourceNotFound;
import uk.co.LCC_Leeds.Backend_core.repository.UserRepository;
import uk.co.LCC_Leeds.Backend_core.service.IUserService;

@RestController
@RequestMapping(path = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDto userDto){

        userService.createUser(userDto);

        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));


    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<UserDto> fetchUser(@Valid @PathVariable Long id) throws ResourceNotFound {
        UserDto userDto = userService.fetchUser(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(userDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody UserDto userDto, @Valid @PathVariable Long id) throws Exception {
        if(userDto == null || userDto.getIsUpdated()!=null || id==null){
            throw new InvalidArgumentException("Bad Request : Missing Argument");
        }
        userService.updateUser(userDto, id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200));
    }
}
