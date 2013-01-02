/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics;

import java.util.ArrayList;

/**
 *
 * @author RoyZheng
 */
public class Algorithm implements Runnable {

    protected BaseGUI main;
    protected LoadingBar bar;

    public Algorithm(BaseGUI s) {
        this.main = s;
    }

    private Algorithm() {
    }

    public int calculateOperations() {
        throw new UnsupportedOperationException("CANNOT RUN Algorithm.calculateOperations: abstract method.");
    }

    public void perform() {
        throw new UnsupportedOperationException("CANNOT RUN Algorithm.perform: abstract method.");
    }

    @Override
    public void run() {
        if (this.main.getNumbers().isEmpty()) {
            return;
        }
        int ops = this.calculateOperations();
        System.out.println("Detected operation to contain " + ops + " renders.");
	this.bar = new LoadingBar(ops);
        this.main.setLoadingBar(this.bar);

        this.perform();
        this.bar.close();
	this.main.resetFileNumber();
    }
    
    public ArrayList<Integer> copyArray()
    {
        ArrayList<Integer> calc = new ArrayList<Integer>();
        for (int i = 0; i != this.main.getNumbers().size(); i++) {
            calc.add(this.main.getNumbers().get(i));
        }
        return calc;
    }
}
