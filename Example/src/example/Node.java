/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author kieup
 */
public class Node {
    int data; //data
    Node next; //next node

    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }   
}
