import io.github.sogoagain.model.CardDeck;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CardDeckTest {
    @Test
    public void test_CardDeckInitTest() throws Exception {
        CardDeck deck = new CardDeck();

        deck.init();
        deck.shuffle();
        deck.popCard();

        assertThat(deck.size()).isEqualTo(51);
    }
}