package searchsortgraphics.Generators;

import java.util.ArrayList;
import searchsortgraphics.Core;
import searchsortgraphics.SSGRunnable;

/**
 *@brief base class for generating an array of numbers to be operated on
 * @author RoyZheng
 */
public class Generator extends SSGRunnable implements Runnable {

    static int threadnum = -1;
    protected Core main;
    volatile protected ArrayList<Integer> numbers;///<reference to BaseGUI arraylist of numbers

    public Generator(Core in) {
        super(in);
        this.main = in;
        this.numbers = this.main.getNumbers();
    }

    public void run() {
        this.generate();
        this.main.repaint();
        this.main.getScreen().rebuild();
        System.out.println("Successfully generated new set of numbers.");
    }

    public void generate() {
        throw new UnsupportedOperationException("CANNOT RUN Generator.generate() WITHOUT EXTENDING A BASE CLASS");
    }

    public String getThreadName() {
        threadnum++;
        return "GeneratorThread-" + threadnum;
    }
}