package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.PreparedDishHistoryDAO;
import com.goit.popov.ee09.model.PreparedDish;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by Andrey on 10/28/2016.
 */
public class PreparedDishHistoryDAOImplJPA implements PreparedDishHistoryDAO {

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Override
        public int addPreparedDish(PreparedDish dish) {
                return (int) sessionFactory.getCurrentSession().save(dish);
        }

        @Override
        public List<PreparedDish> getAll() {
                return sessionFactory.getCurrentSession().createQuery("select pd from PreparedDish pd").list();
        }
}
