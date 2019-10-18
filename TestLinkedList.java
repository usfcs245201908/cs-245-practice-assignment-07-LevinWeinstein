public class TestLinkedList {
    public static void main(String[] args){
        List<Integer> n = new LinkedList<Integer>();

        n.add(2);
        n.add(3);
        n.add(4);
        System.out.println(n.get(2));
        System.out.println(n.size());
        n.remove(1);
        System.out.println(n.size());
        n.remove(1);
        System.out.println(n.size());
        n.remove(0);
        System.out.println(n.size());
    }
}
