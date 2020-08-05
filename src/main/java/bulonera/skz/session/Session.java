package bulonera.skz.session;

import bulonera.skz.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Session {

    private String token;
    private User loggedUser;
    private Date lastEvent;

}
