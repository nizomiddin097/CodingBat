package uz.pdp.codingbat.payload;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String gmail;

    private String password;
}
