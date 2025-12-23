package api;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.orders.confirm.ConfirmOrderRequest;
import model.orders.track.TrackOrder;
import model.orders.update.Operation;
import model.orders.create.Orders;

import java.util.ArrayList;

public class OrderAPI extends BaseTest {
    public static Response createOrder(String access_token, Orders order){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(access_token)
                .body(order)
                .post("/v2/checkout/orders");
    }
    public static Response getOrderDetails(String access_token, String order_id){
        return RestAssured.given()
                .auth().oauth2(access_token)
                .get("/v2/checkout/orders" + "/" + order_id);
    }
    public static Response updateOrder(String access_token, String order_id, ArrayList<Operation> operations){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(access_token)
                .body(operations)
                .patch("/v2/checkout/orders" + "/" + order_id);
    }
    public static Response confirmPaymentForOrder(String access_token, String order_id, ConfirmOrderRequest payment_source){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(access_token)
                .body(payment_source)
                .post("/v2/checkout/orders" + "/" + order_id + "/confirm-payment-source");
    }
    public static Response capturePaymentForOrder(String access_token, String order_id){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(access_token)
                .body("{}")
                .post("/v2/checkout/orders" + "/" + order_id + "/capture");
    }
    public static Response addTrackOrderInformation(String access_token, String order_id, TrackOrder body){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2(access_token)
                .body(body)
                .post("/v2/checkout/orders" + "/" + order_id + "/track");
    }
}
