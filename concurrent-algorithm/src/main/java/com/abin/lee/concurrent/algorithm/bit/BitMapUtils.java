package com.abin.lee.concurrent.algorithm.bit;

import com.abin.lee.concurrent.common.json.JsonUtil;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.roaringbitmap.RoaringBitmap;

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

    public static void bitMap2() {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(1, 2, 3, 1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L, 4255L);

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
        rr.or(rr2); //in-place computation
        boolean equals = rror.equals(rr);// true
        if(!equals) throw new RuntimeException("bug");
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println(cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
        for(int i : rr) {
            System.out.println(i);
        }
    }

}
