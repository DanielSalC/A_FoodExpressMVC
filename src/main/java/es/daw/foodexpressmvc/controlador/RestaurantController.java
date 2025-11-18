package es.daw.foodexpressmvc.controlador;

import es.daw.foodexpressmvc.dto.RestaurantDTO;
import es.daw.foodexpressmvc.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestaurantController {


    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public String listRestaurants(Model model) {

        List<RestaurantDTO> restaurants = restaurantService.getRestaurants();
        model.addAttribute("restaurants",restaurants);
        return "restaurants";
    }
}
