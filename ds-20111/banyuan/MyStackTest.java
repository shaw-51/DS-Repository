package banyuan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStackTest {
  @Test
  public void stackTest() {
    var stack = new MyStack<Integer>();
    for (int i = 0; i < 10; i++) {
      stack.push(i);
    }
    int i = 10;
    while (!stack.isEmpty()) {
      Assertions.assertEquals(--i, stack.pop());
    }
  }
}
