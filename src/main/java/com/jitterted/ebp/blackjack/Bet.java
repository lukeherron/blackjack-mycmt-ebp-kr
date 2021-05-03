package com.jitterted.ebp.blackjack;

public class Bet {
    private static final int BONUS_THRESHOLD = 100;
    private static final int BONUS_AMOUNT = 10;

    private final int amount;

    public Bet(int amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public int bonus() {
        return amount >= BONUS_THRESHOLD ? BONUS_AMOUNT : 0;
    }
}