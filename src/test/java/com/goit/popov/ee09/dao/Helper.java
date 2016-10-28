package com.goit.popov.ee09.dao;

import com.goit.popov.ee09.dao.entity.PositionDAO;
import com.goit.popov.ee09.model.Employee;
import com.goit.popov.ee09.model.Position;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

/**
 * Created by Andrey on 28.10.2016.
 */
public class Helper {

        public static final SimpleDateFormat format =
                new SimpleDateFormat ("yyyy-MM-dd");


        @Autowired
        private SessionFactory sessionFactory;

        private String className;

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        /*public Helper(String className) {
                this.className = className;
        }

        public Object getById(String className, int id) {
                switch (className) {
                        case "Position": return sessionFactory.getCurrentSession().get(Position.class, id);
                        case "Employee": return sessionFactory.getCurrentSession().get(Employee.class, id);
                        default: throw new RuntimeException();
                }
        }*/


        @Transactional
        public Position getByIdPosition(int id) {
                return sessionFactory.getCurrentSession().get(Position.class, id);
        }

        @Transactional
        public Employee getByIdEmployee(int id) {
                return sessionFactory.getCurrentSession().get(Employee.class, id);
        }
}
