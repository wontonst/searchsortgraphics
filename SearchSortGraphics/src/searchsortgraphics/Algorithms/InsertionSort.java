package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.List;
import searchsortgraphics.Core;

public class InsertionSort extends Algorithm {

    public InsertionSort(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        for (int i = 1; i != array.size(); i++) {
            this.main.getScreen().setPersistentYellow(i);
            for (int ii = 0; ii != i; ii++) {
                this.main.compare(ii, i);
                if (array.get(ii) > array.get(i)) {
                    array.add(ii, array.get(i));
                    array.remove((int) i + 1);
                    this.main.setRed(ii);
                    break;
                }
            }
            this.main.getScreen().removePersistent(i);
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        List<Integer> calc = array;
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
