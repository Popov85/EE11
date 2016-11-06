package com.goit.popov.ee09.dao.impl;

import com.goit.popov.ee09.dao.entity.ChefDAO;
import com.goit.popov.ee09.model.Chef;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrey on 11/5/2016.
 */
public class ChefDAOImplJPA implements ChefDAO {

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Transactional
        @Override
        public int insert(Chef chef) {
                return (int) sessionFactory.getCurrentSession().save(chef);
        }

        @Transactional
        @Override
        public void update(Chef chef) {
                sessionFactory.getCurrentSession().update(chef);
        }

        @Transactional
        @Override
        public List<Chef> getAll() {
                return sessionFactory.getCurrentSession().createQuery("select e from Chef e").list();
        }

        @Transactional
        @Override
        public Chef getById(int id) {
                return sessionFactory.getCurrentSession().get(Chef.class, id);
        }

        @Transactional
        @Override
        public void delete(Chef chef) {
                sessionFactory.getCurrentSession().delete(chef);
        }

        @Transactional
        @Override
        public Chef getByName(String name) {
                Query query = sessionFactory.getCurrentSession().createQuery("select e from Chef e " +
                        "where e.name like :name");
                query.setParameter("name", name);
                return (Chef) query.uniqueResult();
        }
}
