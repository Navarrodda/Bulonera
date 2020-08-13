package bulonera.skz.service;

import bulonera.skz.dto.LoginRequestDto;
import bulonera.skz.exceptions.ExistingUser;
import bulonera.skz.exceptions.InvalidLoginException;
import bulonera.skz.exceptions.UserException;
import bulonera.skz.exceptions.ValidationException;
import bulonera.skz.model.User;
import bulonera.skz.model.enums.UserType;
import bulonera.skz.projections.UserFilter;
import bulonera.skz.projections.UsersFilter;
import bulonera.skz.repository.UserRepository;
import bulonera.skz.session.SessionManager;
import bulonera.skz.tools.HashPassword;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserFilter getUser(Integer id){
        return this.userRepository.getByUser(id);
    }

    public ResponseEntity addUser(User user){

            String password = user.getPassword();
            HashPassword hash = new HashPassword();
            user.setPassword(hash.getHashPassword(user.getPassword()));
            User userExist = this.userRepository.getByEmail(user.getEmail());
            user.setUserType(UserType.CUSTOMER);
            if(userExist == null)
            {
                this.userRepository.save(user);
                return new ResponseEntity<>(HttpStatus.OK + ":Registered user successfully.", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.CONFLICT + ": The user with the email you are trying to create already exists.", HttpStatus.CONFLICT);
            }
    }

    public ResponseEntity login(LoginRequestDto loginRequestDto, SessionManager sessionManager) {
        HashPassword hash= new HashPassword();
        String newPassword = hash.getHashPassword(loginRequestDto.getPassword());
        User user = userRepository.getByUsername(loginRequestDto.getEmail(), newPassword);
        if(user != null)
        {
            String token = sessionManager.createSession(user);
            return ResponseEntity.ok().headers(createHeaders(token)).build();
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE + ": Incorrect email or password.", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<List<UsersFilter>> bringAllUsers(){
        List<UsersFilter> users = this.userRepository.getByUsers();
        if(users != null)
        {
            return  ResponseEntity.ok(users);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }


    private HttpHeaders createHeaders(String token) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        return responseHeaders;
    }

}
