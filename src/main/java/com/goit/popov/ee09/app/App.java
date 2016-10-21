package com.goit.popov.ee09.app;

import com.goit.popov.ee09.model.Position;
import com.goit.popov.ee09.service.PositionServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * Created by Andrey on 10/14/2016.
 */
public class App {

        private static ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-context.xml");

        public static void main(String[] args) {
                PositionServiceImpl positionDAO = applicationContext.getBean("positionService", PositionServiceImpl.class);
                System.out.println("All existing employees are: ");
                List<Position> positions = positionDAO.getPositions();
                for (Position pos : positions) {
                        System.out.println(pos.toString());
                }
                System.out.println("Finished!");
        }

}
