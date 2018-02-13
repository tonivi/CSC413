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
public class LabelCode extends ByteCode {
    private String label;

    @Override
    public void execute(VirtualMachine vm) {
        //nothing needed
    }

    @Override
    public void init(Vector<String> args) {
        name = "LabelCode";
        label = args.get(0);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String printStatement() {
        return "";
    }
}
