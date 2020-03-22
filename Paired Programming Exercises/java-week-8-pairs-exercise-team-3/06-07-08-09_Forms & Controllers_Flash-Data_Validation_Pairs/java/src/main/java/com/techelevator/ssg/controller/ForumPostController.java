package com.techelevator.ssg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class ForumPostController {
	
	@Autowired
	private ForumDao forumDao;
	
	@RequestMapping(path = "/forumPostInput", method = RequestMethod.GET)
	public String showForumPostInput(Model modelHolder) {
		if( ! modelHolder.containsAttribute("ForumPost")) {       // if the modelMap does NOT have an attribute key "SignUp"
			modelHolder.addAttribute("ForumPost", new ForumPost());  // add one with a new instance of the SignUp class
			}
		return "forumPostInput";
	}
	
	@RequestMapping(path = "/forumPostOutput", method = RequestMethod.GET)
	public String showForumPostOutput(ModelMap forumMap) {
		
		List<ForumPost> forumPost = forumDao.getAllPosts();
		forumMap.put("postKey", forumPost);
		
		return "forumPostOutput";
	}
	
	@RequestMapping(path = "/forumPostInput", method = RequestMethod.POST) 
	public String processForumPostInput(@Valid @ModelAttribute ("ForumPost") ForumPost forumPost, BindingResult result, RedirectAttributes flash) {
		if(result.hasErrors()) {   // key for entry                          , value     // if there are errors found during validation,
		flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "ForumPost", result);  // Add the BindingResult Object to the FlashMap 
		flash.addFlashAttribute("ForumPost", forumPost);                       // Add the Object with the user data (registerFormValues) to the FlashMap
		return "redirect:/forumPostInput";                                              // Go to the GET for this URL -- Send us back to the mailingList view
	}		
		forumDao.save(forumPost); 
		return "redirect:/forumPostOutput";
	}
	}

