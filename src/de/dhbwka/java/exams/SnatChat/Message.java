package de.dhbwka.java.exams.SnatChat;

public class Message {
    private final String text;
    private final Account from;

    public Message(String text, Account from) {
        this.text = text;
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public Account getFrom() {
        return from;
    }

    public static String rot13(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        rot13(rot13("test-message")); // encode and then decode
    }
}
