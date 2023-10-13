package de.dhbwka.java.exams.SnatChat;

import exam.ownclasses.TextFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SnatChatWindow extends JFrame implements SnatChatFrontend {

    private final Account account;

    private final ChatMessagesComponent msgComp;


    public SnatChatWindow(SnatChatRoom snatChatRoom, Account account) {
        this.account = account;
        this.msgComp = new ChatMessagesComponent();
        TextFile file = new TextFile("resources/" + snatChatRoom.getRoomName() + ".txt");
        try {
            for (int i = 0; ((i + file.availableLines() - 10) < file.availableLines() && file.availableLines() > 9) || (file.availableLines() < 10 && i < 10); i++) {
                JLabel lbl;
                if (file.availableLines() > 9) {
                    lbl = new JLabel(Message.rot13(file.getLine(i + file.availableLines() - 10)));
                } else {
                    lbl = new JLabel(Message.rot13(file.getLine(i)));
                }

                lbl.setForeground(Color.GRAY);
                msgComp.add(lbl);
            }
        } catch (Exception ignored) {

        }

        this.setTitle(account.getName() + " (" + snatChatRoom.getRoomName() + ")");

        JLabel lblAccName = new JLabel(account.getName());
        lblAccName.setForeground(account.getColor());
        this.add(lblAccName, BorderLayout.NORTH);

        JPanel panState = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup grp = new ButtonGroup();
        for (State state : State.values()) {
            JRadioButton btn = new JRadioButton(state.getLabel());
            if (state == State.AVAILABLE)
                btn.setSelected(true);
            grp.add(btn);
            panState.add(btn);
            btn.addActionListener(e -> {
                account.setState(state);
                snatChatRoom.sendMessage("state of " + account.getName() + " is now " + account.getState().getLabel());
            });
        }

        JPanel panCenter = new JPanel(new BorderLayout());
        panCenter.add(this.msgComp, BorderLayout.CENTER);
        panCenter.add(panState, BorderLayout.SOUTH);
        this.add(panCenter, BorderLayout.CENTER);

        JPanel panInput = new JPanel(new BorderLayout());
        JTextField txtInput = new JTextField();
        JButton btnSend = new JButton(("Send"));
        ActionListener listener = e -> {

            String text = txtInput.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(btnSend, account.getName() + ", input sth");
            } else {
                Message msg = new Message(text, account);
                snatChatRoom.sendMessage(msg);
            }

        };
        btnSend.addActionListener(listener);
        txtInput.addActionListener(listener); // send via enter button
        panInput.add(txtInput, BorderLayout.CENTER);
        panInput.add(btnSend, BorderLayout.EAST);
        this.add(panInput, BorderLayout.SOUTH);

        // this.pack();
        this.setSize(800, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void receiveMessage(Message msg) {
        JLabel lbl = new JLabel(msg.getFrom().getName() + ": " + msg.getText());
        lbl.setForeground(Color.GRAY);
        this.msgComp.add(lbl);
        Runnable countdown = () -> {
            int start = 30;
            String origText = lbl.getText();
            for (int i = start; i > 0; i--) {
                lbl.setText(origText + " [" + i + "]");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            msgComp.remove(lbl);
        };

        new Thread(countdown).start();
    }


    @Override
    public void receiveMessage(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setForeground(Color.GRAY);
        this.msgComp.add(lbl);
        Runnable countdown = () -> {
            int start = 30;
            String origText = lbl.getText();
            for (int i = start; i > 0; i--) {
                lbl.setText(origText + " [" + i + "]");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            msgComp.remove(lbl);
        };

        new Thread(countdown).start();
    }

    @Override
    public Account getAccount() {
        return this.account;
    }
}
