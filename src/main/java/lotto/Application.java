package lotto;

import lotto.domain.LottoResult;
import lotto.domain.ProfitCalculator;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        try {
            int amount = InputView.readPurchaseAmount();
            List<Lotto> lottos = lottoService.purchaseLottos(amount);
            OutputView.printPurchasedLottos(lottos);

            List<Integer> winningNumbers = InputView.readWinningNumbers();
            int bonusNumber = InputView.readBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            LottoResult result = new LottoResult(lottos, winningLotto);
            OutputView.printDivider();
            printResult(result);

            int totalReward = result.getTotalReward();
            double profit = ProfitCalculator.calculate(totalReward, amount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void printResult(LottoResult result) {
        Map<Rank, Integer> resultMap = result.getResultMap();

        System.out.println("3개 일치 (5,000원) - " + resultMap.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.get(Rank.FIRST) + "개");
    }
}
