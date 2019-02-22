package com.jimmysun.algorithms.chapter1_1;

public class Ex09 {    
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
        };
    public static String toBinaryString(int value) {
        if (value == 0) {
            return "0";
        }
        int bufLen = 32;
        int index = bufLen;
        //该数组用来装余数     除2取余倒数
        char[] result = new char[bufLen];
        do {
            // 使用 & 符合相对除 2 提升一定性能
        	//1 这个有问题 负数有问题,得取余数的绝对值
//        	result[--index] = (char) ('0'+Math.abs(value%2));
//        	value = value>>>1;
        	
        	//2   11111111111111111111111111110110
            result[--index] = (char) ('0' + (value & 1));
            value >>>=1; //也可表示为  value = value >>> 1;
            
        } while (value != 0);
        return new String(result, index, bufLen - index);
    }
    
    
    
    private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
        	System.out.println(i & mask);
            buf[--charPos] = digits[i & mask];
            i >>>= shift;
        } while (i != 0);

        return new String(buf, charPos, (32 - charPos));
    }
    
    public static void main(String[] args) {
        int value = -9;
        
        
        System.out.println("value:"+ value + "; result for toBinaryString>>>\r\n\t" + toUnsignedString(value,1));
        
        System.out.println("value:"+ value + "; result for toBinaryString>>>\r\n\t" + toBinaryString(value));
    }
}
