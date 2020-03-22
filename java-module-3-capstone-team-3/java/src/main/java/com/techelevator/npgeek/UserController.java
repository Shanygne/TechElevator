package com.techelevator.npgeek;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.User;

@Controller
public class UserController {
	
	@Autowired
    private AuthProvider auth;
	
	@Autowired
	private UserDao aUser;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelHolder) {
		modelHolder.put("lastlogin", aUser.getLastLogin());
        return "Login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes flash, ModelMap modelHolder) {
    	//String passwordHint = aUser.getPasswordHint(username);
        if (auth.signIn(username, password)) {
            return "redirect:/login";
        } else {
            flash.addFlashAttribute("message", "Login Invalid");
            //flash.addFlashAttribute("passwordHint", passwordHint);
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/logoff", method = RequestMethod.POST)
    public String logOff() {
        auth.logOff();
        return "redirect:/";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("User")) {
            modelHolder.put("User", new User());
        }
        return "Register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("User") User user, BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute("User", user);
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "User", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/register";
        }
        auth.register(user.getUsername(), user.getPassword(), user.getEmailAddress(), user.getPasswordHint());
        return "redirect:/";
    }
}
