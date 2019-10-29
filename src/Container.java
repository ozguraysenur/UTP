import java.util.ArrayList;
import java.util.List;

public class Container<TElement extends IAggregable<TElement, TResult> & IDeeplyCloneable<TElement>, TResult> implements IContainer<TElement, TResult> {

    private List<TElement> elements = new ArrayList<>();

    public List<TElement> getElements() {

        return elements;
    }
    public void addElement(TElement element) {
        elements.add(element);
    }

    @Override
    public TResult aggregateAllElements() {

        TResult result = null;

        for (TElement e : elements) {
            result = e.aggregate(result);
        }

        return result;
    }

    @Override
    public TElement cloneElementAtIndex(int index) {

        if (index < 0 || index >= elements.size()){
            System.out.println("index can not be negative or bigger than size ! ");
        }

        return elements.get(index).deepClone();
    }
}
