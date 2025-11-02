package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonus(winningNumbers, bonusNumber);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank match(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf((int) matchCount, bonusMatch);
    }
}
