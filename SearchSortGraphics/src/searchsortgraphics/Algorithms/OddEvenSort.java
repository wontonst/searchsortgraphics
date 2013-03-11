package searchsortgraphics.Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import searchsortgraphics.Core;

public class OddEvenSort extends Algorithm {

    public OddEvenSort(Core s) {
        super(s);
    }

    @Override
    public void perform() {
        Boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < this.numbers.size(); i += 2) {
                this.main.compare(i, i - 1);
                if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                    this.main.swap(i, i - 1);
                    sorted = false;
                }
            }
            for (int i = 2; i < this.numbers.size(); i += 2) {
                this.main.compare(i, i - 1);
                if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                    this.main.swap(i, i - 1);
                    sorted = false;
                }
            }
        }

    }

    @Override
    public int calculateOperations() {
	ArrayList<Integer> calc = this.copyArray();
	int num = 1;
        Boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < calc.size(); i += 2) {
		num++;                
if (calc.get(i) < calc.get(i - 1)) {
    num+=2; 
    Collections.swap(calc,i,i-1); 
                    sorted = false;
                }
            }
            for (int i = 2; i < calc.size(); i += 2) {
		num++;                
		if (calc.get(i) < calc.get(i - 1)) {
		    num+=2;
		    Collections.swap(calc,i,i-1);
                    sorted = false;
                }
            }
        }
        return num;
    }
}
