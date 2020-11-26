package ar.com.apicashonline.cashonline.models;

public class ResultPage {
    Integer page;
    Integer size;
    Long total;

    public ResultPage(Integer page, Integer size, Long total) {
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
