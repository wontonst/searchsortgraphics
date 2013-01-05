package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Algorithm;
import searchsortgraphics.BaseGUI;

public class QuickSort extends Algorithm {

    Integer op;

    public QuickSort(BaseGUI s) {
        super(s);
        this.op = 0;
    }

    @Override
    public void perform() {

        this.quickSort(this.main.getNumbers(), 0, this.main.getNumbers().size() - 1);
        this.main.saveScreen();

    }

    public void quickSort(ArrayList<Integer> in, Integer l, Integer r) {
        Integer left = l, right = r;
        Integer pivot = this.main.getNumbers().get(l + (r - l) / 2);
        this.main.setYellow(l + (r - l) / 2);

        while (left <= right) {
            while (this.main.getNumbers().get(left) < pivot) {
                this.main.compare(left, l + (r - l) / 2);
                left++;
            }
            while (this.main.getNumbers().get(right) > pivot) {
                this.main.compare(right, l + (r - l) / 2);
                right--;
            }
            this.main.compare(left, right);
            if (left <= right) {
                this.main.swap(left, right);
                left++;
                right--;
            }
        }
        if (l < right) {
            this.quickSort(this.main.getNumbers(), l, right);
        }
        if (left < r) {
            this.quickSort(this.main.getNumbers(), left, r);
        }
    }

    @Override
    public int calculateOperations() {
        int num = 2;
        this.calcQuickSort(this.main.getNumbers(), 0, this.main.getNumbers().size() - 1);
        num += this.op;
        return num;
    }

    public void calcQuickSort(ArrayList<Integer> in, Integer l, Integer r) {
        ArrayList<Integer> calc = this.copyArray();
        Integer left = l, right = r;
        Integer pivot = calc.get(l + (r - l) / 2);
        this.op++;
        while (left <= right) {
            while (calc.get(left) < pivot) {
                this.op++;
                left++;
            }
            while (calc.get(right) > pivot) {
                this.op++;
                right--;
            }
            this.op++;
            if (left <= right) {
                Collections.swap(calc, left, right);
                this.op += 2;
                left++;
                right--;
            }
        }
        if (l < right) {
            this.calcQuickSort(calc, l, right);
        }
        if (left < r) {
            this.calcQuickSort(calc, left, r);
        }
    }
}
