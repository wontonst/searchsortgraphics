package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class StoogeSort extends Algorithm {

    Integer ops;
    List<Integer> calc;

    public StoogeSort(Core s) {
        super(s);
    }

    @Override
    public void performSort(List<Integer> array) {
        this.stoogeSort(array, 0, array.size() - 1);
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        this.ops = 0;
        this.calc = array;
        this.calcStoogeSort(0, this.calc.size() - 1);
        return this.ops;
    }

    public void stoogeSort(List<Integer> array, Integer i, Integer j) {
        //System.out.println("lolstoge");
        this.main.compare(i, j);
        if (array.get(j) < array.get(i)) {
            this.main.swap(i, j);
        }
        if ((j - i + 1) >= 3) {
            Integer t = (j - i + 1) / 3;
            this.stoogeSort(array, i, j - t);
            this.stoogeSort(array, i + t, j);
            this.stoogeSort(array, i, j - t);
        }
    }

    public void calcStoogeSort(Integer i, Integer j) {
        this.ops++;
        if (this.calc.get(j) < this.calc.get(i)) {
            this.ops += 2;
            Collections.swap(this.calc, i, j);
        }
        if ((j - i + 1) >= 3) {
            Integer t = (j - i + 1) / 3;
            this.calcStoogeSort(i, j - t);
            this.calcStoogeSort(i + t, j);
            this.calcStoogeSort(i, j - t);
        }
    }
}
