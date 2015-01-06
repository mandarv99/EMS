/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author snehalr
 *
 */
@StaticMetamodel(EventMaster.class)
public class EventMaster_{

    public static volatile SingularAttribute<EventMaster, Integer> eventId;
    public static volatile SingularAttribute<EventMaster, String> eventName;
    public static volatile SingularAttribute<EventMaster, Integer> companyId;
    
    public static volatile SingularAttribute<EventMaster, Date> eventStartDatetime;
    public static volatile SingularAttribute<EventMaster, Date> eventEndDatetime;
    public static volatile SingularAttribute<EventMaster, Integer> eventTypeId;   
    public static volatile SingularAttribute<EventMaster, Integer>  eventStatus;
    public static volatile SingularAttribute<EventMaster, String> eventDescription;
    
    public static volatile SingularAttribute<EventMaster, Date> addedOn;
    public static volatile SingularAttribute<EventMaster, String> disclaimer;
    public static volatile SingularAttribute<EventMaster, String> eventUrl;
    public static volatile SingularAttribute<EventMaster, String> photoUrl;
    public static volatile SingularAttribute<EventMaster, String> eventHeaderImage;
    public static volatile SingularAttribute<EventMaster, Boolean> requiredSittingArrangement;
    public static volatile SingularAttribute<EventMaster, Integer> isDiscounted;
    public static volatile SingularAttribute<EventMaster, Boolean>  isFreeEvent;
    
    public static volatile SingularAttribute<EventMaster, Integer> addedBy;
    public static volatile SingularAttribute<EventMaster, String>  eventAddress;
    public static volatile SingularAttribute<EventMaster, String>   eventCode;
    public static volatile SingularAttribute<EventMaster, Integer> requireDisclaimer;
    public static volatile SingularAttribute<EventMaster, Boolean>  bibNumbering;
    
    public static volatile PluralAttribute<EventMaster,  Collection , Disclaimer > disclaimerCollection;
    public static volatile PluralAttribute<EventMaster,   Collection ,TicketMaster > ticketMasterCollection;
    public static volatile PluralAttribute<EventMaster, Collection ,DiscountMaster > discountMasterCollection;
    public static volatile PluralAttribute<EventMaster,  Collection , ParticipantMaster > participantMasterCollection;
    public static volatile PluralAttribute<EventMaster, Collection , SuperCategoryTkt > superCategoryTktCollection;
 }
