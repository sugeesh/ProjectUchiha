package lk.aduwata.service;


import lk.aduwata.model.User;
import lk.aduwata.repository.UserRepository;
import lk.aduwata.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * AdvertisementService is for providing services for the advertisement table
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
