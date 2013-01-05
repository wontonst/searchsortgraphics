package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Algorithm;
import searchsortgraphics.BaseGUI;

public class GnomeSortOptimized extends Algorithm {

    public GnomeSortOptimized(BaseGUI s) {
        super(s);
    }

    @Override
    public void perform() {
        this.numbers = this.main.getNumbers();
        this.main.saveScreen();
        int pos = 1;
        int last = 0;
        while (pos < this.numbers.size()) {
            this.main.compare(pos, pos - 1);
            if (this.numbers.get(pos) >= this.numbers.get(pos - 1)) {
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
    public int calculateOperations() {
        int num = 1;
        ArrayList<Integer> calc = this.copyArray();
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