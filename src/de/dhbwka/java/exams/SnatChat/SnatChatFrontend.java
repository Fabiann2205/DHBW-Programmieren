package de.dhbwka.java.exams.SnatChat;

public interface SnatChatFrontend {
    public void receiveMessage(Message msg);

    public void receiveMessage(String text);

    public Account getAccount();
}
