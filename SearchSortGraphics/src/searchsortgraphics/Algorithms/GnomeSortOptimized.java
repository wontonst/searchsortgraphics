package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class GnomeSortOptimized extends Algorithm {

    public GnomeSortOptimized(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        this.main.saveScreen();
        int pos = 1;
        int last = 0;
        while (pos < array.size()) {
            this.main.compare(pos, pos - 1);
            if (array.get(pos) >= array.get(pos - 1)) {
                if (last != 0) {
                    pos = last;
                    last = 0;
                }
                pos++;
            } else {
                this.main.swap(pos, pos - 1);
                if (pos > 1) {
                    if (last == 0) {
                        last = pos;
                    }
                    pos--;
                } else {
                    pos++;
                }
            }
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        int num = 1;
        List<Integer> calc = array;
        int pos = 1;
        int last = 0;
        while (pos < calc.size()) {
            num++;
            if (calc.get(pos) >= calc.get(pos - 1)) {
                if (last != 0) {
                    pos = last;
                    last = 0;
                }
                pos++;
            } else {
                num += 2;
                Collections.swap(calc, pos, pos - 1);
                if (pos > 1) {
                    if (last == 0) {
                        last = pos;
                    }
                    pos--;
                } else {
                    pos++;
                }
            }
        }
        return num;
    }
}
