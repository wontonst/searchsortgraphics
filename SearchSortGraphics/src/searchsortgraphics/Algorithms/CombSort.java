package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Core;

public class CombSort extends Algorithm {

    public CombSort(Core s) {
        super(s);
    }

    @Override
    public void perform() {
        Boolean swapped = false;
        Integer gap = this.numbers.size();
        while (gap > 1 || swapped) {
            gap = (int) (gap / 1.247330950103979);
            if (gap < 1) {
                gap = 1;
            }
            Integer i = 0;
            swapped = false;
            while ((i + gap) < this.numbers.size()) {
                this.main.compare(i, i + gap);
                if (this.numbers.get(i) > this.numbers.get(i + gap)) {
                    swapped = true;
                    this.main.swap(i, i + gap);
                }
                i++;
            }
        }
    }

    @Override
    public int calculateOperations() {
        ArrayList<Integer> calc = this.copyArray();
        int num = 1;
        Boolean swapped = false;
        Integer gap = calc.size();
        while (gap > 1 || swapped) {
            gap = (int) (gap / 1.247330950103979);
            if (gap < 1) {
                gap = 1;
            }
            Integer i = 0;
            swapped = false;
            while ((i + gap) < calc.size()) {
                num++;
                if (calc.get(i) > calc.get(i + gap)) {
                    swapped = true;
                    num += 2;
                    Collections.swap(calc, i, i + gap);
                }
                i++;
            }
        }
        return num;
    }
}