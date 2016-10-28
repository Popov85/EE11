package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.OrderDAO;
import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.Order;
import com.goit.popov.ee09.model.OrderDish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrey on 10/28/2016.
 */
public class OrderDAOImplJPA implements OrderDAO {

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Transactional
        @Override
        public int insert(Order order) {
                return (int) sessionFactory.getCurrentSession().save(order);
        }

        @Transactional
        @Override
        public void update(Order order) {
                sessionFactory.getCurrentSession().update(order);
        }

        @Transactional
        @Override
        public List<Order> getAll() {
                return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
        }

        @Transactional
        @Override
        public Order getById(int id) {
                return sessionFactory.getCurrentSession().get(Order.class, id);
        }

        @Transactional
        @Override
        public void delete(Order order) {
                sessionFactory.getCurrentSession().delete(order);
        }

        @Transactional
        @Override
        public void addDish(Order order, Dish dish, int quantity) {
                List<OrderDish> dishes = order.getDishes();
                OrderDish oDish = new OrderDish();
                oDish.setDish(dish);
                oDish.setQuantityOrdered(quantity);
                dishes.add(oDish);
                update(order);
        }

        @Transactional
        @Override
        public void deleteDish(Order order, Dish dish, int quantity) {
                List<OrderDish> dishes = order.getDishes();
                OrderDish oDish = new OrderDish();
                oDish.setDish(dish);
                oDish.setQuantityOrdered(quantity);
                dishes.remove(oDish);
                update(order);
        }

        @Transactional
        @Override
        public void close(Order order) {
                order.setOpened(false);
                update(order);
        }

        @Transactional
        @Override
        public List<Order> getAllClosed() {
                Query query = sessionFactory.getCurrentSession().createQuery("select o from Order o" +
                        "where o.isOpened = false");
                return query.list();
        }

        @Transactional
        @Override
        public List<Order> getAllOpened() {
                Query query = sessionFactory.getCurrentSession().createQuery("select o from Order o" +
                        "where o.isOpened = true");
                return query.list();
        }
}
