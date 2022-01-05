package com.company.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeMap {
    TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    });
}
