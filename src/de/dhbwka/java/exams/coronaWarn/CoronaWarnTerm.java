package de.dhbwka.java.exams.coronaWarn;

import java.util.List;

public class CoronaWarnTerm implements CoronaWarnClient{

    private JPhone phone;
    private WarnStatus status = WarnStatus.UNKNOWN;
    private List<Token> seenTokens;
    private List<Token> tokens = CoronaWarn.loadTokens(this.phone);
    private Token currentToken;

    public CoronaWarnTerm(JPhone phone) {
        this.phone = phone;
    }

    @Override
    public Token getCurrentToken() {
        return null;
    }

    @Override
    public List<Token> getAllTokens() {
        return null;
    }

    @Override
    public List<Token> getAllSeenTokens() {
        return null;
    }

    @Override
    public void tokenReceived(Token token) {

    }
}
