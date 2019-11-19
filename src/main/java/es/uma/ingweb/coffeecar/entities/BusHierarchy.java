package es.uma.ingweb.coffeecar.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusHierarchy {                             //result->records->infoBus
    @JsonProperty("result")
    private BusInfoResponse result;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusInfoResponse {
        @JsonProperty("records")
        private List<BusData> busDatas;
        @JsonIgnoreProperties(ignoreUnknown = true)
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class BusData {
            private int _id;
            private int codParada;
            private float codLinea;
            private float lat;
            private float lon;
        }
    }

}
