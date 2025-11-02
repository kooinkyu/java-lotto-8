package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

class LottoTest {

    @Test
    @DisplayName("로또 번호 6개가 정상적으로 생성되면 예외가 발생하지 않는다")
    void createValidLotto() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    void throwExceptionWhenInvalidSize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void throwExceptionWhenDuplicatedNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    void throwExceptionWhenNumberOutOfRange() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬된다")
    void numbersShouldBeSorted() {
        List<Integer> numbers = Arrays.asList(6, 3, 1, 4, 2, 5);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
