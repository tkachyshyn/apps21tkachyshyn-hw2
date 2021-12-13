package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] array;
    private int size;

    public ImmutableArrayList(Object[] elements) {
        this.array = elements.clone();
        this.size = elements.length;
    }

    public ImmutableArrayList() {
        this.array = new Object[0];
        this.size = 0;
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
        for (int i = 0; i < c.length; i++) {
            curr[curr.length + c.length - 1 - i] = curr[curr.length - 1 - i];
        }
        for(int i = index; i < c.length + index; i++){
            curr[i] = c[i - index];
        }
        return new ImmutableArrayList(curr);
    }

    @Override
    public Object get(int index) {

        return this.array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] curr = this.toArray();
        for (int i = index; i < this.size - 1; i++){
            curr[i] = curr[i + 1];
            curr[this.size - 1] = null;
        }
        return new ImmutableArrayList(curr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] res = this.toArray();
        res[index] = e;

        return new ImmutableArrayList(res);
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        while (this.array[index] != e) {
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
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            res[i] = this.array[i];
        }
        return res;
    }
}