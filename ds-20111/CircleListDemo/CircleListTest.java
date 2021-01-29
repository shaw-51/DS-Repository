package CircleListDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleListTest {

    @Test
    void CicleList(){
        var circleList=new CircleList<Integer>();
        for (int i = 0; i < 10; i++) {
            circleList.add(i+1,i);
        }
        System.out.println(circleList);
        circleList.joseph(5);
    }

}