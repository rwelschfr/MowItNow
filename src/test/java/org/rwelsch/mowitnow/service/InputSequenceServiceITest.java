package org.rwelsch.mowitnow.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InputSequenceServiceITest {

    private InputSequenceService inputSequenceService;

    @BeforeEach
    public void setup() {
        this.inputSequenceService = new InputSequenceService();
    }

    @Test
    public void testProcess() {
        // Given
        List<String> inputList = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");

        // When
        List<String> result = this.inputSequenceService.process(inputList);

        // Then
        Assertions.assertEquals(result, List.of("1 3 N", "5 1 E"));
    }
}
