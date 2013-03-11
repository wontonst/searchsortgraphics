package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Core;

public class StoogeSort extends Algorithm {

    Integer ops;
    ArrayList<Integer> calc;

    public StoogeSort(Core s) {
        super(s);
    }

    @Override
    public void perform() {
        this.stoogeSort(0, this.numbers.size() - 1);
    }

    @Override
    public int calculateOperations() {
        this.ops = 0;
        this.calc = this.copyArray();
        this.calcStoogeSort(0, this.calc.size() - 1);
        return this.ops;
    }

    public void stoogeSort(Integer i, Integer j) {
        //System.out.println("lolstoge");
        this.main.compare(i, j);
        if (this.numbers.get(j) < this.numbers.get(i)) {
            this.main.swap(i, j);
        }
        if ((j - i + 1) >= 3) {
            Integer t = (j - i + 1) / 3;
            this.stoogeSort(i, j - t);
            this.stoogeSort(i + t, j);
            this.stoogeSort(i, j - t);
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
