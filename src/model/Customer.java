package model;

public class Customer {

    public final static int CUSTOMER_TYPE_NORMAL = 0;
    public final static int CUSTOMER_TYPE_FAST = 1;
    public final static int CUSTOMER_TYPE_VIP = 2;

    private long id;
    private int type;//0:普通用户;1:快速用户;2:VIP用户

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
