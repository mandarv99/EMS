/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.util;

import java.util.Random;

/**
 *
 * @author rupesht
 */
public class CommonUtil {

    public static String generateRandomPassword() {
        int len = 7;
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
