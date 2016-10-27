package com.goit.popov.ee09.dao.impl;

import com.goit.popov.ee09.dao.entity.PositionDAO;
import com.goit.popov.ee09.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 20.10.2016.
 */
public class PositionDAOImpl implements PositionDAO {

        private DataSource dataSource;

        public List<Position> positions;

        private static final Logger LOGGER = LoggerFactory.getLogger(PositionDAOImpl.class);

        private static final String SELECT_ALL_SQL = "SELECT *" +
                " FROM position";

        public void setDataSource(DataSource dataSource) {
                this.dataSource = dataSource;
        }

        public void setPositions(List<Position> positions) {
                this.positions = positions;
        }

        @Override
        public int insert(Position position) {
                return 0;
        }

        @Override
        public void update(Position position) {

        }

        @Override
        public List<Position> getAll() {
                List<Position> positions = new ArrayList<>();
                Position position;
                try (Connection connection = dataSource.getConnection();
                     Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
                        while (resultSet.next()) {
                                position = new Position();
                                position.setId(resultSet.getInt("id"));
                                position.setName(resultSet.getString("title"));
                                positions.add(position);
                        }
                        LOGGER.info("Got all positions");
                } catch (SQLException ex) {
                        LOGGER.error(ex.getMessage());
                        throw new RuntimeException(ex);
                }
                return positions;
        }

        @Override
        public Position getById(int id) {
                return null;
        }

        @Override
        public void delete(Position position) {

        }
}
