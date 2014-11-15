/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.SignUpDTO;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rupesht
 */
public class EmailUtility {

    private String to;
    private String body;
    private String subject;

    public void sendConfirmEmail(SignUpDTO signUpDTO) {
        this.to = signUpDTO.getEmailAddress();
        String link = getUrl() + "EmailConfirmation.xhtml?emailId=" + signUpDTO.getEmailAddress() + "&rnd=" + signUpDTO.getPassword() + "&ekd=" + signUpDTO.getUserId() + "&sche=jklsedkfedkdfje&njk=sdfdkl@jss&";
        this.body = String.format(EmailTexts.CONFIRMATION_EMAIL, signUpDTO.getFirstName(), signUpDTO.getLastName(), link, link);
        this.subject = "Welcome to My event";
        SendMailUtil.sendMail(this.to, subject, body);
    }

    public void sendUserConfirmEmail(OrganizerUserDTO organizerUserDTO) {
        this.to = organizerUserDTO.getEmailAddress();
        String link = getUrl() + "EmailConfirmation.xhtml?emailId=" + organizerUserDTO.getEmailAddress() + "&rnd=" + organizerUserDTO.getPassword() + "&ekd=" + organizerUserDTO.getUserId() + "&sche=jklsedkfedkdfje&njk=sdfdkl@jss&";
        this.body = String.format(EmailTexts.USER_PASSWORD_CONFIRMATION_EMAIL, organizerUserDTO.getFirstName(), organizerUserDTO.getLastName(), organizerUserDTO.getEmailAddress(), organizerUserDTO.getPassword(), link, link);
        this.subject = "Welcome to My event";
        SendMailUtil.sendMail(this.to, subject, body);
    }

    public void sendUserPassword(SignUpDTO signUpDTO) {
        this.to = signUpDTO.getEmailAddress();        
        this.body = String.format(EmailTexts.RESET_PASSWORD_CONFIRMATION_EMAIL, signUpDTO.getFirstName(), signUpDTO.getLastName(), signUpDTO.getEmailAddress(), signUpDTO.getPassword());
        this.subject = "Reset Password";
        SendMailUtil.sendMail(this.to, subject, body);
    }

    private String getUrl() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        return url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
    }
}
