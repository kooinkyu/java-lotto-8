package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public int getTotalReward() {
        return resultMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
