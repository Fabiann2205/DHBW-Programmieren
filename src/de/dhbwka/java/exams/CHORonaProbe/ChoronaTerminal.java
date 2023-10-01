package de.dhbwka.java.exams.CHORonaProbe;

import de.ownclasses.TextFileNew;
import de.ownclasses.exceptions.IOErrorInFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChoronaTerminal implements Runnable {
    private Variant variant;
    private Room room;
    private Thread thread;
    private JLabel stepsLabel;
    private List<CellButton> cellButtons;
    private JButton stepButton, playButton, saveButton;
    private JPanel centerPane;

    public ChoronaTerminal(Variant variant, Room room) {
        this.variant = variant;
        this.room = room;
        ChoronaTerminal that = this;

        // UI
        JFrame frame = new JFrame();
        JPanel topPane = new JPanel();
        topPane.setBorder(BorderFactory.createEmptyBorder(200, 20, 20, 10));
        centerPane = new JPanel();
        centerPane.setLayout(new GridLayout(this.room.getSetting().getHeight(), this.room.getSetting().getWidth()));
        JPanel bottomPane = new JPanel();
        frame.setLayout(new BorderLayout());

        // top of UI
        stepsLabel = new JLabel("Steps: " + this.room.getSteps());
        topPane.add(stepsLabel);

        // center of UI
        cellButtons = new ArrayList<>();
        CellButton button;
        for (int i = 0; i < this.room.getSetting().getWidth(); i++) {
            for (int j = 0; j < this.room.getSetting().getHeight(); j++) {
                button = new CellButton(String.valueOf(i + j), i, j);
                button.setPolluter(false);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                for (Point p : this.room.getSetting().getPolluters()) {
                    if (p.equals(new Point(i, j))) {
                        button.setPolluter(true);
                        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
                    }
                }
                Chorona.updateButtonForDose(button, this.room.getDose(i, j));
                button.setOpaque(true);
                // ItemListener itemListener = itemEvent -> {};
                // button.addItemListener(itemListener);
                cellButtons.add(button);
                centerPane.add(button);
            }
        }


        // bottom of UI
        stepButton = new JButton("Step");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stepAction();
            }
        };

        stepButton.addActionListener(actionListener);

        playButton = new JButton("Play");
        ActionListener actionListenerPlay = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButton.setEnabled(false);
                thread = new Thread(that);
                thread.start();
            }
        };

        playButton.addActionListener(actionListenerPlay);

        saveButton = new JButton("Save");
        ActionListener saveActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFileNew textFileNew = new TextFileNew("resources/CHORona/" + variant.getLabel() + "-" + room.getSetting().getWidth() + "-" + room.getSetting().getHeight() + "-" + room.getSetting().getPolluters().length + "-" + room.getSteps() + ".txt");
                List<String> liste = new ArrayList<>();

                for (int i = 0; i < room.getSetting().getWidth(); i++) {
                    for (int j = 0; j < room.getSetting().getHeight(); j++) {
                        liste.add(j + "; " + i + "; " + room.getDose(i, j));
                    }
                }

                try {
                    textFileNew.writeAllLines(liste);
                    JOptionPane.showMessageDialog(frame,
                            "Successful created file " + variant.getLabel() + "-" + room.getSetting().getWidth() + "-" + room.getSetting().getHeight() + "-" + room.getSetting().getPolluters().length + "-" + room.getSteps() + ".txt");
                } catch (IOErrorInFile ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Error creating file " + variant.getLabel() + "-" + room.getSetting().getWidth() + "-" + room.getSetting().getHeight() + "-" + room.getSetting().getPolluters().length + "-" + room.getSteps() + ".txt",
                            "Insane error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        saveButton.addActionListener(saveActionListener);

        bottomPane.add(stepButton);
        bottomPane.add(playButton);
        bottomPane.add(saveButton);


        // add stuff to UI
        frame.add(topPane, BorderLayout.PAGE_START);
        frame.add(centerPane, BorderLayout.CENTER);
        frame.add(bottomPane, BorderLayout.PAGE_END);
        frame.setTitle("Chorona - " + this.variant.getLabel() + " (" + this.variant.getDesignation() + ")");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void stepAction() {
        room.step();
        stepsLabel.setText("Steps: " + room.getSteps());
        for (CellButton bu : cellButtons) {
            Chorona.updateButtonForDose(bu, room.getDose(bu.getPositionX(), bu.getPositionY()));
        }
    }

    @Override
    public void run() {
        saveButton.setEnabled(false);
        stepButton.setEnabled(false);
        for (int st = 0; st < 20; st++) {
            stepAction();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        saveButton.setEnabled(true);
        stepButton.setEnabled(true);
        playButton.setEnabled(true);
    }
}
