package nicolas.library.controllers.services;

import nicolas.library.model.AppUser;
import org.springframework.security.core.Authentication;
import nicolas.library.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public AppUser getCurrentUser(Authentication authentication) {
        AppUser appUser = null;
        if(authentication != null) {
            Object principal = authentication.getPrincipal();
            try {
                UserDetails userDetails = (UserDetails) principal;
                if (userDetails != null && userDetails.getUsername() != null) {
                    appUser = userRepository.findByUsername(userDetails.getUsername()).get();
                }
            } catch (ClassCastException e) {
                logger.error("Authentication error: " + e.getMessage());
            }
        }
        return appUser;
    }

    public void createUser(AppUser appUser) throws Exception {
        try {
            userRepository.save(appUser);
        } catch (Exception e) {
            logger.error("Error creating user: " + e.getMessage());
            throw new Exception("Error creating user: " + e.getMessage());
        }
    }

    /**
     * Check if a username is unique in our database.
     *
     * @return Boolean (true = unique, false = not unique)
     */
    public Boolean isUsernameUnique(String username) {
        return !userRepository.existsByUsername(username);
    }

    /**
     * Check if an e-mail is unique in our database.
     *
     * @return Boolean (true = unique, false = not unique)
     */
    public Boolean isEmailUnique(String email) {
        return !userRepository.existsByEmail(email);
    }

    /**
     * Checks if a username is valid and can be used by our database
     */
    public void isUsernameValid(String username) throws RuntimeException {
        if (username.length() > 20) throw new RuntimeException("Gebruikersnaam mag maximaal 20 tekens bevatten");

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(username);

        // Check if there is a match
        if (matcher.find()) throw new RuntimeException("Gebruikersnaam mag alleen letters en cijfers bevatten.");
    }

}
