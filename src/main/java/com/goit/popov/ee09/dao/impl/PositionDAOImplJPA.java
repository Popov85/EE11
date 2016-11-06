package com.goit.popov.ee09.dao.impl;

import com.goit.popov.ee09.dao.entity.PositionDAO;
import com.goit.popov.ee09.model.Position;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrey on 27.10.2016.
 */
public class PositionDAOImplJPA implements PositionDAO {

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Transactional
        @Override
        public int insert(Position position) {
                return (int) sessionFactory.getCurrentSession().save(position);
        }

        @Transactional
        @Override
        public void update(Position position) {
                sessionFactory.getCurrentSession().update(position);
        }

        @Transactional
        @Override
        public List<Position> getAll() {
                return sessionFactory.getCurrentSession().createQuery("select p from Position p").list();
        }

        @Transactional
        @Override
        public Position getById(int id) {
                return sessionFactory.getCurrentSession().get(Position.class, id);
        }

        @Transactional
        @Override
        public void delete(Position position) {
                sessionFactory.getCurrentSession().delete(position);
        }
}
