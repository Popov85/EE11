package com.goit.popov.ee09.dao;

import com.goit.popov.ee09.dao.entity.PositionDAO;
import com.goit.popov.ee09.dao.impl.PositionDAOImplJPA;
import com.goit.popov.ee09.model.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 27.10.2016.
 */
public class PositionDAOTest {

        private ApplicationContext context;

        private static final String POSITION = "Cleaner";

        private static final String POSITION_UPD = "Janitor";

        private Position expectedPosition;

        private Position actualPosition;

        private int generatedId;

        private PositionDAO positionDAO;

        private Helper helper;


        @Before
        public void setUp() throws Exception {
                context = new ClassPathXmlApplicationContext("application-context.xml","test-context.xml");
                positionDAO = (PositionDAOImplJPA) context.getBean("positionDAO");
                helper = (Helper) context.getBean("helper");
                expectedPosition = new Position();
                expectedPosition.setName(POSITION);
        }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void test() {
                // Create
                insert();
                // Read by id
                read();
                // Read all
                readAll();
                // Update
                update();
                // Delete
                delete();
        }

        private void insert() {
                generatedId = positionDAO.insert(expectedPosition);
                assertNotNull(generatedId);
                actualPosition = helper.getByIdPosition(generatedId);
                assertEquals(expectedPosition, actualPosition);
        }

        private void read() {
                expectedPosition = positionDAO.getById(generatedId);
                assertEquals(actualPosition, expectedPosition);
        }

        private void update() {
                expectedPosition.setName(POSITION_UPD);
                positionDAO.update(expectedPosition);
                Position updatedPosition = helper.getByIdPosition(generatedId);
                assertEquals(expectedPosition, updatedPosition);
        }

        private void readAll() {
                List<Position> positionList = positionDAO.getAll();
                assertNotNull(positionList.size());
        }

        private void delete() {
                positionDAO.delete(this.actualPosition);
                Position actualPosition = helper.getByIdPosition(generatedId);
                assertNull(actualPosition);
        }
}
