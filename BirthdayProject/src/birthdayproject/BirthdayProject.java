/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthdayproject;

import java.util.ArrayList;
import java.util.List;
import services.BirthdayList;
import services.BirthdayList_Service;

/**
 *
 * @author BJ
 */
public class BirthdayProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BirthdayList_Service bls = new BirthdayList_Service();
        BirthdayList bl = bls.getBirthdayListPort();
        List<String> memberWithBirthday = bl.getBirthdayMembers();
        if(memberWithBirthday.size()==0){
            System.out.println("No members with birthdays this month.");
        } else {
            System.out.println("Here are the members with birthdays this month:");
        }
        for(String nextMember: memberWithBirthday){
            System.out.println(nextMember);
        }
    }
    
}
