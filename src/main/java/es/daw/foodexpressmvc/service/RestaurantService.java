package es.daw.foodexpressmvc.service;

import es.daw.foodexpressmvc.dto.RestaurantDTO;
import es.daw.foodexpressmvc.exception.ConnectApiRestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final WebClient webClientAPI; //automaticamente hace la relación a public WebClient webClientAPI(WebClient.Builder builder)  en AppConfig.java
    public List<RestaurantDTO> getRestaurants() {

        RestaurantDTO[] restaurants;

        try {
            restaurants = webClientAPI
                    .get()
                    .uri("/restaurants")
                    .retrieve() //verifica el status. Si es es 4xx o 5xx, lanza error. Si es 2xx continua
                    .bodyToMono(RestaurantDTO[].class)
                    .block(); //Bloquea y espera. Sincrono
        } catch (Exception e) {
            //throw new ConnectApiRestException("Could not connect to FoodExpress API");
            throw new ConnectApiRestException(e.getMessage());
        }
        return Arrays.asList(restaurants);
    }
}
