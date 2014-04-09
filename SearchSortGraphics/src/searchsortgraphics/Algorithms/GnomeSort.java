package searchsortgraphics.Algorithms;

import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class GnomeSort extends Algorithm {

    public GnomeSort(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        int index = 1;
        while (index < array.size()) {
            this.main.compare(index, index - 1);
            if (this.main.getNumbers().get(index) >= this.main.getNumbers().get(index - 1)) {
                index++;
            } else {
                this.main.swap(index, index - 1);
                if (index > 1) {
                    index--;
                } else {
                    index++;
                }
            }
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        int num = 1;
        List<Integer> calc = array;
        int index = 1;
        while (index < calc.size()) {
            num++;
            if (calc.get(index) >= calc.get(index - 1)) {
                index++;
            } else {
                Collections.swap(calc, index, index - 1);
                num += 2;
                if (index > 1) {
                    index--;
                } else {
                    index++;
                }
            }
        }
        return num;
    }
}
