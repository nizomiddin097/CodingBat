package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.User;
import uz.pdp.codingbat.payload.UserDto;
import uz.pdp.codingbat.payload.UserResponce;
import uz.pdp.codingbat.repository.UserRepository;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    /**
     * ID orqali bitta mijozni qaytaramiz
     *
     * @param id Integer
     * @return u
     */
    public User getUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
    /**
     * User qushadigan method
     * @return UserResponce
     * Bizga userDto tipida
     * Validatsiya quydik
     */
    public UserResponce addUser(UserDto userDto) {
        boolean existsByUserNameAndGmail = userRepository.existsByUserNameAndGmail(userDto.getUserName(), userDto.getGmail());
        if (existsByUserNameAndGmail) {
            return new UserResponce("Bunday user mavjud", false);
        }
        User user = new User();
        user.setFirstname(userDto.getUserName());
        user.setLastname(userDto.getUserName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserName(userDto.getUserName());
        user.setGmail(userDto.getGmail());
        return new UserResponce("User saqlandi",true);
    }
    /**
     * Mijozni taxrirlash

     * @param id
     * @param userDto
     * @return UserResponce
     * Bizga yo'lda ID RequestBody sida va userDto tipida json object beradi
     */
    public UserResponce editUser(Integer id,UserDto userDto){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            return new UserResponce("Bunday user mavjud emas",false);
        }
        User user = optionalUser.get();
        user.setFirstname(userDto.getUserName());
        user.setLastname(userDto.getUserName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserName(userDto.getUserName());
        user.setGmail(userDto.getGmail());
        return new UserResponce("User taxrirlandi",true);
    }
    /**
     * Mijozni uchirish ID orqali,Yo'lda ID ni beradi
     * @param id
     * @return UserResponce
     */
    public UserResponce deleteUser(Integer id){
        userRepository.findById(id);
        return new UserResponce("User uchirildi",true);
    }

}
