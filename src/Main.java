import model.Window;
import thread.CustomerFactoryThread;
import thread.WindowThread;

import static model.Window.WINDOW_TYPE_FAST;
import static model.Window.WINDOW_TYPE_NORMAL;
import static model.Window.WINDOW_TYPE_VIP;

public class Main {

    public static void main(String[] args) {
        CustomerFactoryThread factoryThread = new CustomerFactoryThread();
        factoryThread.start();

        Window w1 = new Window(1, 10000, WINDOW_TYPE_NORMAL);//1号普通窗口
        WindowThread windowThread1 = new WindowThread(w1);
        windowThread1.start();
        Window w2 = new Window(2, 10000, WINDOW_TYPE_NORMAL);//2号普通窗口
        WindowThread windowThread2 = new WindowThread(w2);
        windowThread2.start();
        Window w3 = new Window(3, 10000, WINDOW_TYPE_NORMAL);//3号普通窗口
        WindowThread windowThread3 = new WindowThread(w3);
        windowThread3.start();
        Window w4 = new Window(4, 10000, WINDOW_TYPE_NORMAL);//4号普通窗口
        WindowThread windowThread4 = new WindowThread(w4);
        windowThread4.start();
        Window w5 = new Window(5, 10000, WINDOW_TYPE_FAST);//5号快速窗口
        WindowThread windowThread5 = new WindowThread(w5);
        windowThread5.start();
        Window w6 = new Window(6, 10000, WINDOW_TYPE_VIP);//6号普通窗口
        WindowThread windowThread6 = new WindowThread(w6);
        windowThread6.start();
    }
}
