package com.jitterted.ebp.blackjack;

public class Bet {
    private final int amount;

    public Bet(int amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }
}