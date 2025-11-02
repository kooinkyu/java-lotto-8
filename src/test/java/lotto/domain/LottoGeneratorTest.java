package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    private final LottoGenerator generator = new LottoGenerator();

    @RepeatedTest(5) // 테스트를 여러 번 반복해서 랜덤 로직의 일관성을 검증
    @DisplayName("로또 생성기는 1~45 사이의 중복되지 않은 6개 번호를 생성한다")
    void generateRandomLotto() {
        Lotto lotto = generator.generate();

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }
}
