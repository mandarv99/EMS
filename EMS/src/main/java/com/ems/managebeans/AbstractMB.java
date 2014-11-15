/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.managebeans;

import com.ems.util.MessageUtil;
import java.io.Serializable;

public class AbstractMB implements Serializable {

    MessageUtil messageUtil = null;

    public AbstractMB() {
        super();
        messageUtil = new MessageUtil();
    }

    protected void displayErrorMessageToUser(String message) {
        messageUtil.sendErrorMessageToUser(message);
    }

    protected void displayInfoMessageToUser(String message) {
        messageUtil.sendInfoMessageToUser(message);
    }

    public void showMessageInDialog(String message) {
        messageUtil.showMessageInDialog(message);
    }
    public void showErrorMessageInDialog(String message) {
        messageUtil.showErrorMessageInDialog(message);
    }
//    protected void checkSessionValidate(LoginDTO loginDTO) {
//        try {
//            if (loginDTO.getUserId() == -9 || loginDTO.getUserId() == 0) {
//                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
////                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
////                response.sendRedirect("login.xhtml");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
}
