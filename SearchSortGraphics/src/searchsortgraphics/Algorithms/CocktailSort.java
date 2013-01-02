package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Algorithm;
import searchsortgraphics.BaseGUI;
import searchsortgraphics.LoadingBar;

public class CocktailSort extends Algorithm {

    public CocktailSort(BaseGUI s) {
        super(s);
    }

    @Override
    public void perform() {
        this.main.saveScreen();

        Integer top = 0;
        Integer bot = 0;

        Boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1 + bot; i != this.main.getNumbers().size() - top; i++) {
                this.main.compare(i - 1, i);
                if (this.main.getNumbers().get(i - 1) > this.main.getNumbers().get(i)) {
                    this.main.swap(i - 1, i);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            top++;
            swapped = false;
            for (int i = this.main.getNumbers().size() - 1 - top; i != bot; i--) {
                this.main.compare(i - 1, i);
                if (this.main.getNumbers().get(i - 1) > this.main.getNumbers().get(i)) {
                    this.main.swap(i - 1, i);
                    swapped = true;
                }
            }
            bot++;
        } while (swapped);
    }

    @Override
    public int calculateOperations() {
        int num = 1;
        ArrayList<Integer> calc = this.copyArray();

        Integer top = 0;
        Integer bot = 0;

        Boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1 + bot; i != calc.size() - top; i++) {
                num++;
                if (calc.get(i - 1) > calc.get(i)) {
                    num += 2;
                    Collections.swap(calc, i - 1, i);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            top++;
            swapped = false;
            for (int i = calc.size() - 1 - top; i != bot; i--) {
                num++;
                if (calc.get(i - 1) > calc.get(i)) {
                    Collections.swap(calc, i - 1, i);
                    swapped = true;
                }
            }
            bot++;
        } while (swapped);
        return num;
    }
}
