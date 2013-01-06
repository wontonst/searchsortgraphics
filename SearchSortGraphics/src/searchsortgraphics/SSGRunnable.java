package searchsortgraphics;

import java.util.ArrayList;

/**
 * Sorting and generating runnables will extend this class before implementing
 * Runnable
 *
 * @author RoyZheng
 */
public class SSGRunnable {

    BaseGUI main;

    public SSGRunnable(BaseGUI main) {
        this.main = main;
    }
/**
 * @brief default constructor is disabled
 */
    private SSGRunnable() {
    }

    /**
     * @brief shuffles the entire numbers array
     */
    public void shuffle() {
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        while (!this.main.getNumbers().isEmpty()) {
            Integer num;
            if (this.main.getNumbers().size() == 1) {
                num = 0;
            } else {
                num = this.main.getRand().nextInt(this.main.getNumbers().size());
            }
            newlist.add(this.main.getNumbers().get(num));
            this.main.getNumbers().remove((int) num);
        }
        for (int i = 0; i != newlist.size(); i++) {
            this.main.getNumbers().add(newlist.get(i));
        }
    }

    public String getThreadName() {
        throw new UnsupportedOperationException("CANNOT USE SSGRunnable.getThreadName WITHOUT EXTENDING A BASE CLASS");
    }
}
