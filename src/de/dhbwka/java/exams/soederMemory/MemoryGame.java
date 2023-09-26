package de.dhbwka.java.exams.soederMemory;

import java.util.*;

public class MemoryGame {
    private final int rows;
    private final int cols;
    private final List<Player> players;
    private final List<MemoryImages.MemoryImage> images;
    private Player currentPlayer;
    private int currentPlayerId;

    public MemoryGame(List<Player> players, List<MemoryImages.MemoryImage> images, int rows, int cols) throws MemoryException {
        this.rows = rows;
        this.cols = cols;
        if (players.size() < 2) {
            throw new MemoryException("At least two players required");
        } else {
            this.players = players;
        }
        // Liste der verfügbaren images
        if (((rows * cols) % 2) == 0) {
            if (images.size() < ((rows * cols) / 2)) {
                throw new MemoryException("Too few images available");
            } else {
                this.images = getRandomImages(images, (rows * cols));
            }
        } else {
            if (images.size() < (((rows * cols) - 1) / 2)) {
                throw new MemoryException("Too few images available");
            } else {
                this.images = getRandomImages(images, ((rows * cols) - 1)); // vl eins weniger???
            }
        }
        this.currentPlayer = this.players.get(0);
        this.currentPlayerId = 0;
    }

    private List<MemoryImages.MemoryImage> getRandomImages(List<MemoryImages.MemoryImage> allImages, int anzahl) {
        //random numbers without duplicates (save for exam)
        List<MemoryImages.MemoryImage> randomImages = new ArrayList<>();
        if (allImages.size() < anzahl) {
            throw new IllegalArgumentException("Can't ask for more numbers than are available");
        }
        Random rng = new Random();
        Set<Integer> generated = new LinkedHashSet<>();
        while (generated.size() < anzahl) {
            Integer next = rng.nextInt(allImages.size()) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }

        for (Integer a : generated) {
            randomImages.add(allImages.get(a - 1));
        }
        return randomImages;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isBlankRequired() {
        return ((rows * cols) % 2) == 1;
    }

    public void nextPlayer() {
        this.currentPlayer.setStatus(PlayerStatus.WAITING);
        if (this.currentPlayerId + 1 == players.size()) {
            this.currentPlayer = players.get(0);
            this.currentPlayerId = 0;
        } else {
            this.currentPlayer = players.get(this.currentPlayerId + 1);
            this.currentPlayerId++;
        }
        this.currentPlayer.setStatus(PlayerStatus.ACTIVE);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<MemoryImages.MemoryImage> getImages() {
        return images;
    }
}
