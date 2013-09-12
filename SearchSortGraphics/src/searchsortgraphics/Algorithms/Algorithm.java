/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import searchsortgraphics.Core;
import searchsortgraphics.GUI.DynamicScreen;
import searchsortgraphics.GUI.LoadingBar;
import searchsortgraphics.SSGRunnable;

/**
 * @brief Superclass for all sorting algorithms.
 * @author RoyZheng
 */
public abstract class Algorithm extends SSGRunnable implements Runnable {

    static int threadnum = -1;
    protected Core main;
    protected DynamicScreen screen;
    protected LoadingBar bar;
    volatile protected ArrayList<Integer> numbers;///<pointer to the BaseGUI's arraylits of numbers

    public Algorithm(Core c) {
        super(c);
        this.main = c;
        this.screen = c.getScreen();
        this.numbers = this.main.getNumbers();
    }

    public abstract int calculateOperations();

    public abstract void perform();

    /**
     * @brief begins rendering sequence. Note that the numbers arraylist should
     * NOT be modified while this is happening.
     */
    @Override
    public void run() {
        if (this.main.getNumbers().isEmpty()) {
            return;
        }
        int ops = this.calculateOperations();
        System.out.println("Detected operation to contain " + ops + " renders.");
        this.bar = new LoadingBar(ops);
        this.main.setLoadingBar(this.bar);

        this.main.saveScreen();
        this.perform();
        this.main.finishRender();
    }

    public ArrayList<Integer> copyArray() {
        ArrayList<Integer> calc = new ArrayList<Integer>();
        for (int i = 0; i != this.main.getNumbers().size(); i++) {
            calc.add(this.main.getNumbers().get(i));
        }
        return calc;
    }

    public String getThreadName() {
        threadnum++;
        return "SortAlgorithmThread-" + threadnum;
    }
}
