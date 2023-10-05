package de.dhbwka.java.exams.coronaWarn;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CoronaWarnTerm implements CoronaWarnClient {

    private final JPhone phone;
    private WarnStatus status = WarnStatus.UNKNOWN;
    private final List<Token> seenTokens = new ArrayList<>();
    private final List<Token> tokens;
    private Token currentToken;

    private JLabel seenTokensLabel;
    private final CoronaWarnClient that;


    public CoronaWarnTerm(JPhone phone) {
        this.phone = phone;
        this.that = this;
        this.tokens = CoronaWarn.loadTokens(this.phone);

        this.currentToken = new Token();
        this.tokens.add(this.currentToken);
        CoronaWarn.saveToken(this.phone, this.currentToken);
        CoronaWarnAPI.sendToken(this);

        //UI
        JFrame frame = new JFrame();
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

        //Label with current status
        JLabel topLabel = new JLabel(this.status.getText());
        topLabel.setOpaque(true);
        topLabel.setPreferredSize(new java.awt.Dimension(0, 100));
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        topLabel.setBackground(this.status.getColor());
        listPane.add(topLabel);

        //4 Buttons with the functionality
        JButton newTokenButton = new JButton("New Token");
        newTokenButton.addActionListener(e -> {
            currentToken = new Token();
            tokens.add(currentToken);
            CoronaWarn.saveToken(phone, currentToken);
            CoronaWarnAPI.sendToken(that);
            seenTokensLabel.setToolTipText(currentToken.toString());
        });

        JButton checkForInfectionsButton = new JButton("Check for infections");
        checkForInfectionsButton.addActionListener(e -> {
            if (CoronaWarnAPI.checkInfection(that)) {
                status = WarnStatus.ALARM;
            } else {
                status = WarnStatus.OK;
            }
            topLabel.setOpaque(true);
            topLabel.setBackground(status.getColor());
            topLabel.setText(status.getText());
        });

        JButton clearTokensButton = new JButton("Clear Tokens");
        clearTokensButton.addActionListener(e -> {
            tokens.clear();
            seenTokens.clear();
            CoronaWarn.clearTokenStore(phone);
            currentToken = new Token();
            tokens.add(currentToken);
            CoronaWarn.saveToken(phone, currentToken);
            CoronaWarnAPI.sendToken(that);
            seenTokensLabel.setToolTipText(currentToken.toString());
        });

        JButton reportInfectionButton = new JButton("Report Infection");
        reportInfectionButton.addActionListener(e -> {
            CoronaWarnAPI.reportInfection(that);
            status = WarnStatus.INFECTED;
            topLabel.setOpaque(true);
            topLabel.setBackground(status.getColor());
            topLabel.setText(status.getText());
            clearTokensButton.setEnabled(false);
            checkForInfectionsButton.setEnabled(false);
            newTokenButton.setEnabled(false);
        });
        listPane.add(newTokenButton);
        listPane.add(checkForInfectionsButton);
        listPane.add(clearTokensButton);
        listPane.add(reportInfectionButton);

        // label with seen tokens
        seenTokensLabel = new JLabel("Seen tokens: " + this.seenTokens.size());
        seenTokensLabel.setToolTipText(this.currentToken.toString());
        listPane.add(seenTokensLabel);

        // add stuff to UI
        frame.add(listPane);
        frame.setTitle(this.phone.owner());
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Runnable autoStart = new Runnable() {
            @Override
            public void run() {
                while (status != WarnStatus.INFECTED) {
                    try {
                        Thread.sleep(5000);
                        currentToken = new Token();
                        tokens.add(currentToken);
                        CoronaWarn.saveToken(phone, currentToken);
                        CoronaWarnAPI.sendToken(that);
                        seenTokensLabel.setToolTipText(currentToken.toString());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        new Thread(autoStart).start();


    }

    @Override
    public Token getCurrentToken() {
        return this.currentToken;
    }

    @Override
    public List<Token> getAllTokens() {
        return this.tokens;
    }

    @Override
    public List<Token> getAllSeenTokens() {
        return this.seenTokens;
    }

    @Override
    public void tokenReceived(Token token) {
        this.seenTokens.add(token);
        this.seenTokensLabel.setText("Seen Tokens: " + this.seenTokens.size());
    }


}

