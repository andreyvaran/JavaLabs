package com.lab3;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Letters implements Collection<Character> {
    /**
     * Леттерс н аоснове строки
     */
    private String store;

    Letters(String from) {
        store = from;
    }

    Letters() {
        store = "";
    }

    @Override
    public int size() {
        return store.length();
    }

    @Override
    public boolean isEmpty() {
        return store.isEmpty();
    }


    @Override
    public boolean contains(Object o) {
        for (Character i : store.toCharArray()) {
            if (i.equals(o)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letters that = (Letters) o;

        return store != null ? store.equals(that.store) : that.store == null;
    }


    @Override
    public int hashCode() {
        return store != null ? store.hashCode() : 0;
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            int cursor = -1;
            boolean nextWasCalled = false;
            String lastStore = store;

            @Override
            public boolean hasNext() {
                return cursor + 1 != store.length();
            }


            @Override
            public Character next() {
                if (!lastStore.equals(store)) {
                    throw new ConcurrentModificationException();
                }
                nextWasCalled = true;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return store.charAt(++cursor);
            }

            @Override
            public void remove() {
                if (!nextWasCalled) {
                    throw new IllegalStateException();
                }
                if (!lastStore.equals(store)) {
                    throw new ConcurrentModificationException();
                }

                nextWasCalled = false;
                Letters.this.remove(store.charAt(cursor--));
                lastStore = store;
            }

        };
    }

    @Override
    public String toString() {
        return store;
    }

    @Override
    public Character[] toArray() {
        Character[] arr = new Character[store.length()];
        for (int i = 0; i < store.length(); i++) {
            arr[i] = store.charAt(i);
        }
        return arr;
    }

    /**
     * Пустая функция необходима тк используем интерфейс Collection
     * @param a
     * @param <T>
     * @return
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Character character) {
        store = store + character;
        return true;
    }

    public boolean addStr(String str){
        for (Character c : str.toCharArray()){
            this.add(c);
        }
        return true;
    }
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }

        if (store.contains(o.toString())) {
            store = store.replaceFirst(o.toString(), "");
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object i : c) {
            if (!contains(i)){
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean addAll(Collection<? extends Character> c) {
        for (Character i : c) {
            add(i);
        }
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        boolean contains = false;
        for (Object i : c) {
            if (store.contains(i.toString())) {
                contains = true;
                while (store.contains(i.toString())) {
                    remove(i);
                }
            }
        }
        return contains;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Letters newLetters = new Letters("");
        for (int i = 0; i < store.length(); i++) {
            if (c.contains(store.charAt(i))) {
                newLetters.add(store.charAt(i));
            }
        }
        if (newLetters.equals(this)) {
            return false;
        }
        store = newLetters.store;
        return true;
    }

    @Override
    public void clear() {
        store = "";
    }

}