package lotto.domain;

public class ProfitCalculator {

    public static double calculate(int totalReward, int purchaseAmount) {
        return (double) totalReward / purchaseAmount * 100;
    }
}
