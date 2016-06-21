package com.abin.lee.concurrent.algorithm.bit;

import com.abin.lee.concurrent.common.json.JsonUtil;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 16-6-21
 * Time: 下午9:50
 * To change this template use File | Settings | File Templates.
 */
public class BitSetUtils {
    public static void main(String[] args) {
        bitSet1();
        bitSet2();
    }

    public static void bitSet1() {
        BitSet bitSet = new BitSet();
        bitSet.set(100);
        boolean flag = bitSet.get(100);
        System.out.println("flag=" + flag);
        int card = bitSet.cardinality();
        System.out.println("card=" + card);
        int size = bitSet.size();
        System.out.println("size=" + size);
        long array[] = bitSet.toLongArray();
        System.out.println("array=" + JsonUtil.toJson(array));
        String array1 = bitSet.toString();
        System.out.println("array1=" + array1);
    }

    public static void bitSet2() {
        int temp1 = 2 << 2;
        System.out.println("temp1=" + temp1);
    }


}
