package lk.aduwata.service;


import lk.aduwata.model.Item;
import lk.aduwata.model.User;
import lk.aduwata.repository.ItemRepository;
import lk.aduwata.repository.UserRepository;
import lk.aduwata.resource.ItemResource;
import lk.aduwata.resource.UserResource;
import lk.aduwata.util.rest.DataTableResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * ItemService is for providing services for the item table
 *
 * @author Sugeesh Chandraweera
 */
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;


    /**
     * This method will save the user to the database
     *
     * @param userResource userResource for the save
     * @return UserResource object with saved data
     */
    public UserResource saveUser(UserResource userResource) {
        User user = new User(
                userResource.getName(),
                userResource.getEmail(),
//                passwordEncoder.encode(userResource.getPassword()),
                userResource.getPassword(),
                userResource.getAddress(),
                userResource.getMobile(),
                userResource.getType(),
                userResource.getBirthday(),
                userResource.getDistrict()
        );
        user.setType(1);
        User savedUser = userRepository.save(user);
        return UserResource.createResource(savedUser);
    }

    public Object loginUser(UserResource userResource) {
        User user = userRepository.findByName(userResource.getName());
      /*  if(user != null && passwordEncoder.matches(userResource.getName(),user.getPassword())){
            return UserResource.createResource(user);
        }else {
            return null;
        }*/
        return null;
    }

}
