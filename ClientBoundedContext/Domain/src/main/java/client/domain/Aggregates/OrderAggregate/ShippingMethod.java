package client.domain.Aggregates.OrderAggregate;

/**
 * Created by Ambro on 28.12.2016.
 */
public enum ShippingMethod {
    NormalParcel;

    public static double getPriceForShippingMethod(ShippingMethod method){
        return 10;
    }
}
