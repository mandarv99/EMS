/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ems.datamodel.dao;

import com.ems.datamodel.dto.OrganizerUserDTO;
import com.ems.datamodel.dto.SignUpDTO;
import com.ems.datamodel.entity.Users;
import com.ems.datamodel.entity.Users_;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UsersDAO extends GenericDAO<Users> {

    public UsersDAO() {
        super(Users.class);
    }

    public Users findUser(String email, String password) {
        Users users = null;
        Map<String, Object> parameters = new HashMap<String, Object>();
        try {
            beginTransaction();
            parameters.put("email", email);
            parameters.put("password", password);
            users = super.findOneResult("Users.findByEmailAndPwd", parameters);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return users;
    }
    
    public SignUpDTO findUserAllData(String email, String password) {
        Users users = null;
        SignUpDTO userDetails = null;
        Map<String, Object> parameters = new HashMap<String, Object>();
        try {
            beginTransaction();
            parameters.put("email", email);
            parameters.put("password", password);
            users = super.findOneResult("Users.findByEmailAndPwd", parameters);
            
            if(users!=null)
            {
            	userDetails = new SignUpDTO();
            	userDetails.setUserId(users.getUserId());
            	userDetails.setFirstName(users.getFirstName());
            	userDetails.setLastName(users.getLastName());
            	userDetails.setSuperUserId(users.getSuperUserId());
            	userDetails.setUserType(users.getUserTypeId().getUserTypeId());
            	userDetails.setUserTypeName(users.getUserTypeId().getUserTypeName());
            	userDetails.setStatusId(users.getStatusId());
            	userDetails.setSuperUserId(users.getSuperUserId());
            	userDetails.setEmailAddress(users.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return userDetails;
    }

    public int insertUser(SignUpDTO signUpDTO) {
        int result = 0;
        try {
            beginTransaction();
            Users user = new Users();
            user.setEmail(signUpDTO.getEmailAddress());
            user.setFirstName(signUpDTO.getFirstName());
            user.setLastName(signUpDTO.getLastName());
            user.setPassword(signUpDTO.getPassword());
            UserTypeDAO userTypeDAO = new UserTypeDAO();
            user.setUserTypeId(userTypeDAO.getUserType(signUpDTO.getUserType()));
            user.setSuperUserId(0);
            save(user);
            result = user.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public Users isEmailIdRegister(String emailId) {
        Users users = null;
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("email", emailId);
            users = findOneResult("Users.findByEmail", parameters);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return users;
    }

    public List<OrganizerUserDTO> getUserList(int superUserId) {
        List<OrganizerUserDTO> userList = new ArrayList<OrganizerUserDTO>();
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("superUserId", superUserId);
            List<Users> userEnList = super.findResults("Users.findBySuperUserId", parameters);
            for (Users user : userEnList) {
                OrganizerUserDTO organizerUserDTO = new OrganizerUserDTO();
                organizerUserDTO.setEmailAddress(user.getEmail());
                organizerUserDTO.setFirstName(user.getFirstName());
                organizerUserDTO.setLastName(user.getLastName());
                organizerUserDTO.setUserId(user.getUserId());
                organizerUserDTO.setSuperUserId(user.getSuperUserId());
                organizerUserDTO.setUserTypeId(user.getUserTypeId().getUserTypeId());
                organizerUserDTO.setUserTypeName(user.getUserTypeId().getUserTypeName());
                organizerUserDTO.setChangeInNextLogin(user.getPassChangeInNextLogin());
                userList.add(organizerUserDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }

        return userList;
    }

    public OrganizerUserDTO findUser(int userId) {
        OrganizerUserDTO organizerUserDTO = null;
        try {
            beginTransaction();
            Users users = find(userId);
            organizerUserDTO = new OrganizerUserDTO();
            organizerUserDTO.setChangeInNextLogin(users.getPassChangeInNextLogin());
            organizerUserDTO.setEmailAddress(users.getEmail());
            organizerUserDTO.setFirstName(users.getFirstName());
            organizerUserDTO.setLastName(users.getLastName());
            organizerUserDTO.setPassword(users.getPassword());
            organizerUserDTO.setSuperUserId(users.getSuperUserId());
            organizerUserDTO.setUserId(users.getUserId());
            organizerUserDTO.setUserTypeName(users.getUserTypeId().getUserTypeName());
            organizerUserDTO.setUserTypeId(users.getUserTypeId().getUserTypeId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organizerUserDTO;
    }

    public SignUpDTO findUser(String email, String password, int userId) {
        SignUpDTO signUpDTO = null;
        try {
            beginTransaction();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("email", email);
            parameters.put("password", password);
            parameters.put("userId", userId);
            Users users = super.findOneResult("Users.findByEmailAndPwdAndUserId", parameters);
            if (users != null) {
                signUpDTO = new SignUpDTO();
                signUpDTO.setFirstName(users.getFirstName());
                signUpDTO.setLastName(users.getLastName());
                signUpDTO.setUserId(users.getUserId());
                users.setStatusId(1);
                update(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return signUpDTO;
    }

    public int insertUser(OrganizerUserDTO organizerUserDTO) {
        int result = 0;
        try {
            beginTransaction();
            Users user = new Users();
            user.setEmail(organizerUserDTO.getEmailAddress());
            user.setFirstName(organizerUserDTO.getFirstName());
            user.setLastName(organizerUserDTO.getLastName());
            user.setPassword(organizerUserDTO.getPassword());
            UserTypeDAO userTypeDAO = new UserTypeDAO();
            user.setUserTypeId(userTypeDAO.getUserType(organizerUserDTO.getUserTypeId()));
            user.setSuperUserId(organizerUserDTO.getSuperUserId());
            user.setPassChangeInNextLogin(organizerUserDTO.isChangeInNextLogin());
            save(user);

            result = user.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public int updateOrganizerUser(OrganizerUserDTO organizerUserDTO) {
        int result = 0;
        try {
            beginTransaction();
            Users user = find(organizerUserDTO.getUserId());
            user.setEmail(organizerUserDTO.getEmailAddress());
            user.setFirstName(organizerUserDTO.getFirstName());
            user.setLastName(organizerUserDTO.getLastName());
            UserTypeDAO userTypeDAO = new UserTypeDAO();
            user.setUserTypeId(userTypeDAO.getUserType(organizerUserDTO.getUserTypeId()));
            update(user);
            result = user.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return result;
    }

    public void deleteOrganizerUser(OrganizerUserDTO organizerUserDTO) {
        try {
            beginTransaction();
            Users user = find(organizerUserDTO.getUserId());
            delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }

    public List<OrganizerUserDTO> searchOrganizerUser(String firstName, String lastName, int userTypeId, int superUserId) {
        List<OrganizerUserDTO> userList = new ArrayList<OrganizerUserDTO>();
        try {
            beginTransaction();
            EntityManager em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery(Users.class);
            Root<Users> users = query.from(Users.class);
            List<Predicate> predicateList = new ArrayList<Predicate>();
            if (firstName != null) {
                predicateList.add(cb.like(users.get(Users_.firstName), firstName + "%"));
            }
            if (lastName != null) {
                predicateList.add(cb.like(users.get(Users_.lastName), lastName + "%"));
            }
            if (userTypeId != 0) {
                predicateList.add(cb.equal(users.get(Users_.userTypeId), userTypeId));
            }
            if (superUserId != 0) {
                predicateList.add(cb.equal(users.get(Users_.superUserId), superUserId));
            }
            predicateList.add(cb.notEqual(users.get(Users_.userTypeId), 1));
            Predicate[] predicates = new Predicate[predicateList.size()];
            predicateList.toArray(predicates);
            query.where(predicates);
            List<Users> usersEnList = em.createQuery(query).getResultList();
            for (Users user : usersEnList) {
                OrganizerUserDTO organizerUserDTO = new OrganizerUserDTO();
                organizerUserDTO.setEmailAddress(user.getEmail());
                organizerUserDTO.setFirstName(user.getFirstName());
                organizerUserDTO.setLastName(user.getLastName());
                organizerUserDTO.setUserId(user.getUserId());
                organizerUserDTO.setSuperUserId(user.getSuperUserId());
                organizerUserDTO.setUserTypeId(user.getUserTypeId().getUserTypeId());
                organizerUserDTO.setUserTypeName(user.getUserTypeId().getUserTypeName());
                organizerUserDTO.setChangeInNextLogin(user.getPassChangeInNextLogin());
                organizerUserDTO.setUserId(user.getUserId());
                userList.add(organizerUserDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
        return userList;
    }
    
    public void updateUserPassword(SignUpDTO signUpDTO){
          try {
              beginTransaction();
              Users users = find(signUpDTO.getUserId());
              users.setPassword(signUpDTO.getPassword());
              update(users);
          }
           catch (Exception e) {
            e.printStackTrace();
        } finally {
            commitAndCloseTransaction();
        }
    }
}
