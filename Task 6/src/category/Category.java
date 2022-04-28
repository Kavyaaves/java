package category;

public enum Category {
    STATIONARY(0.08), ELECTRONICS(0.1), SNACKS(0.04), FOOD(0.02);
    private final double tax;
    Category(double tax) {
        this.tax = tax;
    }
    public double getTax(){
        return this.tax;
    }
}



