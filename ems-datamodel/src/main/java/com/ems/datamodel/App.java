package com.ems.datamodel;

import com.ems.datamodel.dao.UsersDAO;
import com.ems.datamodel.entity.Users_;
import com.ems.datamodel.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("emsPU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery query = cb.createQuery(Users.class);
//        Root<Users> users = query.from(Users.class);
//        List<Predicate> predicateList = new ArrayList<Predicate>();
//        predicateList.add(cb.like(users.get(Users_.firstName), "1up%"));
//        predicateList.add(cb.and(cb.like(users.get(Users_.lastName), "Tal%"), cb.equal(users.get(Users_.userTypeId), 1)));
//        Predicate[] predicates = new Predicate[predicateList.size()];
//        predicateList.toArray(predicates);
//        query.where(predicates);
//        List<Users> usersList = em.createQuery(query).getResultList();
//        System.out.println(usersList.size());
//        UsersDAO usersDAO = new UsersDAO();
//        usersDAO.searchOrganizerUser(null,null,2);
    }
}
