package com.jitterted.ebp.blackjack;

public class Player {
    private final Hand hand;
    private final Wallet wallet;
    private int playerBet;

    public Player() {
        this.hand = new Hand();
        this.wallet = new Wallet();
        this.playerBet = 0;
    }

    public void playerDeposits(int amount) {
        wallet.addMoney(amount);
    }

    public void playerBets(int betAmount) {
        playerBet = betAmount;
        wallet.bet(betAmount);
    }

    public int playerBalance() {
        return wallet.balance();
    }

    public void playerWins() {
        wallet.addMoney(playerBet * 2);
    }

    public void playerLoses() {
        wallet.addMoney(playerBet * 0);
    }

    public void playerTies() {
        wallet.addMoney(playerBet * 1);
    }

    public Hand getHand() {
        return hand;
    }
}