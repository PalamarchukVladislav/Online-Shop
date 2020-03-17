import java.util.List;

public class Check {

    String userName;
    String userAddress;
    List<Goods> goods;
    Long FinalPrice;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Long getFinalPrice() {
        return FinalPrice;
    }

    public void setFinalPrice(Long finalPrice) {
        FinalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Check{" +
                "userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", goods=" + goods +
                ", FinalPrice=" + FinalPrice +
                '}';
    }
}
