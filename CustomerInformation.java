package Supermarket;

public class CustomerInformation {
    String custId;
    String custIC;
    double CounterPaid;

    public CustomerInformation(String custId, String custIC, double counterPaid) {
        this.custId = custId;
        this.custIC = custIC;
        CounterPaid = counterPaid;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustIC() {
        return custIC;
    }

    public void setCustIC(String custIC) {
        this.custIC = custIC;
    }

    public double getCounterPaid() {
        return CounterPaid;
    }

    public void setCounterPaid(double counterPaid) {
        CounterPaid = counterPaid;
    }
}
