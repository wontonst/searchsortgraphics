package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.BaseGUI;

public class GnomeSort extends Algorithm {

    public GnomeSort(BaseGUI s) {
        super(s);
    }

    @Override
    public void perform() {
        int index = 1;
        while (index < this.main.getNumbers().size()) {
            this.main.compare(index, index - 1);
            if (this.main.getNumbers().get(index) >= this.main.getNumbers().get(index - 1)) {
                index++;
            } else {
                this.main.swap(index, index - 1);
                if (index > 1) {
                    index--;
                } else {
                    index++;
                }
            }
        }
    }

    @Override
    public int calculateOperations() {
        int num = 1;
        ArrayList<Integer> calc = this.copyArray();
        int index = 1;
        while (index < calc.size()) {
            num++;
            if (calc.get(index) >= calc.get(index - 1)) {
                index++;
            } else {
                Collections.swap(calc, index, index - 1);
                num += 2;
                if (index > 1) {
                    index--;
                } else {
                    index++;
                }
            }
        }
        return num;
    }
}
