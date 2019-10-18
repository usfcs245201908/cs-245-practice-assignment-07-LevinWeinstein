public class LinkedList<T> implements List<T>{

    public static class LListNode<T> {
        LListNode<T> next;
        T value;


        LListNode(T item){
            next = null;
            value = item;
        }
    }

    private LListNode<T> head;
    private int len;

    LinkedList() {
        head = null;
        len = 0;
    }


    public void add(T item){
        LListNode<T> newNode = new LListNode<>(item);
        LListNode<T> tmp = head;
        len++;

        if (tmp == null) {
            head = newNode;
            return;
        }

        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = newNode;

    }

    public void add(int pos, T item){
        len++;

        if (pos == 0){
            LListNode<T> newNode = new LListNode<>(item);
            newNode.next = head;
            head = newNode;
            return ;
        }

        LListNode current = head;
        for (; pos > 1; pos--)
            current = current.next;

        LListNode tmp = current.next;
        current.next = new LListNode<>(item);
        current.next.next = tmp;
    }

    public T get(int pos){
        LListNode<T> tmp = head;

        while (pos-- > 0){
            if (tmp == null)
                return null;
            tmp = tmp.next;
        }
        return tmp == null ? null : tmp.value;
    }

    public T remove(int pos){
        LListNode<T> tmp = head;
        T item;

        if (head == null)
            return null;

        len--;
        if (pos == 0){
            item = head.value;
            head = tmp.next;
        } else {
            for (int i = 1; tmp != null && i < pos; i++)
                tmp = tmp.next;

            item = tmp.next.value;
            tmp.next = tmp.next.next;
        }

        return item;
    }

    public int size(){
        return len;
    }
}
