package threads;

/**
 * @Author: xiaohui
 * @Description:
 * @Date: Created in 2017/12/14 9:48
 * @Modified By:
 */
public class LockDemo {
    private volatile   long i=0,j=0;

    public  void test1() {
        i++;j++;
    }

    public  void test2() {
        System.out.print("i value= "+i);
        System.out.println(" i value= "+i+" j value="+j);
    }
    public static void main(String[] args) {
        LockDemo lockDemo=new LockDemo();
        Thread thread1=new Thread(()->{
            while (true)
                lockDemo.test1();
        });
        Thread thread2=new Thread(()->{
            while (true)
                lockDemo.test2();
        });
        thread1.start();
        thread2.start();
    }
}
