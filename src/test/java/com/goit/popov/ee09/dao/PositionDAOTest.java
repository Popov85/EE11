package com.goit.popov.ee09.dao;

import com.goit.popov.ee09.dao.entity.PositionDAO;
import com.goit.popov.ee09.dao.implJPA.PositionDAOImplJPA;
import com.goit.popov.ee09.model.Position;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Andrey on 27.10.2016.
 */
public class PositionDAOTest {

        private ApplicationContext context;

        private static final String POSITION = "Cleaner";

        private Position expectedPosition;

        private Position actualPosition;

        private int actualId;

        @Autowired
        private PositionDAO positionDAO;

        @Autowired
        private SessionFactory sessionFactory;

        public void setPositionDAO(PositionDAO positionDAO) {
                this.positionDAO = positionDAO;
        }

        public void setSessionFactory(SessionFactory sessionFactory) {
                this.sessionFactory = sessionFactory;
        }

        @Before
        public void setUp() throws Exception {
                context = new ClassPathXmlApplicationContext("application-context.xml","hibernate-context.xml");
                positionDAO = (PositionDAOImplJPA) context.getBean("positionDAO");
                expectedPosition = new Position();
                expectedPosition.setName(POSITION);
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void test() {
                // insert
                insert();
                // delete
                delete();
        }

        private void insert() {
                System.out.println("inserting");
                actualId = positionDAO.insert(expectedPosition);
                assertNotNull(actualId);
                actualPosition = positionDAO.getById(actualId);
                assertEquals(expectedPosition, actualPosition);
                System.out.println("inserted");
        }

        @Test
        public void update() {
                assertEquals(0, 0);
        }

        @Test
        public void getAll() {
                assertEquals(0, 0);
        }

        private void delete() {
                System.out.println("deleting");
                positionDAO.delete(this.actualPosition);
                Position actualPosition = positionDAO.getById(actualId);
                assertNull(actualPosition);
                System.out.println("deleted");
        }
}
