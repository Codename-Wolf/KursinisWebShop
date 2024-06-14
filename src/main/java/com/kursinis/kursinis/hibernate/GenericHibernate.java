package com.kursinis.kursinis.hibernate;

import com.kursinis.kursinis.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class GenericHibernate {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    public GenericHibernate(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public <T> void create(T entity) {
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }

    public <T> void update(T entity) {
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }

    public <T> void delete(Class<T> entityClass, int id) {
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            T object = entityManager.find(entityClass, id);
            entityManager.remove(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }

    public <T> T getEntityById(Class<T> entityClass, int id) {
        T result = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            result = entityManager.find(entityClass, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) entityManager.close();
        }
        return result;
    }

    public <T> T getUserByCredentials(String email, String password) {
        EntityManager em = getEntityManager();
        try {
            Manager manager = getManagerByCredentials(email, password);
            return manager == null ? (T) getCustomerByCredentials(email, password) : (T) manager;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) em.close();
        }
    }

    public Manager getManagerByCredentials(String email, String password) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Manager> query = cb.createQuery(Manager.class);
            Root<Manager> root = query.from(Manager.class);
            query.select(root).where(cb.and(cb.like(root.get("email"), email), cb.like(root.get("password"), password)));
            Query q;

            q = em.createQuery(query);
            return (Manager) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) em.close();
        }
    }

    public Customer getCustomerByCredentials(String email, String password) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);
            query.select(root).where(cb.and(cb.like(root.get("email"), email), cb.like(root.get("password"), password)));
            Query q;

            q = em.createQuery(query);
            return (Customer) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Comment> getProductComments(Product product, Comment parentComment) {
        List<Comment> result = new ArrayList<>();
        try {
            entityManager = getEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery();
            Root<Comment> root = query.from(Comment.class);
            if(parentComment == null) {
                query.select(root).where(cb.and(cb.equal(root.get("product"), product), cb.isNull(root.get("parentComment"))));
            } else {
                query.select(root).where(cb.and(cb.equal(root.get("product"), product), cb.equal(root.get("parentComment"),parentComment)));
            }
            Query q = entityManager.createQuery(query);
            result = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }


    public Cart getCartByCartSearch(Customer user) {
        List<Cart> carts = getAllRecords(Cart.class);
        for (Cart cart : carts) {
            if (cart.getCustomer().getId() == user.getId()) {
                if(cart.getOrderstate().equals("NOT_PLACED")) {
                    return cart;
                }
            }
        }
        Cart cart = new Cart(user);
        create(cart);
        return cart;
    }

    public <T> List<T> getAllRecords(Class<T> entityClass) {

        List<T> result = new ArrayList<>();
        try {
            entityManager = getEntityManager();
            CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
            query.select(query.from(entityClass));
            Query q = entityManager.createQuery(query);
            result = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

}
