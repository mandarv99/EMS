/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

/**
 *
 * @author rupesht
 */
public final class EmailTexts {

    public static final String CONFIRMATION_EMAIL = "<span><b>Dear %s %s</b></span>,<span><br/><br/>Welcome and thank you for registering with My event.<br/>"
            + "Kindly click on below link to do confirmation.</span><br/><br/><a href='%s'>%s</a><br/><br/>Thank you,<br/><b>My Event</b>";
    public static final String USER_PASSWORD_CONFIRMATION_EMAIL = "<span><b>Dear %s %s</b></span>,<span><br/><br/>Welcome and thank you for registering with My event.<br/>Following is your login details.<br/>"
            + "User ID %s<br/>Password %s<br/>Kindly click on below link to do confirmation.</span><br/><br/><a href='%s'>%s</a><br/><br/>Thank you,<br/><b>My Event</b>";
    
    public static final String RESET_PASSWORD_CONFIRMATION_EMAIL = "<span><b>Dear %s %s</b></span>,<span><br/><br/>Following is your login details.<br/>"
            + "User ID %s<br/>Password %s<br/><br/>Thank you,<br/><b>My Event</b>";
}
