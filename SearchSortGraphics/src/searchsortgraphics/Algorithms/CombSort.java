package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class CombSort extends Algorithm {

    public CombSort(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        Boolean swapped = false;
        Integer gap = array.size();
        while (gap > 1 || swapped) {
            gap = (int) (gap / 1.247330950103979);
            if (gap < 1) {
                gap = 1;
            }
            Integer i = 0;
            swapped = false;
            while ((i + gap) < array.size()) {
                this.main.compare(i, i + gap);
                if (array.get(i) > array.get(i + gap)) {
                    swapped = true;
                    this.main.swap(i, i + gap);
                }
                i++;
            }
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        List<Integer> calc = array;
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
