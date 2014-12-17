/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ems.datamodel.dto.PageLinkMasterDTO;
import com.ems.datamodel.dto.PageLinksDTO;
import com.ems.datamodel.entity.Pagelinks;
import com.ems.datamodel.entity.PagelinksMaster;

/**
 * @author snehalr
 *
 */
public class PageLinkDAO extends GenericDAO<Pagelinks> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5267703624330146201L;

	public PageLinkDAO() {
        super(Pagelinks.class);
    }

    public List<PageLinkMasterDTO> getPageLinkListForUserType(int userTypeId) {
        List<PageLinksDTO> pageLinkDTOList = new ArrayList<PageLinksDTO>();
        List<PageLinkMasterDTO> pageLinkMasterDTOList = new ArrayList<PageLinkMasterDTO>();

        Map<String, Object> parameters = new HashMap<String, Object>();
        try {
            beginTransaction();
            parameters.put("userTypeId", userTypeId);
            
            int i= 0;
            List<Pagelinks> pageList = findResults("Pagelinks.findByPageDetailLinkUserId", parameters);
            for (Object ob : pageList) {
            	 
            	Object ob1[] = (Object[])ob; 
            	Pagelinks p = (Pagelinks)ob1[0];
            	PagelinksMaster pm = (PagelinksMaster)ob1[1];
            	
               	PageLinkMasterDTO pmDTO = new PageLinkMasterDTO();
            	pmDTO.setPageLinkMasterId((int)pm.getPagelinkmasterid());
            	pmDTO.setPageLinkMasterName(pm.getPagelinkmastername());
            	pmDTO.setPagelinkMasterType(pm.getPagelinkmastertype());
            	
            	if(i==0)
            		pageLinkMasterDTOList.add(pmDTO);
            	else if(i > 0 && pmDTO.getPageLinkMasterId().intValue() != pageLinkMasterDTOList.get(pageLinkMasterDTOList.size()-1).getPageLinkMasterId())
            		pageLinkMasterDTOList.add(pmDTO);
            	            	
            	PageLinksDTO pDTO = new PageLinksDTO();
            	pDTO.setPageLinkMasterId((int)pm.getPagelinkmasterid());
             	pDTO.setPageLinkId((int)p.getPagelinkid());
            	pDTO.setPageLinkName(p.getPagelinkname());
            	pDTO.setPageLinkUrl(p.getPagelinkurl());
            	
            	if(i==0)
            	{
            		pageLinkDTOList.add(pDTO);
            		pmDTO.setPageLinksList(pageLinkDTOList);
            	}
            	else
            	{	
	             	if(pmDTO.getPageLinkMasterId().intValue() == pageLinkMasterDTOList.get(pageLinkMasterDTOList.size()-1).getPageLinkMasterId() )
	            	{
	             		pageLinkMasterDTOList.get(pageLinkMasterDTOList.size()-1).getPageLinksList().add(pDTO);
	            	}
	            	else 
	            	{
	            		pageLinkDTOList = new ArrayList<PageLinksDTO>();
	            		pageLinkDTOList.add(pDTO);
	            		pageLinkMasterDTOList.get(pageLinkMasterDTOList.size()-1).setPageLinksList(pageLinkDTOList);
		             	}
            	}
            	i++;
            	
             }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return pageLinkMasterDTOList;
    }

    
}
