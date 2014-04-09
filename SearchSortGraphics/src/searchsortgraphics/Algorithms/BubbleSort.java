package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class BubbleSort extends Algorithm {

    public BubbleSort(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        Boolean sorted = false;
        int iteration = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 1; (i != this.main.getNumbers().size() - iteration); i++) {
                this.main.compare(i - 1, i);
                if (array.get(i - 1) > array.get(i)) {
                    this.main.swap(i - 1, i);
                    sorted = false;
                }
            }
            iteration++;
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        int num = 1;
        List<Integer> calc = array;
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
