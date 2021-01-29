package banyuan;

import LinkedList.MyLinkedList;

// TODO: 使用顺序表(数组)的底层结构来实现栈
public class MyStack<E> extends MyLinkedList<E> {
  public MyStack() {
    super();
  }

  /**
   * 将元素e入栈 - 放在栈顶
   *
   * <p>只有当内存空间不够，分配不出新的节点才会失败，
   *
   * <p>所以我们这个方法没有返回值
   *
   * @param e - 新入栈的元素
   */
  public void push(E e) {
    addAtTail(e);
  }

  /**
   * 弹出(删除)栈顶元素
   *
   * @return 栈顶元素的数据
   */
  public E pop() {
    return removeTail();
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty();
  }

  /**
   * 查看栈顶元素的数据， 不删除
   *
   * @return 栈顶元素的数据
   */
  public E peek() {
    return get(size() - 1).getItem();
  }
}
