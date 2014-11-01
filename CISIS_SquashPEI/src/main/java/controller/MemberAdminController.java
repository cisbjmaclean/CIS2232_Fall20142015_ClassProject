package controller;

import beans.Member;
import beans.MemberSquash;
import business.MemberBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
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
        System.out.println("Action specified=" + actionSpecified);
        System.out.println("Member id=" + request.getParameter("memberId"));
        Member theMember = MemberBO.getMember(request.getParameter("memberId"));
        String message = "";
        ModelAndView mv;
        if (actionSpecified != null && actionSpecified.equalsIgnoreCase("delete")) {
            try {
                MemberBO.deleteMember(theMember, (String) request.getSession().getAttribute("loggedInUserId"));
            } catch (Exception ex) {
                Logger.getLogger(MemberAdminController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }
            message = "member was deleted";
            mv = new ModelAndView("viewMembers");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllActiveMembers());

        } else {
            //Get the memberBio
            MemberSquash memberSquash = new MemberSquash();
            memberSquash.setMember(theMember);
            mv = new ModelAndView("memberBio");
            mv.addObject("memberSquash", memberSquash);

        }
        return mv;
    }
}
