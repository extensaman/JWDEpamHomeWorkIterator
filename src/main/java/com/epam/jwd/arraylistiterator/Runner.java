package com.epam.jwd.arraylistiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Write your own iterator over ArrayList
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {

    public static final String ORIGINAL_LIST_IS = "Original list is ";
    public static final String SELF_MAKEN_ITERATING = "Self-maken iterating";
    public static final String SEPARATOR = " ";
    public static final String LIST_AFTER_REMOVE_ALL_EMLEMENTS_IS = "\nList after remove all emlements is ";

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        ListWrapper<Integer> listWrapper = new ListWrapper<>(list);
        Iterator<Integer> iterator = listWrapper.iterator();

        System.out.println(ORIGINAL_LIST_IS + list);
        System.out.println(SELF_MAKEN_ITERATING);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + SEPARATOR);
            iterator.remove();
        }
        System.out.println(LIST_AFTER_REMOVE_ALL_EMLEMENTS_IS + list);
    }
}
