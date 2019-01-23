import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyExchangeTest {
    @Test
    public void thatExchangesKnownCurrencies() {
        MoneyExchange exchange = new MoneyExchange();

        Money threeEuro = new Money(3, Currency.EUR);
        Money onePLN = new Money(1, Currency.PLN);
        Money fourDollars = new Money(4, Currency.USD);

        Money result = exchange.doExchange(onePLN, Currency.USD);
        Money result2 = exchange.doExchange(onePLN, Currency.EUR);
        assertEquals(fourDollars, result);
        assertEquals(threeEuro, result2);
    }

   @Test(expected = NotExchangeableCurrency.class)
   public void nonExchangableCurrencyThrowsExcepion() {
        MoneyExchange exchange = new MoneyExchange();

        Money fourDollars = new Money(4, Currency.USD);
        exchange.doExchange(fourDollars, Currency.PLN);
    }
}
