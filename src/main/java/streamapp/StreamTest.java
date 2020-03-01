package main.java.streamapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamTest {
    public static void main(String[] args) {
        Path path = Paths.get("./resources/guitarist_data.txt");
        try(Stream<String> lines = Files.lines(path)){
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<GuitaristDetails> guitaristDetailsSpliterator = new GuitaristSpliterator(lineSpliterator);
            Stream<GuitaristDetails> guitarDetails = StreamSupport.stream(guitaristDetailsSpliterator, false);
            guitarDetails.forEach(g ->
                    System.out.printf("Name: %s Make: %s Model: %s\n", g.getName(), g.getMake(), g.getModel())
            );

        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
    }
}
