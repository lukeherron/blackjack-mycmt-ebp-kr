package com.jitterted.ebp.blackjack;

import java.util.LinkedList;

public class Player {
    private final Hand hand;
    private final Wallet wallet;
    private final LinkedList<Bet> bets;

    public Player() {
        this.hand = new Hand();
        this.wallet = new Wallet();
        this.bets = new LinkedList<>();
    }

    public void playerDeposits(int amount) {
        wallet.addMoney(amount);
    }

    public void placeBet(Bet bet) {
        // Deduct money before applying any bonus
        wallet.deductMoney(bet.amount());
        wallet.addMoney(bet.bonus());
        bets.add(bet);
    }

    public int playerBalance() {
        return wallet.balance();
    }

    public void playerWins() {
        betOutcome(2);
    }

    public void playerLoses() {
        betOutcome(0);
    }

    public void playerTies() {
        betOutcome(1);
    }

    private void betOutcome(int multiplier) {
        wallet.addMoney(currentBetAmount() * multiplier);
    }

    public Hand getHand() {
        return hand;
    }

    private int currentBetAmount() {
        return bets.getLast().amount();
    }

    public int totalBetAmount() {
        return bets.stream().mapToInt(Bet::amount).sum();
    }
}