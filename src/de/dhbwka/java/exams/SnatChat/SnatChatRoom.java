package de.dhbwka.java.exams.SnatChat;

import de.ownclasses.TextFileNew;

import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {
    private String name;
    private List<SnatChatFrontend> registeredDevices;

    private TextFileNew file;

    public SnatChatRoom(String name) {
        this.name = name;
        registeredDevices = new ArrayList<>(); // WICHTIG: INITIALISIEREN
        this.file = new TextFileNew("resources/" + this.name + ".txt");
    }

    public String getRoomName() {
        return this.name;
    }

    public void register(SnatChatFrontend s) {
        this.registeredDevices.add(s);
    }

    public void unregister(SnatChatFrontend s) {
        this.registeredDevices.remove(s);

    }

    public void sendMessage(Message msg) {
        for (SnatChatFrontend x : this.registeredDevices) { // siehe SnatChatFrontend Interface...
            x.receiveMessage(msg);
        }
        this.file.addLine(Message.rot13(msg.getFrom().getName() + ": " + msg.getText()));
    }

    public void sendMessage(String text) {
        for (SnatChatFrontend x : this.registeredDevices) { // siehe SnatChatFrontend Interface...
            x.receiveMessage(text);
        }
        this.file.addLine(Message.rot13(text));
    }

}
