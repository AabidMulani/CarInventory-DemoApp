package in.abmulani.carinventory.utils;

public class AppConstants {

    public static final String BASE_URL = "http://52.74.217.95:8080/CallAtHomeServerApp/webservices/";
    public static final int STATUS_ERROR = 0;
    public static final int STATUS_SUCCESS = 1;
    public static final String NO_INTERNET_EXCEPTION = "com.callAtHome.consumer.noInternet";

    public static String getBaseUrl() {
        return BASE_URL;
    }


}
