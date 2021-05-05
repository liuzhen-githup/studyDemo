/**
 * Copyright(c) 2018 asura
 */
package comm.study.listmapdemo;

/**
 * <p></p>
 *
 * 链表代码原理
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/12 2:58 下午
 */
public  class NodeDemo {

    NodeDemo next;
    Object data;
    public NodeDemo(Object data){
        this.data = data;
    }
    public static void main(String[] args) {
        NodeDemo nodeDemo = new NodeDemo("liuzhen");
        nodeDemo.next = new NodeDemo("xiaoying");
        System.out.println(nodeDemo.data);
        System.out.println(nodeDemo.next.data);
    }
}
