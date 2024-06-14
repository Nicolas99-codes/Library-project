package nicolas.library.controllers;

import nicolas.library.controllers.services.GoogleService;
import nicolas.library.controllers.services.UserService;
import nicolas.library.model.AppUser;
import nicolas.library.repositories.BooksRepository;
import nicolas.library.repositories.CategoryRepository;
import nicolas.library.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfileController {
    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private GoogleService googleService;

    @GetMapping("/profielPagina")
    public String profielPagina(Model model, Principal principal){
        Optional<AppUser> optionalAppUser = Optional.empty();
        if(principal != null){
            optionalAppUser = userRepository.findByUsername(principal.getName());
            if (optionalAppUser.isPresent()) {
                model.addAttribute("appUser", optionalAppUser.get());
            }
        }
        return "profilePage";
    }

    @GetMapping("/gegevensPagina")
    public String gegevensPagina(Model model, Principal principal){
        Optional<AppUser> optionalAppUser = Optional.empty();
        if(principal != null){
            optionalAppUser = userRepository.findByUsername(principal.getName());
            if (optionalAppUser.isPresent()) {
                model.addAttribute("appUser", optionalAppUser.get());
            }
        }
        return "dataPage";
    }

    @PostMapping("/gegevensPaginaWijzigen")
    public String gegevensPaginaWijzigen(String firstName, String surname, String email, String currentPassword, String newPassword, Principal principal){
        Optional<AppUser> optionalAppUser = Optional.empty();
        if(principal != null){
            optionalAppUser = userRepository.findByUsername(principal.getName());
            if (optionalAppUser.isPresent()){
                AppUser appUserToUpdate = optionalAppUser.get();

                if (!currentPassword.isEmpty() && !newPassword.isEmpty()) {
                    if (passwordEncoder.matches(currentPassword, appUserToUpdate.getPassword())) {
                        return "redirect:/profielPagina";
                    }

                    String encodedNewPassword = passwordEncoder.encode(newPassword);
                    appUserToUpdate.setPassword(encodedNewPassword);
                }

                appUserToUpdate.setFirstName(firstName);
                appUserToUpdate.setSurname(surname);
                appUserToUpdate.setEmail(email);

                userRepository.save(appUserToUpdate);
            }
        }

        return "redirect:/profielPagina";
    }
}
