package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import searchsortgraphics.Core;

public class ShellSort extends Algorithm {

    public ShellSort(Core s) {
        super(s);
    }

    @Override
    public void perform() {
        ArrayList<Integer> gaps = new ArrayList<Integer>();
        gaps.add(701);
        gaps.add(301);
        gaps.add(132);
        gaps.add(57);
        gaps.add(23);
        gaps.add(10);
        gaps.add(4);
        gaps.add(1);

        for (int b = 0; b != gaps.size(); b++) {
            int gap = (int) gaps.get(b);
            for (int i = gap; i < this.numbers.size(); i++) {
                Integer temp = this.numbers.get(i);
                int j = i;
                for (; j >= gap && this.numbers.get(j - gap) > temp; j -= gap) {
                    this.main.compare(j - gap, j);
                    this.numbers.set(j, this.numbers.get(j - gap));
                    this.main.setRed(j);
                }
                this.numbers.set(j, temp);
                this.main.setRed(j);
            }
        }

    }

    @Override
    public int calculateOperations() {
        int num = 1;
        ArrayList<Integer> calc = this.copyArray();
        ArrayList<Integer> gaps = new ArrayList<Integer>();
        gaps.add(701);
        gaps.add(301);
        gaps.add(132);
        gaps.add(57);
        gaps.add(23);
        gaps.add(10);
        gaps.add(4);
        gaps.add(1);

        for (int b = 0; b != gaps.size(); b++) {
            int gap = (int) gaps.get(b);
            for (int i = gap; i < calc.size(); i++) {
                Integer temp = calc.get(i);
                int j = i;
                for (; j >= gap && calc.get(j - gap) > temp; j -= gap) {
                    num++;
                    calc.set(j, calc.get(j - gap));
                    num++;
                }
                calc.set(j, temp);
                num++;
            }
        }
        return num;
    }
}
