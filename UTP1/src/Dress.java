public class Dress implements IAggregable<Dress, Double>, IDeeplyCloneable<Dress>  {

    private double price;
    private boolean discount =false;

    public Dress() {
    }

    public Dress(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public Double aggregate(Double intermediateResult) {
        if (intermediateResult == null) {
            return price;
        }
        return price + intermediateResult;
    }

    @Override
    public Dress deepClone() {
        Dress clone = new Dress();
        clone.price = price;
        return clone;
    }
    public boolean haveDiscount(){
        return discount;
    }
}
