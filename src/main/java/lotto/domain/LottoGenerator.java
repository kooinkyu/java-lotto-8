package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    /**
     * 1~45 사이의 중복되지 않은 6개 랜덤 숫자를 생성하여 Lotto 객체를 반환한다.
     */
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
