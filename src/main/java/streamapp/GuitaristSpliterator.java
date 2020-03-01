package main.java.streamapp;

import java.util.Spliterator;
import java.util.function.Consumer;

public class GuitaristSpliterator implements Spliterator<GuitaristDetails> {
    private final Spliterator<String> lineSpliterator;
    private String name;
    private String model;
    private String make;

    public GuitaristSpliterator(Spliterator<String> lineSpliterator) {
        this.lineSpliterator = lineSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super GuitaristDetails> action) {
        if (this.lineSpliterator.tryAdvance(line -> this.name = line) &&
            this.lineSpliterator.tryAdvance(line -> this.model  = line) &&
            this.lineSpliterator.tryAdvance(line -> this.make = line)) {
            GuitaristDetails guitaristDetails = new GuitaristDetails(name, model, make);
            action.accept(guitaristDetails);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<GuitaristDetails> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return lineSpliterator.estimateSize() / 3;
    }

    @Override
    public int characteristics() {
        return lineSpliterator.characteristics();
    }
}

