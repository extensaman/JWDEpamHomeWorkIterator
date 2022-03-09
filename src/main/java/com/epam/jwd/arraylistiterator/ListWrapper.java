package com.epam.jwd.arraylistiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListWrapper<T> implements Iterable<T> {
    private List<T> list;

    public ListWrapper(List<T> list) {
        this.list = Objects.requireNonNullElseGet(list, ArrayList::new);
    }

    public Iterator<T> iterator() {
        return new SelfMakenIterator<T>();
    }

    private final class SelfMakenIterator<E> implements Iterator<E> {
        private int index;
        private boolean isNextExecuted;

        @Override
        public void remove() {
            if (isNextExecuted) {
                list.remove(--index);
                isNextExecuted = false;
            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public boolean hasNext() {
            return index != list.size();
        }

        @Override
        public E next() {
            try {
                isNextExecuted = true;
                return (E) list.get(index++);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }
}
