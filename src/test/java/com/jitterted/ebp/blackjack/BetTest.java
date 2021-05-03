package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BetTest {

    @Test
    public void betting0DollarsThrowsException() {

       assertThatThrownBy(() -> new Bet(0))
               .isInstanceOf(IllegalArgumentException.class);
    }
}
