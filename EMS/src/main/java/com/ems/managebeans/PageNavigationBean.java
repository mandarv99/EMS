package com.ems.managebeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ems.datamodel.dto.CompanyDetailsDTO;
import com.ems.datamodel.dto.EventMasterDTO;
import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.SignUpDTO;

@ManagedBean(name="pageNavBean")
@SessionScoped
public class PageNavigationBean implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private String page = null;
	private String importParameter;
	private String header;
	private String backLabel;
	private String backAction;
	private SignUpDTO loggedInUserDTO;
	private int pageSize;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	  
  	
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

	public String getImportParameter() {
		return importParameter;
	}

	public void setImportParameter(String importParameter) {
		this.importParameter = importParameter;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBackLabel() {
		return backLabel;
	}

	public void setBackLabel(String backLabel) {
		this.backLabel = backLabel;
	}

	public String getBackAction() {
		return backAction;
	}

	public void setBackAction(String backAction) {
		this.backAction = backAction;
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
	
	// constructor
	public PageNavigationBean()
	{
 	}
	
	@PostConstruct
	public void init()
    {
		loggedInUserDTO = getLoginBean().getLoggedInUserDTO();
		pageSize = 15;
    }
	 
	public Object getSessionObject(String objName) 
	{
	    FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extCtx = ctx.getExternalContext();
	    Map<String, Object> sessionMap = extCtx.getSessionMap();
	    return sessionMap.get(objName);
	}

	public void redirectToMenu(String pageTo)
	{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			String red= "Menu.xhtml";
			page = pageTo;
			//System.out.println("page : " + page);
			if(page != null)
			{
				switch (page)
				{
					case "home" : 
							header = "Titbit CMS Management";
							break;
					case "contentMgmt" :
							backLabel = "CMS Mangement";
							backAction = "home";
							header = "Content Mangement";
							break;
					 
				
					default : break;
				}
				
			}
			ec.redirect(red);
		} catch (IOException e) { e.printStackTrace();	}
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
}