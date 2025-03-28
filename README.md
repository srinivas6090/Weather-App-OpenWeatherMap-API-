# Weather App 🌤️

A responsive web application that provides real-time weather updates such as temperature, humidity, and rainfall based on user inputs for country, state, and city.

## Features
- **Real-Time Data Fetching**: Fetch weather information using the OpenWeatherMap API.
- **Location-Based Search**: Input country, state, and city to get specific weather details.
- **Responsive Design**: Works seamlessly across devices with a user-friendly interface.
- **Backend Integration**: Java servlet handles API requests and responses.

## Technologies Used
- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java Servlets
- **API**: OpenWeatherMap API


##Replace the API Key:
Open WeatherServlet.java in the src directory.
Replace "YOUR_API_KEY" with your own OpenWeatherMap API key:
    private static final String API_KEY = "your_api_key_here";

Deploy the application:
Package the project as a .war file and deploy it to an Apache Tomcat server, or run it directly through your IDE (Eclipse/IntelliJ) with Tomcat configured.

Access the application:
Open your browser and go to http://localhost:8080/your-app-name.
