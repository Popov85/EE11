package com.goit.popov.ee09.dao.implJPA;

import com.goit.popov.ee09.dao.entity.DishDAO;
import com.goit.popov.ee09.dao.entity.StoreHouseDAO;
import com.goit.popov.ee09.model.Dish;
import com.goit.popov.ee09.model.DishIngredient;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrey on 28.10.2016.
 */
public class DishDAOImplJPA implements DishDAO {

        private SessionFactory sessionFactory;

        private StoreHouseDAO stock;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Transactional
        @Override
        public int insert(Dish dish) {
                return (int) sessionFactory.getCurrentSession().save(dish);
        }

        @Transactional
        @Override
        public void update(Dish dish) {
                sessionFactory.getCurrentSession().update(dish);
        }

        @Transactional
        @Override
        public List<Dish> getAll() {
                return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
        }

        @Transactional
        @Override
        public Dish getById(int id) {
                return sessionFactory.getCurrentSession().get(Dish.class, id);
        }

        @Transactional
        @Override
        public void delete(Dish dish) {
                sessionFactory.getCurrentSession().delete(dish);
        }

        @Transactional
        @Override
        public List<DishIngredient> getIngredients(int id) {
                Dish dish = getById(id);
                return dish.getIngredients();
        }

        @Transactional
        @Override
        public boolean isIngredientsInStock(int id) {
                List<DishIngredient> ingredients = getIngredients(id);
                for (DishIngredient ingredient : ingredients) {
                       if (stock.getById(ingredient.getIngredient().getId()).getQuantity()
                               < ingredient.getQuantityRequired()) {
                              return false;
                       }
                }
                return true;
        }
}
