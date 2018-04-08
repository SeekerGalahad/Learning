import java.io.IOException;
import java.util.Date;

public class GC_test {
    public static void main(String[] args) throws IOException {
        /*//程序开始时：(先调用一下垃圾回收，但是不一定立即执行)
        Runtime.getRuntime().gc();
        long initm=Runtime.getRuntime().freeMemory();
        //程序结束时：
        Runtime.getRuntime().gc();
        long endm=Runtime.getRuntime().freeMemory();
        //计算空闲差：
        System.out.println(initm-endm);*/

        Runtime run = Runtime.getRuntime();
        System.in.read();   // 暂停程序执行

// System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + (run.totalMemory()-run.freeMemory()) );
        run.gc();
        System.out.println("time: " + (new Date()));
// 获取开始时内存使用量
        long startMem = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + startMem );

        String str = "";
        for(int i=0; i<50000; ++i){
            str += i;
        }

        System.out.println("time: " + (new Date()));
        long endMem = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + endMem );
        System.out.println("memory difference:" + (endMem-startMem));
/*
run.gc();
System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + (run.totalMemory()-run.freeMemory()) );
*/
    }
}
