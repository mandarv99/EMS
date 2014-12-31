/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ems.managebeans;

import com.ems.datamodel.dto.ParticipantAttributeDTO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rupesh
 */
@ManagedBean(name = "participantsBean")
@ViewScoped
public class ParticipantsBean extends AbstractMB{
    private ParticipantAttributeDTO participantAttributeDTO;

    /**
     * @return the participantAttributeDTO
     */
    public ParticipantAttributeDTO getParticipantAttributeDTO() {
        return participantAttributeDTO;
    }

    /**
     * @param participantAttributeDTO the participantAttributeDTO to set
     */
    public void setParticipantAttributeDTO(ParticipantAttributeDTO participantAttributeDTO) {
        this.participantAttributeDTO = participantAttributeDTO;
    }
    
    public void saveParticipant(){
        
    }
}
