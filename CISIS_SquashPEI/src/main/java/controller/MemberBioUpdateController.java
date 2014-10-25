package controller;

import beans.Member;
import forms.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("memberBioUpdate")
public class MemberBioUpdateController {

    @RequestMapping(method = RequestMethod.GET)
    public String loadMember(ModelMap model) {

        model.addAttribute("memberBio", new Member());
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu) {
        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
        mv = new ModelAndView("welcome");
        return mv;
    }
}
