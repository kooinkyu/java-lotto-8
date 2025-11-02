package lotto.service;

import lotto.domain.LottoGenerator;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    /**
     * 입력 금액에 따라 로또를 여러 장 생성한다.
     * @param amount 사용자가 입력한 금액
     * @return 생성된 로또 리스트
     */
    public List<Lotto> purchaseLottos(int amount) {
        validateAmount(amount);

        int count = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoGenerator.generate();
            lottos.add(lotto);
        }
        return lottos;
    }

    /**
     * 로또 구입 금액 유효성 검증
     *  - 1000원 미만이거나 1000원 단위가 아닐 경우 예외 발생
     */
    private void validateAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
