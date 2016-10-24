package com.goit.popov.ee09.service;

import com.goit.popov.ee09.model.Position;

import java.util.List;

/**
 * Created by Andrey on 20.10.2016.
 */
public class PositionServiceImpl {

        private List<Position> positions;

        public List<Position> getPositions() {
                return positions;
        }

        public void setPositions(List<Position> positions) {
                this.positions = positions;
        }
}
