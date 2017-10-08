package org.snaptest;

public class TestSubject {

    public int testMethod(int param1, int param2) {
        if (((param1 != 1) && (param2 == 3)) || (!(param2 < 3 && param1 > 0))) {
            return param1 + 7;
        } else if (param1 != 0 && param2 != 0 && param1 > 3 && param2 > 3) {
            return (param1 + 14) * param1;
        } else {
            return 0;
        }
    }
}
