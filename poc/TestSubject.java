package org.snaptest;

public class TestSubject {

    public int testMethod(int param) {
        if (3 <= param && param <= 7) {
            return param + 7;
        } else {
            return (param + 14) * param;

        }
    }
}
