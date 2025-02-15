import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws RestaurantNotFoundException {

            for (Restaurant restaurant : restaurants) {
                if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                    return restaurant;
                }
            }

            throw new RestaurantNotFoundException(
                    "Exception ==> Restaurant with name: " + restaurantName + " not found!!");
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws RestaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() throws RestaurantNotFoundException {
        if(restaurants.size() > 0)
            return restaurants;
        else
            throw new RestaurantNotFoundException("Exception ==> No restaurants added yet!!");
    }
}
