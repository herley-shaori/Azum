package herley.sll;

/**
 * @author herley
 */

public class SingleLinkedList {

    private Node pHead,pTail;
    private int skor = 0;
    private int size = 0;

    public void addNode(Node node, int position){
        if((this.pHead==null) && (this.pTail==null)){
            this.pHead = node;
            this.pTail = node;
        }else if(position==0){
            node.setNextNode(this.pHead);
            this.pHead = node;
        }else if(position == this.size-1){
            Node prevPointer = this.pHead;
            while (prevPointer.getNextNode() != this.pTail){
                prevPointer = prevPointer.getNextNode();
            }
            prevPointer.setNextNode(node);
            node.setNextNode(this.pTail);
        }else{
            Node prevPointer = this.pHead;
            while ((prevPointer.getNextNode() !=null)){
                if((prevPointer.getNextNode().getIndex() >= position)){
                    break;
                }
                prevPointer = prevPointer.getNextNode();
            }
            if(prevPointer == this.pTail){
                this.pTail.setNextNode(node);
                this.pTail = node;
            }else {
                Node currentPointer = prevPointer.getNextNode();
                prevPointer.setNextNode(node);
                node.setNextNode(currentPointer);
            }
        }
        this.size++;
        this.setLinkedListIndex();
        this.comboChecker();
    }

    /**
     *
     * @param node
     */
    public void addNode(Node node){
        if((pHead == null) && (pTail == null)){
            this.pHead = node;
            this.pTail = node;
        }else{
            this.pTail.setNextNode(node);
            this.pTail = node;
        }
        this.size++;
        this.setLinkedListIndex();
        this.comboChecker();
    }

    /**
     *
     * @param nodes
     */
    public void removeNodes(Node... nodes){
        if(nodes.length == 1){
            if(this.size == 1){
                this.pHead = null;
                this.pTail = null;
            }else if(nodes[0] == this.pHead){
                this.pHead = this.pHead.getNextNode();
            }else if(nodes[0] == this.pTail){
                Node pointer = this.pHead;
                while (pointer.getNextNode() != this.pTail){
                    pointer = pointer.getNextNode();
                }
                this.pTail = pointer;
                this.pTail.setNextNode(null);
            }else{
                Node prevPointer = this.pHead;
                while(prevPointer.getNextNode() != nodes[0]){
                    prevPointer = prevPointer.getNextNode();
                }
                Node currentPointer = prevPointer.getNextNode();
                prevPointer.setNextNode(currentPointer.getNextNode());
                currentPointer = null;
            }
        }else{
            for(Node node:nodes){
                if(node == this.pHead){
                    this.pHead = this.pHead.getNextNode();
                }else if(node == this.pTail){
                    Node pointer = this.pHead;
                    while (pointer.getNextNode() != this.pTail){
                        pointer = pointer.getNextNode();
                    }
                    this.pTail = pointer;
                }else{
                    Node prevPointer = this.pHead;
                    while(prevPointer.getNextNode() != node){
                        prevPointer = prevPointer.getNextNode();
                    }
                    Node currentPointer = prevPointer.getNextNode();
                    prevPointer.setNextNode(currentPointer.getNextNode());
                    currentPointer = null;
                }
            }
        }
        this.size--;
        this.setLinkedListIndex();
        this.comboChecker();
    }

    private void removeNodes(Node<Kelereng>[] comboArray,boolean bool){
        if(comboArray[0] == this.pHead){
            Node lastNode = comboArray[comboArray.length-1];
            this.pHead = lastNode.getNextNode();
        }else if(comboArray[comboArray.length-1] == this.pTail){
            Node fistNode = comboArray[0];
            Node pointer = this.pHead;
            while(pointer.getNextNode() != fistNode){
                pointer = pointer.getNextNode();
            }
            this.pTail = pointer;
            this.pTail.setNextNode(null);
        }else {
            Node pointer = this.pHead;
            while (pointer.getNextNode() != comboArray[0]){
                pointer = pointer.getNextNode();
            }

            Node fistNode = comboArray[0];
            Node lastNode = comboArray[comboArray.length-1];

            pointer.setNextNode(lastNode.getNextNode());
            lastNode.setNextNode(null);
        }
        this.size = this.size-comboArray.length;
    }

    private SingleLinkedList checkPair(){
        this.setLinkedListIndex();

        int lowerBound = 0;
        int upperBound = 4;

        final SingleLinkedList sll = new SingleLinkedList();
        while (upperBound < this.size){
            final boolean range = this.range(lowerBound, upperBound);
            if(range){
                final KeyValuePair<Integer> keyValuePair = new KeyValuePair<>(lowerBound,upperBound);
                sll.addNode(new Node<KeyValuePair>(keyValuePair));
                upperBound++;
            }else {
                lowerBound ++;
                upperBound ++;
            }
        }
        return sll;
    }

    private void comboChecker(){

        /**
         * Jika ukuran dalam SLL ini lebih dari 4 (untuk melakukan combo).
         */
        int comboKe = 0;
        while ((this.size >= 4) && (this.checkPair().getRoot() != null)){
            Node<KeyValuePair> root = this.checkPair().getTail();
                final KeyValuePair<Integer> data = root.getData();
                final Node<Kelereng>[] arrayKelerengPindah = new Node[data.getValue() - data.getKey()];
                int indexLowerBound = data.getKey();
                for (int i=0; i<arrayKelerengPindah.length; i++){
                    arrayKelerengPindah[i] = this.getNode(indexLowerBound);
                    indexLowerBound++;
                }

                /**
                 * REMOVAL POINT.
                 */
                this.removeNodes(arrayKelerengPindah,true);
            this.setLinkedListIndex();
            this.skor += 10*arrayKelerengPindah.length*this.power((comboKe+1),3);
            comboKe++;
        }
    }

    private int power(int number, int power){
        int totalPower = 1;
        for(int i=0; i<power; i++){
            totalPower*=number;
        }
        return totalPower;
    }

    private boolean range(int lowerBound, int upperBound){
        final Node<Kelereng>[] nodeArray = new Node[upperBound-lowerBound];
        int indexNodeArray = 0;
        for(int i=lowerBound; i<upperBound; i++){
            final Node<Kelereng> node = this.getNode(i);
            nodeArray[indexNodeArray] = node;
            indexNodeArray++;
        }

        boolean valid = true;

        for(int i=0; i<nodeArray.length; i++){
            for(int j=0; j<nodeArray.length; j++){
                if(nodeArray[i].getData().getWarna() != nodeArray[j].getData().getWarna()){
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }

    private Node getNode(int index){
        if(index < this.size){
            Node pointer = this.pHead;

            while (pointer != null){
                if(pointer.getIndex() == index){
                    break;
                }
                pointer = pointer.getNextNode();
            }

            return pointer;
        }else{
            System.err.println("Invalid Index"+", Size : "+this.size+" Index : "+index);
            return null;
        }
    }

    private void setLinkedListIndex(){
        int index = 0;
        Node pointer = this.pHead;
        while (pointer != null){
            pointer.setIndex(index);
            index++;
            pointer = pointer.getNextNode();
        }
    }

    public int getSize(){return this.size;}
    public Node getRoot(){return this.pHead;}
    public Node getTail(){return this.pTail;}
    public int getSkor(){return this.skor;}
}

final class KeyValuePair<T>{
    private final T key,value;
    public KeyValuePair(T key,T value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "LowerBound : "+this.key+", UpperBound : "+this.value;
    }

    public T getKey(){return this.key;}
    public T getValue(){return this.value;}
}
