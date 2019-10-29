
public interface IContainer<TElement extends IAggregable<TElement, TResult> & IDeeplyCloneable<TElement>, TResult>
{

    TResult aggregateAllElements();

    TElement cloneElementAtIndex(int index);
}