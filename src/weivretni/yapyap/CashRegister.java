package weivretni.yapyap;

import java.util.*;

public class CashRegister {

    HashMap<Float, String> currency = new HashMap<>() {{
        put(100F, "ONE HUNDRED");
        put(50F, "FIFTY");
        put(20F, "TWENTY");
        put(10F, "TEN");
        put(5F, "FIVE");
        put(2F, "TWO");
        put(1F, "ONE");
        put(.5F, "HALF DOLLAR");
        put(.25F, "QUARTER");
        put(.1F, "DIME");
        put(.05F, "NICKEL");
        put(.01F, "PENNY");
    }};

    List<Float> keys = new ArrayList<>(currency.keySet());

    public String calculate(float price, float cash) {
        if (cash < price) return "ERROR";
        else if (price == cash) return "ZERO";
        else {
            float amount = cash - price;
            keys.sort(Collections.reverseOrder());

            List<String> result = new ArrayList<>();

            for (float coin : keys) {
                if (coin <= amount) {
                    for (int i = 0; i < (int) (amount / coin); i++) {
                        result.add(currency.get(coin));
                    }
                    amount =  amount % coin;
                }
            }

            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) sb.append(",");
                sb.append(result.get(i));
            }
            return sb.toString();
        }
    }

    public List<String> recursive(float amount, HashMap<Float, List<String>> cache) {
        if (amount == 0) return new ArrayList<>();
        if (amount < 1) return null;
        if (cache.containsKey(amount)) return cache.get(amount);

        int min = Integer.MAX_VALUE;
        float selectedCoin = 0F;
        List<String> selectedList = null;
        for (float coin : currency.keySet()) {
            if (coin <= amount) {
                List<String> rollOutList = recursive(amount - coin, cache);
                if (rollOutList != null) {
                    int rollOut = rollOutList.size() + 1;
                    if (rollOut > 0 && rollOut < min) {
                        min = rollOut;
                        selectedCoin = coin;
                        selectedList = rollOutList;
                    }
                }
            }
        }

        if (min != Integer.MAX_VALUE) {
            selectedList.add(currency.get(selectedCoin));
        }

        cache.put(amount, selectedList);

        return selectedList;
    }
}
