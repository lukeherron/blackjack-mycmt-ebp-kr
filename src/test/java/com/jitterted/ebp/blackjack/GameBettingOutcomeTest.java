package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Game game = createGameWithPlayerBalanceOf(20);
    game.getPlayer().placeBet(new Bet(10));

    game.getPlayer().playerWins();

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Game game = createGameWithPlayerBalanceOf(80);
    game.getPlayer().placeBet(new Bet(70));

    game.getPlayer().playerTies();

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Game game = createGameWithPlayerBalanceOf(35);

    game.getPlayer().placeBet(new Bet(30));
    game.getPlayer().playerLoses();

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Game game = createGameWithPlayerBalanceOf(40);

    game.getPlayer().placeBet(new Bet(15));

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerWith200Bets100Receives10BetBonusBalanceIs110() throws Exception {
    Game game = createGameWithPlayerBalanceOf(200);

    game.getPlayer().placeBet(new Bet(100));

    assertThat(game.getPlayer().playerBalance())
            .isEqualTo(110);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Game game = createGameWithPlayerBalanceOf(18);

    assertThat(game.getPlayer().playerBalance())
        .isEqualTo(18);
  }


  private Game createGameWithPlayerBalanceOf(int amount) {
    Game game = new Game();
    game.getPlayer().playerDeposits(amount);
    return game;
  }
}