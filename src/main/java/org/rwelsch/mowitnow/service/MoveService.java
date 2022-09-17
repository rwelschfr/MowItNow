package org.rwelsch.mowitnow.service;

import org.rwelsch.mowitnow.model.*;

public class MoveService {

    public void move(Mower mower, Grid grid, Input input) {
        switch (input) {
            case A -> goForward(mower, grid);
            case D -> rotateRight(mower);
            case G -> rotateLeft(mower);
        }
    }

    private void goForward(Mower mower, Grid grid) {
        switch (mower.getOrientation()) {
            case N -> goNorth(mower, grid.getTopRightCornerCoordinates().y());
            case E -> goEast(mower, grid.getTopRightCornerCoordinates().x());
            case W -> goWest(mower);
            case S -> goSouth(mower);
        }
    }

    private void goNorth(Mower mower, int maxY) {
        if (mower.getCoordinates().y() < maxY) {
            mower.setCoordinates(new Coordinates(mower.getCoordinates().x(), mower.getCoordinates().y() + 1));
        }
    }

    private void goEast(Mower mower, int maxX) {
        if (mower.getCoordinates().x() < maxX) {
            mower.setCoordinates(new Coordinates(mower.getCoordinates().x() + 1, mower.getCoordinates().y()));
        }
    }

    private void goWest(Mower mower) {
        if (mower.getCoordinates().x() > 0) {
            mower.setCoordinates(new Coordinates(mower.getCoordinates().x() - 1, mower.getCoordinates().y()));
        }
    }

    private void goSouth(Mower mower) {
        if (mower.getCoordinates().y() > 0) {
            mower.setCoordinates(new Coordinates(mower.getCoordinates().x(), mower.getCoordinates().y() - 1));
        }
    }

    private void rotateRight(Mower mower) {
        switch (mower.getOrientation()) {
            case N -> mower.setOrientation(Orientation.E);
            case E -> mower.setOrientation(Orientation.S);
            case W -> mower.setOrientation(Orientation.N);
            case S -> mower.setOrientation(Orientation.W);
        }
    }

    private void rotateLeft(Mower mower) {
        switch (mower.getOrientation()) {
            case N -> mower.setOrientation(Orientation.W);
            case E -> mower.setOrientation(Orientation.N);
            case W -> mower.setOrientation(Orientation.S);
            case S -> mower.setOrientation(Orientation.E);
        }
    }
}
