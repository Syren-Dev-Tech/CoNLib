package com.github.syren_dev_tech.scylla.common.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    private StringUtil() {
    }

    public static final String wordCaps(String str) {
        String[] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++)
            arr[i] = StringUtils.capitalize(arr[i]);

        return String.join(" ", arr);
    }

    public static final String wordCapsRepl(String str) {
        return wordCaps(str.replace("_", " "));
    }
}
