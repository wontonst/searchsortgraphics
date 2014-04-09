package searchsortgraphics.Algorithms;

import java.util.List;
import searchsortgraphics.Core;

public class BogoSort extends Algorithm {

    public BogoSort(Core s) {
        super(s);
    }

    @Override
    protected void performSort(List<Integer> array) {
        int iterations = 0;
        while (!this.main.graphicalIsSorted()) {
            this.shuffle();
            this.main.saveScreen();
            iterations++;
            if (iterations > 15000) {
                System.out.println("BogoSort: operation terminated because 15,000 frames have been generated and a result has not yet been achieved. Please change BogoSort.java if you with to generate more images.");
                return;
            }
        }

    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        return 999999999; //+-100% margin of error
    }
}
