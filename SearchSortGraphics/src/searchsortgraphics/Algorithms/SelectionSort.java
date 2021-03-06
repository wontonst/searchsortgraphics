package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Core;

public class SelectionSort extends Algorithm {

    public SelectionSort(Core s) {
        super(s);
    }

    @Override
    public void perform() {
        for (int i = 0; i != this.main.getNumbers().size(); i++) {
            Integer min = i;
            this.main.getScreen().setPersistentRed(min);
            this.main.saveScreen();
            for (int ii = i; ii != this.main.getNumbers().size(); ii++) {
                this.main.setBlue(ii);
                if (this.main.getNumbers().get(min) > this.main.getNumbers().get(ii)) {
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
    public int calculateOperations() {
        ArrayList<Integer> calc = this.copyArray();
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
