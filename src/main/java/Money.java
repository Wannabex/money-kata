import java.util.Objects;

public class Money {
    public final int quantity;
    public final String currency;

    public Money(int value, String currency) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.currency= currency;
        quantity = value;
    }

    public Money add(Money moreMoney) {
        if (this.currency == moreMoney.currency) {
            return new Money(this.quantity + moreMoney.quantity, this.currency);
        }
        else
            throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object otherMoney) {
        if (this == otherMoney) return true;
        if (otherMoney == null || getClass() != otherMoney.getClass()) return false;

        return this.quantity == ((Money)otherMoney).quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public Money subtract(Money threeDolars) {
        int newQuantity = this.quantity - threeDolars.quantity;

        return new Money(newQuantity, this.currency) ;
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.quantity, this.currency);
    }
}

