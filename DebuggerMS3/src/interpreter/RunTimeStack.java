/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;
import java.util.*;

/**
 *
 * @author Brady
 */
public class RunTimeStack {
    private Vector<Integer> v;
    private Stack<Vector> frames;
    int currFrame;
    public RunTimeStack() {
        v = new Vector();
        frames = new Stack();
        currFrame = 0;
    }
    public void dump() {
        Stack<Vector> tmpFrames = new Stack();
        while (!frames.isEmpty()) {
            tmpFrames.push(frames.pop());
        }
        while (!tmpFrames.isEmpty()) {
            frames.push(tmpFrames.pop());
            Vector<Integer> tmpV = frames.peek();
            if (tmpV.size() > 0) {
                System.out.print("[" + tmpV.get(0));
            }
            for (int i = 1; i < tmpV.size(); i++) {
                System.out.print("," + tmpV.get(i));
            }
            if (tmpV.size() > 0) {
                System.out.print("] ");
            }
        }
        System.out.println();
    }
    public int peek() {
        if (v.size() > 0) return v.get(v.size() - 1);
        else return -1;
    }
    public int pop() {
        if (v.size() > 0) {
            int i = v.get(v.size() - 1);
            v.removeElementAt(v.size() - 1);
            return i;
        }
        else return -1;
    }
    public int push(int i) {
        v.addElement(i);
        return i;
    }
    
    public void newFrameAt(int offset) {
        Vector<Integer> temp = new Vector(offset);
        for (int i = offset - 1; i >= 0; i--) {
            temp.add(i, pop());
        }
        
        frames.push(v);
        v = temp;
        
        currFrame++;
    }
    public void popFrame() {
        try {
            if (!v.isEmpty()) {
                int i = v.get(v.size() - 1);
                v.removeAllElements();
                v = frames.pop();
                push(i);
            }
            else {
                v = frames.pop();
            }
            currFrame--;
        } catch (java.util.EmptyStackException e) {
            System.out.println("Terminating starting frame, quitting program");
            System.exit(0);
        }
    }
    public int store(int offset) {
        int i = pop();
        v.add(offset, i);
        return i;
    }
    public int load(int offset) {
        if (!v.isEmpty()) return push(v.get(offset));
        else return -1;
    }
    public Integer push(Integer i) {
        v.addElement(i);
        return i;
    }
}
