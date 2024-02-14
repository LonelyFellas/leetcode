import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
//        System.out.println(day1.minOperations("110"));
        System.out.println(day1.minOperations("001011"));
    }
}