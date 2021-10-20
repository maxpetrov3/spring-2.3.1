package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Transactional
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery(" select s from User s", User.class);

        return query.getResultList();
    }

    @Transactional
    public User getUserById(String id) {
        Query query = entityManager.createQuery("select s from User s where s.id = :id", User.class);
        query.setParameter("id", Long.valueOf(id));

        return (User) query.getSingleResult();
    }

    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Transactional
    public void deleteUserById(Long id) {
        Query query = entityManager.createQuery("delete from User s where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
