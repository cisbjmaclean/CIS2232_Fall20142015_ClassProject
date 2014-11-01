package controller;

import beans.CodeValue;
import beans.Member;
import business.MemberBO;
import forms.Menu;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
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
@RequestMapping("memberAdmin")
public class MemberAdminController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onSubmit(HttpServletRequest request) {
        
        //check the parameters.
        
        String actionSpecified = request.getParameter("action");
        System.out.println("Action specified="+actionSpecified);
        System.out.println("Member id="+request.getParameter("memberId"));
        
        //Get the memberBio
        Member theMember = MemberBO.getMember(request.getParameter("memberId"));
        
        ModelAndView mv;
        mv = new ModelAndView("welcome");
        mv.addObject("memberBio",theMember);
        return mv;
    }
}
