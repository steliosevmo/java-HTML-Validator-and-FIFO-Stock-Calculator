import java.io.PrintStream;
import java.util.NoSuchElementException;

public class DoubleQueueImpl<T> implements DoubleQueue<T> {
    private  Node<T> first;
    private  Node<T> last;
    private int length;

    public Node<T> getFirst() {
        return first;
    }

    class Node<T>{
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
    public DoubleQueueImpl(){
        length=0;
        first=null;
        last=null;
    }
    /**
     * @return true if the queue is empty
     */
    public boolean isEmpty(){
        return length==0;
    }

    /**
     * insert a double to the queue
     */
    public void put(T item){
        Node<T> newNode=new Node<>(item);
        if (isEmpty()){
            first=newNode;
            last=newNode;
        }
        else{
            last.next=newNode;
            last=newNode;
        }
        length++;
    }

    /**
     * remove and return the oldest item of the queue
     * @return oldest item of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T get() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> temp=first;
        if (length==1) {
            first=null;
            last=null;
        }
        else{
            first=first.next;
            temp.next=null;
        }
        length--;
        return temp.value;
    }

    /**
     * return without removing the oldest item of the queue
     * @return oldest item of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return first.value;
        }
    }


    /**
     * print the elements of the queue, starting from the oldest
     * item, to the print stream given as argument. For example, to
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printQueue(System.out);
     */
    public void printQueue(PrintStream stream){
        Node<T> temp= first;
        while (temp!=null){
            stream.println(temp.value);
            temp=temp.next;
        }
    }

    /**
     * return the size of the queue, 0 if it is empty
     * @return number of elements in the queue
     */
    public int size(){
        return length;
    }
}
