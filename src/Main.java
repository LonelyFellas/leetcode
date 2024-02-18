import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        var a = new int[][]{{2, 6},{1, 3},   {8, 10}, {15, 18}};
        System.out.println(day1.merge(a));
    }
}