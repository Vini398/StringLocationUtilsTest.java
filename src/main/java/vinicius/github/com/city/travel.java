package vinicius.github.com.city;

import sun.awt.image.ImageWatched;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

class Travel {

    private List<ImageWatched.Link> links;

    public Travel(LocalDateTime startDate, BigDecimal amount){
    }

    public void addLink(ImageWatched.Link link) {
        if(links == null) links = new ArrayList<>();
        links.add(link);
    }

    public Object getEndDate() {
        return null;
    }

    public Instant getStartDate() {
        return null;
    }

    public Object getOrderNumber() {
        return null;
    }




    public void setOrderNumber(Object o) {
    }

    public void setStartDate(Temporal initialDate) {
    }

    public void setEndDate(Object finalDate) {
    }

    public Object getAmount() {
        return null;
    }

    public long getId() {
        return 0;
    }

    public void getType() {
    }

    public void setAmount(Object amount) {
    }
}