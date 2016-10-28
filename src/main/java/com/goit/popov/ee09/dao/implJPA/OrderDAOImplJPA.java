package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.OrderDAO;
import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Order;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by Andrey on 10/28/2016.
 */
public class OrderDAOImplJPA implements OrderDAO {

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Override
        public int insert(Order order) {
                return 0;
        }

        @Override
        public void update(Order order) {

        }

        @Override
        public List<Order> getAll() {
                return null;
        }

        @Override
        public Order getById(int id) {
                return null;
        }

        @Override
        public void delete(Order order) {

        }

        @Override
        public void addDish(Dish dish) {

        }

        @Override
        public void deleteDish(Dish dish) {

        }

        @Override
        public void close() {

        }

        @Override
        public List<Order> getAllClosed() {
                return null;
        }

        @Override
        public List<Order> getAllOpened() {
                return null;
        }
}
