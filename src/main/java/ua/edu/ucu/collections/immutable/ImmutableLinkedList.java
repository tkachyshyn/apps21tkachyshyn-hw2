package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private int size;
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        this();
        this.head = new Node();
        this.head.setValue(elements[0]);
        this.tail = new Node();
        this.tail.setValue(elements[elements.length - 1]);

        Node elem = this.head;
        Node prev = new Node();
        Node next = new Node();

        size = elements.length;
        for(int i = 0; i < elements.length; i++) {
            next.setValue(elements[i]);
            next.setPrevious(elem);
            elem.setNext(next);
            elem = next;
        }

    }

    public ImmutableLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(this.size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] arr = {e};
        return addAll(index, arr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] curr = this.toArray();
        Object[] newArr = new Object[curr.length + c.length ];
        for(int i = 0; i < curr.length; i++){
            if(i < index) {
                newArr[i] = curr[i];
            }
            else {
                newArr[i + index] = curr[i];
            }
        }
        for(int i = index; i < index + c.length; i++){
            newArr[i] = c[i - index];
        }
        return new ImmutableLinkedList(newArr);
    }

    @Override
    public Object get(int index) {
        Node temp = this.head;
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] curr = this.toArray();
        Object[] res = new Object[this.size - 1];
        int counter = 0;
        for (int i = 0; i < this.size; i++){
            if (i != index){
                res[counter] = curr[i];
                counter++;
            }
        }
        this.size--;
        return new ImmutableLinkedList(curr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] curr = this.toArray();
        curr[index] = e;
        return new ImmutableLinkedList(curr);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node temp = this.head;
        while (temp.value != e) {
            temp = temp.getNext();
            index++;
        }
        return index;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node temp = head;
        int counter = 0;
        for(int i = 0; i < size; i++){
            arr[i] = temp.getValue();
            temp = temp.getNext();
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableList res = add(0, e);
        return new ImmutableLinkedList(res.toArray());
    }

    public ImmutableLinkedList addLast(Object e) {
        ImmutableList res = add(e);
        return new ImmutableLinkedList(res.toArray());
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        return this.head.value;
    }

    public Object getLast() {
        return this.tail.value;
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableList res = remove(0);
        return new ImmutableLinkedList(res.toArray());
    }

    public ImmutableLinkedList removeLast() {
        ImmutableList res = remove(this.size - 1);
        return new ImmutableLinkedList(res.toArray());
    }
}
