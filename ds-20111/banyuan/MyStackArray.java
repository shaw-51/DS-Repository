package banyuan;

import ArrayList.MyArrayList;

public class MyStackArray<E> extends MyArrayList<E> {
    // TODO: 使用顺序表(数组)的底层结构来实现栈

    public MyStackArray(){
        super();
    }

    public void push(E e){
        addAtRail(e);
    }

    public E pop(){
        return removeEnd();
    }

    public boolean isEmpty(){
        return super.isEmpty();
    }

    public E peak(){
        return get(curr-1);
    }

}
