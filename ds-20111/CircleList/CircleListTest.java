package CircleList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleListTest {

    //TODO 1.作业：验证循环链表真的是循环的
    @Test
    void circleTest(){
        var circleList =new CircleList<Integer>();
        for (int i = 0; i < 10; i++) {
            circleList.add(i+1,i);
        }
        System.out.println(circleList);
//        var r=circleList.joseph(4);
//        System.out.println(r);
//        System.out.println(circleList);
    }

}