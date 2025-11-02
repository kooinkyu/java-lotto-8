package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("1~45 범위 내의 숫자는 정상적으로 생성된다")
    void createValidNumber() {
        LottoNumber number = new LottoNumber(10);
        assertThat(number.getNumber()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 번호가 1 미만일 경우 예외가 발생한다")
    void throwExceptionWhenNumberLessThanOne() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호가 45 초과일 경우 예외가 발생한다")
    void throwExceptionWhenNumberGreaterThan45() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("같은 번호는 equals/hashCode로 동일하게 인식된다")
    void equalityCheck() {
        LottoNumber a = new LottoNumber(5);
        LottoNumber b = new LottoNumber(5);
        assertThat(a).isEqualTo(b);
        assertThat(a.hashCode()).isEqualTo(b.hashCode());
    }
}
