import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<T> implements StringStack<T>{
    private Node<T> top;
    private int height;
    class Node<T>{
        T value;
        Node<T> next;
        public Node(T value){
            this.value=value;
        }
    }
    public StringStackImpl(){
        height=0;
        top=null;
    }

    /**
     * @return true if the stack is empty
     */
    public boolean isEmpty(){
        return height == 0;
    }

    /**
     * insert a String item to the stack
     */

    @Override
    public void push(T item){
        Node<T> newNode=new Node<>(item);
        if (isEmpty()){
            top=newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    /**
     * remove and return the item on the top of the stack
     * @return the item on the top of the stack
     * @throws \\a NoSuchElementException if the stack is empty
     */
    public T pop() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            Node<T> temp=top;
            top=top.next;
            temp.next=null;
            height--;
            return temp.value;
        }
    }
    /**
     * return without removing the item on the top of the stack
     * @return the item on the top of the stack
     * @throws \\a NoSuchElementException if the stack is empty
     */
    public T peek() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }else {
            return top.value;
        }
    }

    /**
     * print the elements of the stack, starting from the item
     * on the top,
     * to the stream given as argument. For example,
     * to print to the standard output you need to pass System.out as
     * an argument. E.g.,
     * printStack(System.out);
     */
    public void printStack(PrintStream stream){
        Node<T> temp=top;
        while(temp!=null){
            stream.println(temp.value);
            temp=temp.next;
        }
    }

    /**
     * return the size of the stack, 0 if it is empty
     * @return the number of items currently in the stack
     */
    public int size(){
        return height;
    }
}
