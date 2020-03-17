import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * - получить всех вип-юзеров
 * - создать корзину для пользователя
 * - получить корзину для пользователя
 * - получить всех юзеров с корзиной
 * - получить все товары, название которых содержит %слово%, и цена которых ниже %цена%
 * - получить чек для корзины для определённого пользователя (нужно сделать через 1 стрим)
 * - вывести чек в файл
 */

public class Shop {

    List<User> users = new ArrayList<>();

    List<Goods> goods = new ArrayList<>();

    Map<User, ShoppingCart> activeShoppingCart = new HashMap<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Map<User, ShoppingCart> getActiveShoppingCart() {
        return activeShoppingCart;
    }

    public void setActiveShoppingCart(Map<User, ShoppingCart> activeShoppingCart) {
        this.activeShoppingCart = activeShoppingCart;
    }

    public List<User> getAllVipUsers(){
        return users.stream()
                .filter(user -> user.vipStatus)
                .collect(Collectors.toList());
    }

    public void createCartForUser(User user){
        activeShoppingCart.put(user, new ShoppingCart());
    }

    public ShoppingCart getShoppingCartForUser(User user){
       return activeShoppingCart.get(user);
    }

    public Set<User> getAllUsersWithCart(){
        return activeShoppingCart.keySet();
    }

    public List<Goods> getGoodsByNameAndPrice(long price, String keyWord){ // TODO naming

        return goods.stream()
                .filter(productByPrice -> productByPrice.price < price)
                .filter(productByName -> productByName.name.contains(keyWord))
                .collect(Collectors.toList());
    }

    public Check getCheckForUser(User user){
        Check check = new Check();

        ShoppingCart shoppingCart = new ShoppingCart();

        check.setUserName(user.getUserName());
        check.setUserAddress(user.getAddress());
        check.setGoods(getActiveShoppingCart().get(user).goods);
        check.setFinalPrice(shoppingCart.getFinalPrice());

        

        return check;
    }

    public void writeCheckToFile(){

       // TODO

    }

}
