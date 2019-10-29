public class Weather implements IAggregable<Weather, Integer>, IDeeplyCloneable<Weather>  {

    private int degree;
    private boolean sunny = false, rainy = true;

    public Weather() {
    }

    public Weather(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {
        if (intermediateResult == null) {
            return degree;
        }
        return degree + intermediateResult;
    }

    @Override
    public Weather deepClone() {
        Weather clone = new Weather();
        clone.degree = degree;
        return clone;
    }
    public boolean isSunny(){
        return sunny;
    }
    public boolean isRainy(){
        return rainy;
    }

}
