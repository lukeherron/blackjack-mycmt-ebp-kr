package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    public void noBetsPlacedTotalBetAmountIs0() {
        Player player = createPlayerWithBalanceOf(0);

        assertThat(player.totalBetAmount()).isEqualTo(0);
    }

    @Test
    public void playerBetsInitial10TotalBetAmountIs10() {
        Player player = createPlayerWithBalanceOf(10);

        player.placeBet(new Bet(10));

        assertThat(player.totalBetAmount()).isEqualTo(10);
    }

    @Test
    public void playerPlaces3BetsOf10TotalBetAmountIs30() {
        Player player = createPlayerWithBalanceOf(30);

        player.placeBet(new Bet(10));
        player.placeBet(new Bet(10));
        player.placeBet(new Bet(10));

        assertThat(player.totalBetAmount()).isEqualTo(30);
    }

    private Player createPlayerWithBalanceOf(int amount) {
        Player player = new Player();
        player.playerDeposits(amount);
        return player;
    }
}
