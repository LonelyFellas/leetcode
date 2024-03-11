import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Day2 day2 = new Day2();

        var demo = new String[] {"flower","flow","flight"};
        day2.longestCommonPrefix(demo);
    }
}