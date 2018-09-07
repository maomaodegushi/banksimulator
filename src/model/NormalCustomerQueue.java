package model;

import java.util.concurrent.LinkedBlockingQueue;

public class NormalCustomerQueue extends LinkedBlockingQueue<Customer> {
    private volatile static NormalCustomerQueue instance;

    private NormalCustomerQueue(int capacity) {
        super(capacity);
    }

    public static NormalCustomerQueue getInstance() {
        if (instance == null) {
            synchronized (NormalCustomerQueue.class) {
                if (instance == null) {
                    instance = new NormalCustomerQueue(5);
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
                System.out.println("输入普通顾客为null");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("普通顾客等待队列已满:" + instance.size());
        }
    }

    public Customer takeCustomerFromQueue() {
        try {
            return instance.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("普通顾客等待队列已空");
            return null;
        }
    }


}
