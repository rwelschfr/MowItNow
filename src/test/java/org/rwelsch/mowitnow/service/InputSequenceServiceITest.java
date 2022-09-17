package org.rwelsch.mowitnow.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class InputSequenceServiceITest {

    private InputSequenceService inputSequenceService;

    @BeforeEach
    public void setup() {
        this.inputSequenceService = new InputSequenceService();
    }

    public void testProcess() {
        // Given
        String inputSequence = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA\n";

        // When
        String result = this.inputSequenceService.process(inputSequence);

        // Then
        Assertions.assertEquals(result, "1 3 N\n5 1 E\n");
    }
}
