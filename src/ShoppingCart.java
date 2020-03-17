import java.util.ArrayList;
import java.util.List;

/**
 * - получить общую сумму
 * - создать копию корзины
 * - убрать все товары, цена которых выше %цена%
 */

public class ShoppingCart {

    List<Goods> goods = new ArrayList<>();

    public Long getFinalPrice(){
        long finalPrice = 0;
        for (Goods good : goods) {
            finalPrice = finalPrice + good.price;
        }
        return finalPrice;
    }

    public List<Goods> copyCart(){
        return new ArrayList<>(goods); // TODO immutable
    }

    public void removeGoodsByPrice(long price){

        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).price > price){
                goods.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "goods=" + goods +
                '}';
    }

}
