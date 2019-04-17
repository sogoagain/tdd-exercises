import io.github.sogoagain.model.Card;
import io.github.sogoagain.model.CardHand;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CardHandTest {
    @Test
    public void test_CardHand1stCase() throws Exception {
        CardHand cardHand = new CardHand();
        cardHand.add(Card.of(Card.Suit.SPADE, Card.Rank.JACK));

        assertThat(cardHand.getPoint()).isEqualTo(10);
    }

    @Test
    public void test_CardHandAceCalibrationCase() throws Exception {
        CardHand cardHand = new CardHand();
        cardHand.add(Card.of(Card.Suit.SPADE, Card.Rank.ACE));
        cardHand.add(Card.of(Card.Suit.CLUB, Card.Rank.TWO));

        assertThat(cardHand.getPoint()).isEqualTo(13);
    }

    @Test
    public void test_CardHandAceDefaultCase() throws Exception {
        CardHand cardHand = new CardHand();
        cardHand.add(Card.of(Card.Suit.CLUB, Card.Rank.NINE));
        cardHand.add(Card.of(Card.Suit.HEART, Card.Rank.NINE));
        cardHand.add(Card.of(Card.Suit.SPADE, Card.Rank.ACE));

        System.out.println(cardHand);

        assertThat(cardHand.getPoint()).isEqualTo(19);
    }
}