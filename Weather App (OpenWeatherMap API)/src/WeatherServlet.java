import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.json.JSONObject;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String city = request.getParameter("city");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Construct the API URL
            String apiUrl = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s,%s,%s&units=metric&appid=%s",
                city, state, country, API_KEY
            );

            // Fetch data from the API
            String jsonResponse = HttpRequestUtil.fetch(apiUrl);

            // Parse JSON response
            JSONObject jsonObject = new JSONObject(jsonResponse);

            if (jsonObject.has("main")) {
                double temperature = jsonObject.getJSONObject("main").getDouble("temp");
                int humidity = jsonObject.getJSONObject("main").getInt("humidity");
                double rainfall = jsonObject.has("rain") ? jsonObject.getJSONObject("rain").optDouble("1h", 0.0) : 0.0;

                JSONObject result = new JSONObject();
                result.put("success", true);
                result.put("temperature", temperature);
                result.put("humidity", humidity);
                result.put("rainfall", rainfall);

                out.print(result.toString());
            } else {
                JSONObject result = new JSONObject();
                result.put("success", false);
                out.print(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JSONObject result = new JSONObject();
            result.put("success", false);
            out.print(result.toString());
        }
    }
}
