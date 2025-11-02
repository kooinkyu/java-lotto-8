package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.Lotto;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("금액이 1000원 단위이면 올바른 개수의 로또가 발행된다")
    void purchaseLottos_validAmount() {
        List<Lotto> lottos = lottoService.purchaseLottos(5000);
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다")
    void purchaseLottos_amountTooLow() {
        assertThatThrownBy(() -> lottoService.purchaseLottos(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
    void purchaseLottos_notDivisibleBy1000() {
        assertThatThrownBy(() -> lottoService.purchaseLottos(5500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
