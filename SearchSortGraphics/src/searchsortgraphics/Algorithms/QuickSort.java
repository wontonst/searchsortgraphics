package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import searchsortgraphics.Core;

public class QuickSort extends Algorithm {

    Integer op;

    public QuickSort(Core s) {
        super(s);
        this.op = 0;
    }

    @Override
    public void performSort(List<Integer> array) {

        this.quickSort(array, 0, array.size() - 1);
        this.main.saveScreen();

    }

    private void quickSort(List<Integer> array, Integer l, Integer r) {
        Integer left = l, right = r;
        Integer pivot = array.get(l + (r - l) / 2);
        this.main.setYellow(l + (r - l) / 2);

        while (left <= right) {
            while (array.get(left) < pivot) {
                this.main.compare(left, l + (r - l) / 2);
                left++;
            }
            while (array.get(right) > pivot) {
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
            this.quickSort(array, l, right);
        }
        if (left < r) {
            this.quickSort(array, left, r);
        }
    }

    @Override
    public int performCalculateOperations(List<Integer> array) {
        int num = 2;
        this.calcQuickSort(array, 0, array.size() - 1);
        num += this.op;
        return num;
    }

    public void calcQuickSort(List<Integer> array, Integer l, Integer r) {
        List<Integer> calc = array;
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
