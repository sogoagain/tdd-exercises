import io.github.sogoagain.model.Card;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CardTest {
    @Test
    public void test_CardGenTest() throws Exception {
        Card club8_1 = Card.of(Card.Suit.CLUB, Card.Rank.EIGHT);
        Card club8_2 = Card.of(Card.Suit.CLUB, Card.Rank.EIGHT);

        assertThat(club8_1 == club8_2).isEqualTo(true);
    }

    @Test
    public void test_ToStringTest() throws Exception {
        Card card = Card.of(Card.Suit.SPADE, Card.Rank.JACK);

        assertThat(card.toString()).isEqualTo("♠J");
    }
}