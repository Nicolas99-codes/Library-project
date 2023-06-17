package nicolas.library.controllers;

import nicolas.library.model.User;
import nicolas.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository usersRepository;

    @GetMapping({"/UserDetails/{id}"})
    public String showUserDetails(Model model, @PathVariable int id){
        Optional<User> UserFromDb = usersRepository.findById(id);
        if (UserFromDb.isPresent()) {
            model.addAttribute("user", UserFromDb.get());
        }
        return "UserDetails";
    }

    @GetMapping({"/UserDetails/{id}/prev"})
    public String showUserDetailsPrev(Model model, @PathVariable int id){
        Optional<User> prevUserFromDb = usersRepository.findFirstByIdLessThanOrderByIdDesc(id);
        if (prevUserFromDb.isPresent()){
            return String.format("redirect:/UserDetails/%d", prevUserFromDb.get().getId());}
        Optional<User> lastUserFromDb = usersRepository.findFirstByOrderByIdDesc();
        if (lastUserFromDb.isPresent())
            return String.format("redirect:/UserDetails/%d", lastUserFromDb.get().getId());
        model.addAttribute("prevDisabled", true);
        model.addAttribute("nextDisabled", false);
        model.addAttribute("user", usersRepository.findById(id).get());
        return "UserDetails";
    }

    @GetMapping({"/UserDetails/{id}/next"})
    public String showBookDetailsNext(Model model, @PathVariable int id){
        Optional<User> nextUserFromDb = usersRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextUserFromDb.isPresent())
            return String.format("redirect:/UserDetails/%d", nextUserFromDb.get().getId());
        Optional<User> firstUserFromDb = usersRepository.findFirstByOrderByIdAsc();
        if (firstUserFromDb.isPresent())
            return String.format("redirect:/UserDetails/%d", firstUserFromDb.get().getId());
        return "UserDetails";
    }
}
