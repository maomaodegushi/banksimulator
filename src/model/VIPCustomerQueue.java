package model;

import java.util.concurrent.LinkedBlockingQueue;

public class VIPCustomerQueue extends LinkedBlockingQueue<Customer> {
    private volatile static VIPCustomerQueue instance;

    private VIPCustomerQueue(int capacity) {
        super(capacity);
    }

    public static VIPCustomerQueue getInstance() {
        if (instance == null) {
            synchronized (VIPCustomerQueue.class) {
                if (instance == null) {
                    instance = new VIPCustomerQueue(5);
                }
            }
        }
        return instance;
    }

    public void putCustomerToQueue(Customer customer) {
        try {
            if (null != customer) {
                instance.put(customer);
            } else {
                System.out.println("输入VIP顾客为null");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("VIP顾客等待队列已满:" + instance.size());
        }
    }

    public Customer takeCustomerFromQueue() {
        try {
            return instance.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("VIP顾客等待队列已空");
            return null;
        }
    }


}
