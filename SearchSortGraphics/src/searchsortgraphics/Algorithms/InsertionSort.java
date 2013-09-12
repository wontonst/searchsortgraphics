package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import searchsortgraphics.Core;
import searchsortgraphics.GUI.DynamicScreen;

public class InsertionSort extends Algorithm {

    public InsertionSort(Core c,DynamicScreen s) {
        super(c,s);
    }

    @Override
    public void perform() {
        for (int i = 1; i != this.numbers.size(); i++) {
            this.main.getScreen().setPersistentYellow(i);
            for (int ii = 0; ii != i; ii++) {
                this.main.compare(ii, i);
                if (this.numbers.get(ii) > this.numbers.get(i)) {
                    this.numbers.add(ii, this.numbers.get(i));
                    this.numbers.remove((int) i + 1);
                    this.main.setRed(ii);
                    break;
                }
            }
            this.main.getScreen().removePersistent(i);
        }
    }

    @Override
    public int calculateOperations() {
        ArrayList<Integer> calc = this.copyArray();
        int num = 1;
        for (int i = 1; i != calc.size(); i++) {
            num++;
            for (int ii = 0; ii != i; ii++) {
                num++;
                if (calc.get(ii) > calc.get(i)) {
                    calc.add(ii, calc.get(i));
                    calc.remove((int) i + 1);
                    num++;
                    break;
                }
            }
            num++;
        }
        return num;
    }
}