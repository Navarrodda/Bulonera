package bulonera.skz.service;

import bulonera.skz.exceptions.ExistingUser;
import bulonera.skz.model.User;
import bulonera.skz.model.enums.UserType;
import bulonera.skz.repository.UserRepository;
import bulonera.skz.tools.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity addUser(User user) throws ExistingUser{

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

}
