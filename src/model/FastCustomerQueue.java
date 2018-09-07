package model;

import java.util.concurrent.LinkedBlockingQueue;

public class FastCustomerQueue extends LinkedBlockingQueue<Customer> {
    private volatile static FastCustomerQueue instance;

    private FastCustomerQueue(int capacity) {
        super(capacity);
    }

    public static FastCustomerQueue getInstance() {
        if (instance == null) {
            synchronized (FastCustomerQueue.class) {
                if (instance == null) {
                    instance = new FastCustomerQueue(5);
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
                System.out.println("输入快速顾客为null");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("快速顾客等待队列已满:" + instance.size());
        }
    }

    public Customer takeCustomerFromQueue() {
        try {
            return instance.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("快速顾客等待队列已空");
            return null;
        }
    }


}
