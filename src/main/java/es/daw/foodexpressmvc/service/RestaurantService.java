package es.daw.foodexpressmvc.service;

import es.daw.foodexpressmvc.dto.RestaurantDTO;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    public RestaurantDTO getRestaurant(){

        // Pendiente usar WebClient para hacer la petición al endpoint GET http://localhost:8082/api/restaurants
        // Obtendremos un json con la lista de objetos RestaurantDTO

        return null;
    }
}
