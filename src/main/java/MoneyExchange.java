import java.util.HashMap;
import java.util.Map;

public class MoneyExchange {
    Map<String, Map<String, Integer>> exchangeRate;

    public MoneyExchange() {
        exchangeRate = new HashMap<>();

        Map<String, Integer> plnExchangeRate = new HashMap<>();
        plnExchangeRate.put(Currency.USD, 4);
        plnExchangeRate.put(Currency.EUR, 3);

        exchangeRate.put(Currency.PLN, plnExchangeRate);
    }

    public Money doExchange(Money toExchange, String currency ) {
        if (!exchangeRate.containsKey(toExchange.currency)) {
            throw new NotExchangeableCurrency();
        }

        int ratio = exchangeRate.get(toExchange.currency).get(currency);

        return new Money(toExchange.quantity * ratio, currency);
    }
}
