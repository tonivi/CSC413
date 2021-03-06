/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.Vector;

/**
 *
 * @author Brady
 */
public class CallCode extends ByteCode {
    private String label;
    private int arg;
    @Override
    public void execute(VirtualMachine vm) {
        int toAddress = Integer.parseInt(label);
        int fromAddress = vm.getPC();
        arg = vm.peekRunStack();
        vm.pushAddress(fromAddress);
        vm.jumpToAddress(toAddress);
    }

    @Override
    public void init(Vector<String> args) {
        name = "CallCode";
        label = args.get(0);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String printStatement() {
        return label + "(" + arg + ")";
    }
}
