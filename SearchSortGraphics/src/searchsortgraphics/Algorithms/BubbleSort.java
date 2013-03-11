package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Core;

public class BubbleSort extends Algorithm {

    public BubbleSort(Core s) {
        super(s);
    }

    @Override
    public void perform() {
        Boolean sorted = false;
        int iteration = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 1; (i != this.main.getNumbers().size() - iteration); i++) {
                this.main.compare(i - 1, i);
                if (this.main.getNumbers().get(i - 1) > this.main.getNumbers().get(i)) {
                    this.main.swap(i - 1, i);
                    sorted = false;
                }
            }
            iteration++;
        }
    }

    @Override
    public int calculateOperations() {
        int num = 1;
        ArrayList<Integer> calc = this.copyArray();
        Boolean sorted = false;
        int iteration = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 1; (i != calc.size() - iteration); i++) {
                num++;
                if (calc.get(i - 1) > calc.get(i)) {
                    Collections.swap(calc, i - 1, i);
                    sorted = false;
                }
            }
            iteration++;
        }
        return num;
    }
}
