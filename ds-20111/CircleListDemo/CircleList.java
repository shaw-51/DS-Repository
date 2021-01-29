package CircleListDemo;

import LinkedList.MyLinkedList;

public class CircleList<E> extends MyLinkedList<E> {

    protected Node<E> beginDete;  //循环删除开始节点

    public CircleList() {
        super();
        this.length = 0;
    }

    @Override
    public boolean add(E data, int pos) {
//        if(pos<0||pos>length){
//            return false;
//        }
//
//        Node<E> newNode=new Node<E>(data);
//        if(head==null||length==0){
//            //当前为空链表
//            head=newNode;
//            head.setNext(head);
//        }
//        //1.找到pos前一个位置
//        //2.newNode.setNext()
//
//        if(pos==0){
//            //找到的位置是头节点
//            var temp=get(length-1);
//            temp.setNext(newNode);
//            head =newNode;
//        }else if(pos==length){
//            newNode.setNext(head);
//            var temp=get(length-1);
//            temp.setNext(newNode);
//            //找到的位置是尾节点
//            tail=newNode;
//        }else{
//            var pre=get(pos-1);
//            newNode.setNext(pre.getNext());
//            pre.setNext(newNode);
//        }
//        length++;
//        return true;
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

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append(":");
        var temp=head;
        for(int i=0;i<length;i++){
            //保证在尾节点前一个节点停下
            builder.append(temp);
            var tail=get(length-1);
            if (temp !=tail ) {
                builder.append("->");
            }
            temp=temp.getNext();
        }
        return builder.toString();
    }
    /**
     * 构造约瑟夫环的验证，循环删除第N个元素 直至链表为空
     * {1->2->3->4->5->6->7->8->9->10}
     * return:4,8,2,7....
     * @return
     */

    public MyLinkedList<E> joseph(int n){
        //递归调用circleDelete()直到head=null
        var rList=new MyLinkedList<E>();
        beginDete=head;
        while(this.length!=0) {
            rList.addAtTail(circleDete(n));
            System.out.println(this);
        }
        return rList;
    }

    public E circleDete(int n){
        //循环删除从beginDete节点开始数第N个位置的节点,需要移动n-1次
        for (int i = 1; i < n-1; i++) {
            beginDete=beginDete.getNext();
        }
        var r=beginDete.getItem();  //需要删除的值
        //删除这个节点
        beginDete.setNext(beginDete.getNext().getNext());
        beginDete=beginDete.getNext();
        length--;
        return r;

    }

}
