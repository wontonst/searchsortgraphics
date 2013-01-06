package searchsortgraphics.Generators;

import java.util.ArrayList;
import searchsortgraphics.BaseGUI;
import searchsortgraphics.SSGRunnable;

/**
 *@brief base class for generating an array of numbers to be operated on
 * @author RoyZheng
 */
public class Generator extends SSGRunnable implements Runnable {

    static int threadnum = -1;
    protected BaseGUI main;
    volatile protected ArrayList<Integer> numbers;///<reference to BaseGUI arraylist of numbers

    public Generator(BaseGUI in) {
        super(in);
        this.main = in;
        this.numbers = this.main.getNumbers();
    }

    public void run() {
        this.generate();
        this.main.repaint();
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