package com.company.List;

import java.util.Comparator;
import java.util.TreeMap;

public class Tree implements Cloneable{
    TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });

    TreeMap<Integer, Integer> map2 = new TreeMap<>((a1, a2)->a1-a2);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();

        return null;
    }
}
