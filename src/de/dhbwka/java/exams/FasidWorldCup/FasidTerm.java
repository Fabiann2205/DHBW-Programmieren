package de.dhbwka.java.exams.FasidWorldCup;

import de.dhbwka.java.exams.dartsV2.ownclasses.TextFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FasidTerm implements CorruptionPrevention {

    private List<Match> matches = new ArrayList<>();
    private TextFile file = new TextFile("resources/fasid.txt");
    private List<Player> players = new ArrayList<>();
    private List<JButton> jbuttonsPlayers = new ArrayList<>();
    private JTextArea area;
    private FasidAlarmLabel alarmLabel;

    public FasidTerm(List<Match> matches, Player[] players) throws FasidException {
        if (matches.isEmpty() || players.length == 0) {
            throw new FasidException("Keine Spieler oder matches gegeben!");
        }
        this.matches = matches;
        this.players = List.of(players);


        // put these objects in a class scope if there are problems
        JFrame frame = new JFrame();
        JPanel topPane = new JPanel();
        JPanel centerPane = new JPanel();
        JPanel bottomPane = new JPanel();

        topPane.setLayout(new GridLayout(this.players.size(), 1));


        for (Player p : this.players) {
            JButton button = new JButton("Start betting, player " + p.getName() + "!");
            ActionListener actionListener = e -> {
                System.out.println("Button was pressed!");
                JButton buttons = (JButton) e.getSource();
                try {
                    new BettingTerm(p, this, this.matches);
                } catch (FasidException ex) {
                    System.out.println("Fehler");
                }
                buttons.setEnabled(false);
            };
            button.addActionListener(actionListener);
            jbuttonsPlayers.add(button);
            topPane.add(button);
        }


        area = new JTextArea(5, 20);
        centerPane.add(area);

        alarmLabel = new FasidAlarmLabel();
        bottomPane.add(alarmLabel);

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

        frame.setTitle("FA$ID® World Cup");
        frame.setSize(1000, 500);
        // frame.pack(); // auto sizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // add bet!
    public void reportBet(Player player, Match match) {
        this.area.append("\n Player" + player.getName() + " bets " + match.getResultType().toString() + " on match " + match.toString()); // add bet!
        if (match.getResultType() == ResultType.FASID) {
            Random random = new Random();
            if (random.nextInt(1, 11) <= 3) {
                this.alarmLabel.setFasidAlarm(player.getName());
            }
        }
        file.addLine(player.getName() + " bets " + match.getResultType().toString() + " on match " + match.toString());

        Runnable stop = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }
                hideFasidAlarm();
            }
        };
        new Thread(stop).start();
    }

    public void hideFasidAlarm() {
        this.alarmLabel.hideFasidAlam();
    }

    @Override
    public void fasid(Player player) {

    }
}
