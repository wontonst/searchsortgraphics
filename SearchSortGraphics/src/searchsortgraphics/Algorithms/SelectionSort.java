package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class SelectionSort extends Algorithm {

    public SelectionSort(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        for (int i = 0; i != array.size(); i++) {
            Integer min = i;
            this.main.getScreen().setPersistentRed(min);
            this.main.saveScreen();
            for (int ii = i; ii != array.size(); ii++) {
                this.main.setBlue(ii);
                if (array.get(min) > array.get(ii)) {
                    this.main.getScreen().removePersistent(min);
                    min = ii;
                    this.main.getScreen().setPersistentRed(min);
                }
            }
            this.main.swap(min, i);
            this.main.getScreen().clearPersistent();
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        List<Integer> calc = array;
        int num = 1;
        for (int i = 0; i != calc.size(); i++) {
            Integer min = i;
            num++;
            for (int ii = i; ii != calc.size(); ii++) {
                if (calc.get(min) > calc.get(ii)) {
                    min = ii;
                }
            }
            Collections.swap(calc, min, i);
            num += 2;
        }
        return num;
    }
}
