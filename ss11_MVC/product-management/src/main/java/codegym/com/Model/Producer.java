package codegym.com.Model;

public class Producer {
    private int id;
    private String producerName;

    public Producer() {
    }

    public Producer(int id, String producerName) {
        this.id = id;
        this.producerName = producerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
