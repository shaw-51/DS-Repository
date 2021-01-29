package CircleList;

import LinkedList.MyLinkedList;

public class CircleList<E> extends MyLinkedList<E> {

    private Node<E> begin2Delete;

    public CircleList(){
        super();  //直接调用父类的构造函数
    }

    /**
     *
     * @param data--插入新数据
     * @param pos--假设不能超出当前链表的长度
     * @return--插入成功或失败
     */
    @Override
    public boolean add(E data, int pos) {
        //判断非法位置
        if(pos<0||pos>length){
            return false;
        }
        var newNode =new Node<E>(data);
        //假设一个节点都没有
        if(length==0){
            //新的头节点为新节点
            head=newNode;
            //头节点的下一个节点是他本身
            newNode.setNext(newNode);
        }else{
            //节点长度不为0
            //1.如果新加入的位置是0，则需要将之前的尾节点指向现在新的头节点
            if(pos==0){
                newNode.setNext(head);
                var tail=get(length-1);
                tail.setNext(newNode);
                head =newNode;
            }else{
                //2.加入的位置不是头节点
                // 1）找到pre
                var pre=get(pos-1);
                // 2）修改next
                newNode.setNext(pre.getNext());
                pre.setNext(newNode);

            }
        }
        length++;
        return true;
    }
    /**
     * 构造约瑟夫环的验证，循环删除第N个元素 直至链表为空
     * {1->2->3->4->5->6->7->8->9->10}
     * return:4,8,2,7....
     * @return
     */
    public MyLinkedList<E> joseph(int n){
        //从head开始，循环删除第4个元素
        //从某个元素开始，删除之后的第n个元素,返回删除元素的值，同时还要修改下一个元素开始的节点
        begin2Delete=head;
        var rList=new MyLinkedList<E>();

        while(length>0){
            rList.addAtTail(circleDelete(n));
            System.out.println(begin2Delete.getItem());
        }
        return rList;
    }


    //从某个元素开始，删除之后的第n个元素,返回删除元素的值，同时还要修改下一个元素开始的节点
    public E circleDelete(int pos){
        //begin->1:3
        //pos=4
        for (int i = 1; i < pos-1; i++) {
            begin2Delete =begin2Delete.getNext();
        }
        var r=begin2Delete.getNext().getItem();
        begin2Delete.setNext(begin2Delete.getNext().getNext());
        begin2Delete=begin2Delete.getNext();
        length--;
        return r;
    }
}
