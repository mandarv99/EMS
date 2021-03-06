package com.ems.managebeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.ems.datamodel.dao.PageLinkDAO;
import com.ems.datamodel.dto.CompanyDetailsDTO;
import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.PageLinkMasterDTO;
import com.ems.datamodel.dto.PageLinksDTO;
import com.ems.datamodel.dto.SignUpDTO;

@ManagedBean(name="pageNavBean")
@SessionScoped
public class PageNavigationBean implements Serializable 
{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7169467320037225256L;
	private String page = null;
   	private SignUpDTO loggedInUserDTO;
	private int pageSize;
	private MenuModel menuModel;
	private Date today;
	private Date nextDay;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	  
  	private PageLinkDAO pageDAO ;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	public SignUpDTO getLoggedInUserDTO() {
		return loggedInUserDTO;
	}

	public void setLoggedInUserDTO(SignUpDTO loggedInUserDTO) {
		this.loggedInUserDTO = loggedInUserDTO;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	// constructor
	public PageNavigationBean()
	{
 	}
	
	@PostConstruct
	public void init()
    {
		loggedInUserDTO = getLoginBean().getLoggedInUserDTO();
		
		/*if(loggedInUserDTO == null)
		{
			redirectToLogin();
 		}
		else
		{*/
			pageSize = 15;
			pageDAO =  new PageLinkDAO();
			// set today and next day values
			Calendar cal = Calendar.getInstance();
			setToday(cal.getTime());
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.add(Calendar.DATE , 1);
	 				
			setNextDay(cal.getTime());
			 
			generateMenuForUser();
		//}
    }
	 
	public Object getSessionObject(String objName) 
	{
	    FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extCtx = ctx.getExternalContext();
	    Map<String, Object> sessionMap = extCtx.getSessionMap();
	    return sessionMap.get(objName);
	}
	
	// to generate the menu
	private void generateMenuForUser()
	{
		 List<PageLinkMasterDTO> pageLinkDTOList = null;
		 pageLinkDTOList = pageDAO.getPageLinkListForUserType(loggedInUserDTO.getUserType());
 		 
		 menuModel =  new DefaultMenuModel();
		 
		 for(PageLinkMasterDTO pm : pageLinkDTOList)
		 {
			 if(pm.getPagelinkMasterType() == 1) // No sub Menu
			 {
				 DefaultMenuItem item = new DefaultMenuItem(pm.getPageLinkMasterName());
 			     if(pm.getPageLinksList().get(0).getPageLinkUrl().startsWith("#"))
 			    	 item.setCommand(pm.getPageLinksList().get(0).getPageLinkUrl());
 			     else
 			    	 item.setUrl(pm.getPageLinksList().get(0).getPageLinkUrl());
			     menuModel.addElement(item);  
 			 }
			 else
			 {
				 DefaultSubMenu  MainItem = new DefaultSubMenu (pm.getPageLinkMasterName());  
				 //MainItem.setIcon("ui-icon-triangle-1-sw");  

				 for(PageLinksDTO p : pm.getPageLinksList())
				 {
				     DefaultMenuItem item = new DefaultMenuItem(p.getPageLinkName());
 			    	 item.setUrl(p.getPageLinkUrl());
	 			     MainItem.addElement(item);
				 } 
			     menuModel.addElement(MainItem);  
			 }
		 }
	}

	 //to redirect page for authenticated User
  	public void redirectToLogin()
  	{
  		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
  		 loggedInUserDTO = new SignUpDTO();
   		 try {
  				String red= "/EMS/login.xhtml";
   				ec.redirect(red);
  		 } catch (IOException e) { e.printStackTrace();}	  		
  	}
  	

	// open edit company details page
	public void redirectPageToEditCompany(CompanyDetailsDTO companyDetails)
	{
		//RequestContext.getCurrentInstance().execute("PF('loaderDialog').show();");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			String red= "CompanyDetails.xhtml";
			ec.getFlash().put("companyDetails", companyDetails);
			ec.redirect(red);
		} catch (IOException e) { e.printStackTrace();	}
	} 
	
	// open company listing page
	public void redirectPageToSearchCompany()
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.getFlash().setKeepMessages(true);
		ec.getFlash().setRedirect(true);
		try {
			String red= "CompanyDetailsSearch.xhtml";
			ec.redirect(red);
		} catch (IOException e) { e.printStackTrace();	}
	}
	
	// open search organize user listing
	public void redirectPageToSearchUsers()
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.getFlash().setKeepMessages(true);
		ec.getFlash().setRedirect(true);
		try {
			String red= "OrganizerUserList.xhtml";
			ec.redirect(red);
		} catch (IOException e) { e.printStackTrace();	}
	}
	
	// open add organize user listing
    public void redirectPageToAddOrganizerUser(OrganizerUserDTO organizerUserDTO)
    {
    	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    	try {
	    	
    		if(organizerUserDTO!=null)
 	    		ec.getFlash().put("organizerUserDTO", organizerUserDTO);

  			String red= "AddOrganizerUser.xhtml";
			ec.redirect(red);
		} catch (IOException e) { e.printStackTrace();	}
     }
    
    // open event listing page
 	public void redirectPageToEventListing()
 	{
 		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
 		try {
 			String red= "EventList.xhtml";
 			ec.redirect(red);
 		} catch (IOException e) { e.printStackTrace();	}
 	}
 	
 	 // open add/edit event page
 	public void redirectPageToEventMaster(EventMasterDTO eventMasterDTO)
 	{
 		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
 		if(eventMasterDTO!=null)
	    		ec.getFlash().put("eventMaster", eventMasterDTO);

 		try {
 			String red= "Event.xhtml";
 			ec.redirect(red);
 		} catch (IOException e) { e.printStackTrace();	}
 	}
 	
 	public void redirectPageToResetPassword(OrganizerUserDTO organizerUserDTO)
 	{
 		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
 		if(organizerUserDTO!=null)
 		{
 			SignUpDTO resetPasswordUserDto = new SignUpDTO();
 			resetPasswordUserDto.setEmailAddress(organizerUserDTO.getEmailAddress());
 			resetPasswordUserDto.setUserId(organizerUserDTO.getUserId());
	    	ec.getFlash().put("resetPasswordUserDto", resetPasswordUserDto);
 		}
 		try {
 			String red= "ResetPassword.xhtml";
 			ec.redirect(red);
 		} catch (IOException e) { e.printStackTrace();	}
 	}

	public Date getNextDay() {
		return nextDay;
	}

	public void setNextDay(Date nextDay) {
		this.nextDay = nextDay;
	}
 	
}