package org.rwelsch.mowitnow.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rwelsch.mowitnow.model.*;

public class MoveServiceTest {

    private MoveService moveService;

    @BeforeEach
    public void setup() {
        this.moveService = new MoveService();
    }

    @Test
    public void testGoForward() {
        // Given
        Mower mower = Mower.builder()
                .coordinates(new Coordinates(0, 0))
                .orientation(Orientation.N)
                .build();
        Grid grid = Grid.builder()
                .topRightCornerCoordinates(new Coordinates(1, 1))
                .build();
        Input input = Input.A;

        // When
        this.moveService.move(mower, grid, input);

        // Then
        Assertions.assertEquals(mower.getCoordinates().y(), 1);
    }

    @Test
    public void testRotate() {
        // Given
        Mower mower = Mower.builder()
                .coordinates(new Coordinates(0, 0))
                .orientation(Orientation.N)
                .build();
        Grid grid = Grid.builder()
                .topRightCornerCoordinates(new Coordinates(1, 1))
                .build();
        Input input = Input.D;

        // When
        this.moveService.move(mower, grid, input);

        // Then
        Assertions.assertEquals(mower.getOrientation(), Orientation.E);
    }

    @Test
    public void testGoForwardFails() {
        // Given
        Mower mower = Mower.builder()
                .coordinates(new Coordinates(0, 1))
                .orientation(Orientation.N)
                .build();
        Grid grid = Grid.builder()
                .topRightCornerCoordinates(new Coordinates(1, 1))
                .build();
        Input input = Input.A;

        // When
        this.moveService.move(mower, grid, input);

        // Then
        Assertions.assertEquals(mower.getCoordinates().y(), 1); // didn't move
    }
}
