package de.dhbwka.java.exams.soederMemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class MemoryGameTerm {
    private MemoryGame game;
    private volatile int clicked = 0;
    public MemoryGameTerm(MemoryGame game) {
        this.game = game;

        // UI
        JFrame frame = new JFrame();
        JPanel listPane = new JPanel();
        JPanel imagePane = new JPanel();
        frame.setLayout(new BorderLayout());

        // add player statistics
        List<Player> players = this.game.getPlayers();
        listPane.setLayout(new GridLayout(players.size(),0)); // set rows to the count of players
        List<JLabel> labels = new ArrayList<>();
        for(int i = 0; i<players.size(); i++) {
            labels.add(new JLabel(players.get(i).getName() + "(" + players.get(i).getPoints() + ")"));
            if (players.get(i).getStatus() == PlayerStatus.ACTIVE) {
                labels.get(i).setForeground(Color.yellow);
            }
            listPane.add(labels.get(i));
        }

        // add field of JToggleButtons
        imagePane.setLayout(new GridLayout(this.game.getRows(),this.game.getCols())); // set rows to the count of players
        List<JToggleButton> toggleButtons = new ArrayList<>();
        int sizeOfField = this.game.getImages().size();
        JToggleButton button1, button2;
        for(int i = 0; i<sizeOfField; i++) {
            button1 = new JToggleButton(String.valueOf(i), MemoryImages.getBackside());
            button2 = new JToggleButton(String.valueOf(i), MemoryImages.getBackside());
            ItemListener itemListener = itemEvent -> {
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
                    JToggleButton item = (JToggleButton) itemEvent.getItem();
                    item.setIcon(game.getImages().get(Integer.parseInt(item.getText())).getImage());
                    clicked++;
                }
                else {
                    System.out.println("Deselected");
                    JToggleButton item = (JToggleButton) itemEvent.getItem();
                    item.setIcon(MemoryImages.getBackside());
                }
            };
            button1.addItemListener(itemListener);
            button2.addItemListener(itemListener);
            toggleButtons.add(button1);
            toggleButtons.add(button2);
        }

        Random rng = new Random();
        Set<Integer> generated = new LinkedHashSet<Integer>();
        while (generated.size() < toggleButtons.size())
        {
            Integer next = rng.nextInt(toggleButtons.size()) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }
        for (Integer a : generated) {
            imagePane.add(toggleButtons.get(a-1));
        }







        // add stuff to UI
        frame.add(listPane, BorderLayout.PAGE_START);
        frame.add(imagePane, BorderLayout.CENTER);
        frame.setTitle("Soeder Memory");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.game();
    }

    private void game() {
        while(true) {
            while (clicked < 2) {
                Thread.onSpinWait();
            }
            if ()
            this.game.getCurrentPlayer();
        }
    }


}
