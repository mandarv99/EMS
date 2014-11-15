/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Users.class)
public class Users_{

    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Integer> statusId;
    public static volatile SingularAttribute<Users, Integer> superUserId;        
    public static volatile SingularAttribute<Users, UserType> userTypeId;
    public static volatile SingularAttribute<Users, Boolean> passChangeInNextLogin;
}
