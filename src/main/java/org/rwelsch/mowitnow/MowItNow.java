package org.rwelsch.mowitnow;

import org.rwelsch.mowitnow.service.InputSequenceService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MowItNow {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalStateException();
        }
        Path path = Path.of(args[0]);

        InputSequenceService inputSequenceService = new InputSequenceService();
        List<String> mowersData = inputSequenceService.process(Files.readAllLines(path, Charset.defaultCharset()));
        System.out.println(String.join(" ", mowersData));
    }
}
