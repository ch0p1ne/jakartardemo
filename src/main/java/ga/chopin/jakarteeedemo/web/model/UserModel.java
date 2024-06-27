package ga.chopin.jakarteeedemo.web.model;

import ga.chopin.jakarteeedemo.services.entities.User;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel implements Serializable {

    private List<User> users= new ArrayList<>();
}
