package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        try {
            // 구입 금액 입력
            int amount = InputView.readPurchaseAmount();

            // 로또 여러 장 발행
            List<Lotto> lottos = lottoService.purchaseLottos(amount);

            // 발행된 로또 출력
            OutputView.printPurchasedLottos(lottos);

            // (당첨 번호 입력 및 결과 계산은 이후 단계에서 추가 예정)
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
