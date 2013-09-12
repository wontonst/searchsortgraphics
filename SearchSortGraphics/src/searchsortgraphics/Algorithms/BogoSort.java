package searchsortgraphics.Algorithms;

import searchsortgraphics.Core;
import searchsortgraphics.GUI.DynamicScreen;

public class BogoSort extends Algorithm {

    public BogoSort(Core c,DynamicScreen s) {
        super(c,s);
        
    }

    @Override
    public void perform() {
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
    public int calculateOperations() {
        return 999999999; //+-100% margin of error
    }
}