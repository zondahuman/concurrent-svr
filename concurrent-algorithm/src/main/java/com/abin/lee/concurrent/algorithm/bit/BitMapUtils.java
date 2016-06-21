package com.abin.lee.concurrent.algorithm.bit;

import com.abin.lee.concurrent.common.json.JsonUtil;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-21
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
public class BitMapUtils {
    public static void main(String[] args) {
         bitMap1();
    }

    public static void bitMap1() {
        BiMap<Integer, Integer> biMap = HashBiMap.create();
        biMap.put(1, 1);
        System.out.println("biMap=" + biMap);
    }


}
