package herley.sll;

/**
 * @author herley
 * @param <T>
 */

public class Node<T> {
    private  T data;
    private Node nextNode;
    private int index;

    public Node(T data){
        this.data = data;
    }

    public Node(){

    }

    public void setData(T data){this.data=data;}
    public  T getData(){return this.data;}

    public void setNextNode(Node node){this.nextNode=node;}
    public Node getNextNode(){return this.nextNode;}

    public void setIndex(int index){this.index=index;}
    public int getIndex(){return this.index;}
}
