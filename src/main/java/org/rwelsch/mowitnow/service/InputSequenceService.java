package org.rwelsch.mowitnow.service;

import org.rwelsch.mowitnow.model.*;

import java.util.ArrayList;
import java.util.List;

public class InputSequenceService {

    private final MoveService moveService;

    public InputSequenceService() {
        this.moveService = new MoveService();
    }

    public List<String> process(List<String> inputList) {
        if (inputList.isEmpty() || (inputList.size() - 1) % 2 != 0) {
            throw new IllegalArgumentException();
        }

        Grid grid = getGrid(inputList.get(0));

        List<Mower> mowerList = new ArrayList<>();
        for (int i = 1; i + 1 < inputList.size(); i = i + 2) {
            Mower mower = getMower(inputList.get(i));
            mowerList.add(mower);
            processMoves(mower, grid, inputList.get(i + 1));
        }

        return mowerList.stream().map(this::formatMower).toList();
    }

    private Grid getGrid(String input) {
        String[] gridValues = input.split(" ");
        if (gridValues.length != 2) {
            throw new IllegalArgumentException();
        }

        int x = Integer.parseInt(gridValues[0]);
        int y = Integer.parseInt(gridValues[1]);
        return Grid.builder().topRightCornerCoordinates(new Coordinates(x, y)).build();
    }

    private Mower getMower(String input) {
        String[] mowerValues = input.split(" ");
        if (mowerValues.length != 3) {
            throw new IllegalArgumentException();
        }

        int x = Integer.parseInt(mowerValues[0]);
        int y = Integer.parseInt(mowerValues[1]);
        String orientation = mowerValues[2];
        return Mower.builder().coordinates(new Coordinates(x, y)).orientation(Orientation.valueOf(orientation)).build();
    }

    private void processMoves(Mower mower, Grid grid, String inputStr) {
        inputStr.chars().mapToObj(c -> Input.valueOf(String.valueOf((char) c))).forEach(input -> moveService.move(mower, grid, input));
    }

    private String formatMower(Mower mower) {
        return String.format("%s %s %s", mower.getCoordinates().x(), mower.getCoordinates().y(), mower.getOrientation().toString());
    }
}
