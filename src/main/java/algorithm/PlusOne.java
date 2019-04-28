package algorithm;

import java.util.Collections;
import java.util.Stack;


public class PlusOne {
    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0)
            return null;

        Stack<Integer> integerStack = new Stack<Integer>();

        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + one;
            one = tmp / 10;
            integerStack.push(tmp % 10);
        }

        if (one > 0)
            integerStack.push(one);

        int[] result = new int[integerStack.size()];
        int j = 0;
        while (integerStack.size() > 0) {
            result[j++] = integerStack.pop().intValue();
        }
        return result;
    }

    public int[] plusOne_method2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] aux = new int[digits.length + 1];
        aux[0] = 1;
        return aux;
    }
}
