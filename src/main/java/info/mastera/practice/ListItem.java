package info.mastera.practice;

public class ListItem {
    public ListItem next;
    public int value;

    public ListItem(int value) {
        this.value = value;
    }

    public ListItem(ListItem next, int value) {
        this.next = next;
        this.value = value;
    }

    public static ListItem reverse(ListItem root) {
        ListItem previous = null;
        ListItem current = root;
        ListItem next = null;
        while (null != current) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static ListItem reverse1(ListItem root) {
        ListItem previous = null;
        ListItem current = root;
        ListItem next = current.next;
        current.next = previous;
        previous = current;

        while (null != next) {
            current = next;
            next = current.next;
            current.next = previous;
            previous = current;
        }
        return current;
    }

    @Override
    public String toString() {
        return value + (null == next ? "" : "->" + next);
    }
}
