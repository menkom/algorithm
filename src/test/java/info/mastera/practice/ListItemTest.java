package info.mastera.practice;

import org.junit.jupiter.api.Test;

class ListItemTest {

    @Test
    void test() {
        ListItem root = new ListItem(1);
        System.out.println(root);
        System.out.println(ListItem.reverse(root));

        root = new ListItem(new ListItem(new ListItem(new ListItem(4),3), 2), 1);
        System.out.println(root);
        System.out.println(ListItem.reverse(root));
    }
}