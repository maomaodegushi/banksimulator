package thread;

import model.*;

import static model.Window.WINDOW_TYPE_FAST;
import static model.Window.WINDOW_TYPE_VIP;

public class WindowThread extends Thread {

    private Window window;
    private NormalCustomerQueue queue0 = NormalCustomerQueue.getInstance();
    private FastCustomerQueue queue1 = FastCustomerQueue.getInstance();
    private VIPCustomerQueue queue2 = VIPCustomerQueue.getInstance();

    public WindowThread(Window window) {
        super();
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            switch (window.getType()) {
                case WINDOW_TYPE_VIP:
                    if (queue2.size() > 0) {
                        dealCustomer(queue2.takeCustomerFromQueue());
                        break;
                    }
                case WINDOW_TYPE_FAST:
                    if (queue1.size() > 0) {
                        dealCustomer(queue1.takeCustomerFromQueue());
                        break;
                    }
                default:
                    dealCustomer(queue0.takeCustomerFromQueue());
                    break;
            }
        }
    }

    private void dealCustomer(Customer c) {
        try {
            Thread.sleep(window.getDealTime());
            System.out.println("窗口" + window.getNum() + "完成对客户" + c.getId() + "的服务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
