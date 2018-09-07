package thread;

import model.Customer;
import model.FastCustomerQueue;
import model.NormalCustomerQueue;
import model.VIPCustomerQueue;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import static model.Customer.CUSTOMER_TYPE_FAST;
import static model.Customer.CUSTOMER_TYPE_NORMAL;
import static model.Customer.CUSTOMER_TYPE_VIP;

public class CustomerFactoryThread extends Thread {

    private AtomicLong count;//创建次数计数
    private NormalCustomerQueue queue0 = NormalCustomerQueue.getInstance();
    private FastCustomerQueue queue1 = FastCustomerQueue.getInstance();
    private VIPCustomerQueue queue2 = VIPCustomerQueue.getInstance();
    final static int INITIAL_SEC = 3000;//创建客户时间间隔（毫秒）

    public CustomerFactoryThread() {
        this.count = new AtomicLong();
    }

    @Override
    public void run() {
        while (true) {
            createCustomer(count.incrementAndGet());
            System.out.println("创建第" + count.longValue() + "个客户...");
            try {
                Thread.sleep(INITIAL_SEC);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createCustomer(long id) {
        Customer c = new Customer();
        c.setId(id);
        c.setType(generateType());
        System.out.println(c.toString());
        switch (c.getType()) {
            case CUSTOMER_TYPE_NORMAL:
                queue0.putCustomerToQueue(c);
                break;
            case CUSTOMER_TYPE_FAST:
                queue1.putCustomerToQueue(c);
                break;
            case CUSTOMER_TYPE_VIP:
                queue2.putCustomerToQueue(c);
                break;
            default:
                break;
        }
    }

    private int generateType() {
        int mod = new Random().nextInt(10) % 10;
        if (mod < 6) {
            return CUSTOMER_TYPE_NORMAL;
        } else if (mod < 9) {
            return CUSTOMER_TYPE_FAST;
        } else {
            return CUSTOMER_TYPE_VIP;
        }
    }
}
