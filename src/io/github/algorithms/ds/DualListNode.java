package io.github.algorithms.ds;

/**
 * Created by zsx at 18-5-14 下午4:06
 * 双向链表节点
 */
public class DualListNode {
    public int val;
    public DualListNode nex;
    public DualListNode pre;

    public DualListNode(int val) {
        this.val = val;
    }

    public DualListNode(int val, DualListNode nex, DualListNode pre) {
        this.val = val;
        this.nex = nex;
        this.pre = pre;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public DualListNode getNex() {
        return nex;
    }

    public void setNex(DualListNode nex) {
        this.nex = nex;
    }

    public DualListNode getPre() {
        return pre;
    }

    public void setPre(DualListNode pre) {
        this.pre = pre;
    }
}
