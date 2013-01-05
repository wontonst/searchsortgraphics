package searchsortgraphics.Algorithms;

import searchsortgraphics.Algorithm;
import searchsortgraphics.BaseGUI;

public class BogoSort extends Algorithm {

    public BogoSort(BaseGUI s) {
        super(s);
    }

    @Override
    public void perform() {
        int iterations = 0;
        while (!this.main.graphicalIsSorted()) {
            this.main.shuffle();
            this.main.saveScreen();
            iterations++;
            if (iterations > 15000) {
                System.out.println("BogoSort: operation terminated because 15,000 frames have been generated and a result has not yet been achieved. Please change BogoSort.java if you with to generate more images.");
                return;
            }
        }

    }

    @Override
    public int calculateOperations() {
        return 999999999;
    }
}