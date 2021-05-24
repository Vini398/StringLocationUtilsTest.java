package vinicius.github.com.city;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class travelservice<TravelFactory> {

    private TravelFactory factory;
    private List<Travel> travels;

    public void createTravelFactory() {
        if(factory == null) {
            factory = new TravelFactoryImpl();
        }
    }

    public void createTravelList() {
        if(travels == null) {
            travels = new ArrayList<>();
        }
    }

    public boolean isJSONValid(String jsonInString) {
        try {
            return new ObjectMapper().readTree(jsonInString) != null;
        } catch (IOException e) {
            return false;
        }
    }

    private BigDecimal parseAmount(JSONObject travel) throws JSONException {
        return new BigDecimal((String) travel.get("amount"));
    }

    private LocalDateTime parseStartDate(JSONObject travel) throws JSONException {
        var startDate = (String) travel.get("startDate");
        return ZonedDateTime.parse(startDate).toLocalDateTime();
    }

    private LocalDateTime parseEndDate(JSONObject travel) throws JSONException {
        var endDate = (String) travel.get("endDate");
        return ZonedDateTime.parse(endDate).toLocalDateTime();
    }

    private void setTravelValues(JSONObject jsonTravel, Travel travel) throws JSONException {

        String orderNumber = (String) jsonTravel.get("orderNumber");
        String type = (String) jsonTravel.get("type");

        travel.setOrderNumber(orderNumber != null ? orderNumber : travel.getOrderNumber());
        travel.setAmount(jsonTravel.get("amount") != null ? parseAmount(jsonTravel) : travel.getAmount());
        travel.setStartDate(jsonTravel.get("initialDate") != null ? parseStartDate(jsonTravel) : travel.getStartDate());
        travel.setEndDate(jsonTravel.get("finalDate") != null ? parseEndDate(jsonTravel) : travel.getEndDate());
        travel.setOrderNumber(type != null ? TravelTypeEnum.getEnum(type) : travel.getType());
    }

    public Travel update(Travel travel, JSONObject jsonTravel) throws JSONException {

        setTravelValues(jsonTravel, travel);
        return travel;
    }

    public List<Travel> find() {
        createTravelList();
        return travels;
    }

    public void delete() {
        travels.clear();
    }

    public void clearObjects() {
        travels = null;
        factory = null;

}
