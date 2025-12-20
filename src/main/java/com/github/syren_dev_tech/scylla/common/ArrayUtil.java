package com.github.syren_dev_tech.scylla.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

    private ArrayUtil() {
    }

    public static final <T> List<T[]> split(T[] array, int n) {
        int l = array.length;

        ArrayList<T[]> list = new ArrayList<>(n);

        int i = 0;
        int index = l / n;

        while (i < n) {
            list.add(Arrays.copyOfRange(array, index - l / n, index));
            i++;
            index += l / n;
        }

        return list;
    }
}
