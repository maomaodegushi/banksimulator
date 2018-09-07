package model;

public class Window {

    public final static int WINDOW_TYPE_NORMAL = 0;
    public final static int WINDOW_TYPE_FAST = 1;
    public final static int WINDOW_TYPE_VIP = 2;
    public final static long WINDOW_DEFAULT_DEALTIME = 10000L;
    public final static int WINDOW_DEFAULT_NUM = 1;

    private int num = WINDOW_DEFAULT_NUM;//窗口编号
    private long dealTime = WINDOW_DEFAULT_DEALTIME;//毫秒
    private int type;//类型。0:普通；1、快速；2、vip

    public Window() {
    }

    public Window(int num, long dealTime) {
        this.num = num;
        this.dealTime = dealTime;
    }

    public Window(int num, long dealTime, int type) {
        this.num = num;
        this.dealTime = dealTime;
        this.type = type;
    }

    public long getDealTime() {
        return dealTime;
    }

    public void setDealTime(long dealTime) {
        this.dealTime = dealTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
