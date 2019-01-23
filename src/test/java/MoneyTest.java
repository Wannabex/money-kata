import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {
    @Test
    public void thatAddingMoneyReturnsSum() {
        Money fiveDollars = new Money(5, Currency.USD);
        Money tenDollars = new Money(10, Currency.USD);
        Money fifteenDollars = new Money(15, Currency.USD);

        Money result = fiveDollars.add(tenDollars);

        assertEquals(fifteenDollars, result);
    }
    @Test
    public void thatSubtractingMoneyReturnsValidResult() {
        Money fifteenDollars = new Money(15, Currency.USD);
        Money threeDollars = new Money(3, Currency.USD);
        Money twelveDollars = new Money(12, Currency.USD);

        Money result = fifteenDollars.subtract(threeDollars);

        assertEquals(twelveDollars, result);
    }

    @Test
    public void thatMoneyIsImmutable() {
        Money threeDollars = new Money(3, Currency.USD);
        Money fiveDollars = new Money(5, Currency.USD);

        Money threeDollars2 = new Money(3, Currency.USD);
        Money fiveDollars2 = new Money(5, Currency.USD);

        threeDollars.add(fiveDollars);

        assertEquals(threeDollars2, threeDollars);
        assertEquals(fiveDollars2, fiveDollars);

        fiveDollars.subtract(threeDollars);

        assertEquals(threeDollars2, threeDollars);
        assertEquals(fiveDollars2, fiveDollars);
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatMoneyShouldNotHaveNegativeQuantity() {
        Money fifteenDollars = new Money(15, Currency.USD);
        Money twentyDollars = new Money(20, Currency.USD);

        fifteenDollars.subtract(twentyDollars);

    }

    @Test(expected = IllegalArgumentException.class)
    public void thatShowsWeCantHaveNegativeMoney(){
         new Money(-5, Currency.USD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatShouldNotAllowToAddDifferentCurrencies() {
        Money fivePLN = new Money(5, Currency.PLN);
        Money fiveEUR = new Money(5, Currency.EUR);

        fivePLN.add(fiveEUR);
    }
}
