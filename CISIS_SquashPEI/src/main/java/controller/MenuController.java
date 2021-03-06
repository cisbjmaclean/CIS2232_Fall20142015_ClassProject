package controller;

import beans.ChangePassword;
import beans.CodeValue;
import beans.MemberSquash;
import beans.Notification;
import beans.Payment;
import business.MemberBO;
import business.NotificationBO;
import business.PaymentBO;
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
@RequestMapping("menu")
public class MenuController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu, HttpServletRequest request) {
        //pass validation if they enter "TEST" and "TEST"
        MemberSquash currentMember = (MemberSquash) request.getSession().getAttribute("currentMember");
        System.out.println("Menu post invoked");
        ModelAndView mv;
        if (menu.getAction().equalsIgnoreCase("Logout")) {
            mv = new ModelAndView("welcome");
        } else if (menu.getAction().equalsIgnoreCase("Payments")) {
            
            System.out.println("User wants to view the payments");
            mv = new ModelAndView("payment");
            mv.addObject("payments",PaymentBO.getPayments(currentMember.getMember().getMemberId()));
            mv.addObject("menu", new Menu());
        } else if (menu.getAction().equalsIgnoreCase("Reports")) {
            System.out.println("User wants to view reports");
            mv = new ModelAndView("main");
            mv.addObject("informationMessage", "Reports to be determined");
        } else if (menu.getAction().equalsIgnoreCase("My Information")) {
            System.out.println("User wants to view their information");
            mv = new ModelAndView("memberBio");
            mv.addObject("message", "User selected My information");
            MemberSquash loggedInMember = (MemberSquash) request.getSession().getAttribute("loggedInMember");
            request.getSession().setAttribute("currentMember", loggedInMember);
            mv.addObject("memberSquash",loggedInMember);
        } else if (menu.getAction().equalsIgnoreCase("Add Notification")) {
            System.out.println("User wants to view add a notification");
            mv = new ModelAndView("notificationAdd");
            mv.addObject("notification",new Notification());
        } else if (menu.getAction().equalsIgnoreCase("Add Payment")) {
            System.out.println("User wants to view add a payment");
            mv = new ModelAndView("paymentAdd");
            mv.addObject("payment",new Payment());
        } else if (menu.getAction().equalsIgnoreCase("View Codes")) {
            System.out.println("User wants to view the codes");
            mv = new ModelAndView("viewCodes");
            mv.addObject("message", "User selected view codes");
            mv.addObject("codeValue", new CodeValue());
        } else if (menu.getAction().equalsIgnoreCase("Members")) {
            System.out.println("User wants to view the members");
            mv = new ModelAndView("viewMembers");
            mv.addObject("members",MemberBO.getAllActiveMembers());
        } else if (menu.getAction().equalsIgnoreCase("Change Password")) {
            System.out.println("User wants to change password");
            mv = new ModelAndView("changePassword");
            ChangePassword cp = new ChangePassword();
            cp.setMemberId((String)request.getSession().getAttribute("loggedInUserId"));
            mv.addObject("changePassword",cp);
        } else if (menu.getAction().equalsIgnoreCase("Notifications")) {
            System.out.println("User wants to view the notifications");
            mv = new ModelAndView("notification");
            mv.addObject("notifications",NotificationBO.getNotifications());
            mv.addObject("menu", new Menu());
        } else {
            mv = new ModelAndView("welcome");
        }

        return mv;
    }
}
