package com;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaticMemoryLeakTests {
    // 使用静态变量去存储大量的数据
    public  static List<byte[]> bytes = new ArrayList<>();
    public void makeBytes() {
        for (int i = 0; i < 1000 * 200; i++) {
            bytes.add(new byte[1024]);
        }
        System.out.println("Debug point 2");
    }
    public static void main(String[] args)throws Exception {
        // 给时间我打开 visualVM 监控工具
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Debug point 1");
        new StaticMemoryLeakTests().makeBytes();
        System.out.println("Debug point 3");
        for (; ; ) {

        }
    }
}

