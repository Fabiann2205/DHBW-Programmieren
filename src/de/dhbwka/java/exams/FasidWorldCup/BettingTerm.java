package de.dhbwka.java.exams.FasidWorldCup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BettingTerm {
    private Player player;
    private FasidTerm fasidTerm;
    private List<Match> matches;
    private JLabel labelMatch, moreInformation;
    private Match currentMatch;

    private ButtonGroup btn;
    private List<JRadioButton> radioButtons = new ArrayList<>();

    public BettingTerm(Player player, FasidTerm fasidTerm, List<Match> matches) throws FasidException {
        this.player = player;
        this.fasidTerm = fasidTerm;
        this.matches = matches;

        for (Match m : matches) {
            if (m.getResultType() == ResultType.UNKNOWN) {
                currentMatch = m;
            } else {
                throw new FasidException("no match to bet on");
            }
        }
        // put these objects in a class scope if there are problems
        JFrame frame = new JFrame();
        JPanel topPane = new JPanel();
        JPanel centerPane = new JPanel();
        JPanel bottomPane = new JPanel();


        topPane.setLayout(new GridLayout(2, 1));
        labelMatch = new JLabel(currentMatch.toString());
        topPane.add(labelMatch);
        moreInformation = new JLabel(currentMatch.getDate() + " - " + currentMatch.getTime() + "@" + currentMatch.getStadium());
        topPane.add(moreInformation);


        //radiobutton
        btn = new ButtonGroup();            //für 1 anklickbaren button
        for (int i = 0; i < 4; i++) {
            JRadioButton radio = new JRadioButton(ResultType.values()[i + 1].toString());
            btn.add(radio);
            radioButtons.add(radio);
            centerPane.add(radio);
        }

        JButton sendButton = new JButton("Bet");
        ActionListener actionListener = e -> {
            System.out.println("Button was pressed!");
            int i = 0;
            for (JRadioButton r : radioButtons) {
                if (r.isSelected()) {
                    break;
                }
                i++;
            }
            switch (i) {
                case 0:
                    this.currentMatch.setResultType(ResultType.DRAW);
                    break;
                case 1:
                    this.currentMatch.setResultType(ResultType.HOME);
                    break;
                case 2:
                    this.currentMatch.setResultType(ResultType.GUEST);
                    break;
                case 3:
                    this.currentMatch.setResultType(ResultType.FASID);
                    break;
            }

            this.fasidTerm.reportBet(this.player, this.currentMatch);
            for (Match m : this.matches) {
                if (m.getResultType() == ResultType.UNKNOWN) {
                    this.currentMatch = m;
                } else {
                    sendButton.setEnabled(false);
                }
            }

            labelMatch.setText(currentMatch.toString());

            moreInformation.setText(currentMatch.getDate() + " - " + currentMatch.getTime() + "@" + currentMatch.getStadium());


            //buttons.setEnabled(true);
        };
        sendButton.addActionListener(actionListener);
        bottomPane.add(sendButton);

        frame.setLayout(new BorderLayout());
                        /* other Layouts:
                            - BorderLayout
                            - BoxLayout
                            - CardLayout
                            - FlowLayout
                            - GridBagLayout
                            - GridLayout
                            - GroupLayout
                         */

        frame.add(topPane, BorderLayout.NORTH);
        frame.add(centerPane, BorderLayout.CENTER);
        frame.add(bottomPane, BorderLayout.SOUTH);

        frame.setTitle(this.player.getName() + " Betting Term");
        frame.setSize(1000, 500);
        //frame.pack(); // auto sizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
