document.getElementById('weather-form').addEventListener('submit', async (e) => {
    e.preventDefault();
  
    const country = document.getElementById('country-input').value.trim();
    const state = document.getElementById('state-input').value.trim();
    const city = document.getElementById('city-input').value.trim();
  
    if (country && state && city) {
      try {
        const response = await fetch(`/weather?country=${country}&state=${state}&city=${city}`);
        const data = await response.json();
  
        if (data.success) {
          document.getElementById('location-name').textContent = `${city}, ${state}, ${country}`;
          document.getElementById('temperature').textContent = `Temperature: ${data.temperature}°C`;
          document.getElementById('humidity').textContent = `Humidity: ${data.humidity}%`;
          document.getElementById('rainfall').textContent = `Rainfall: ${data.rainfall} mm`;
        } else {
          alert('Weather data not found for the given location.');
        }
      } catch (error) {
        console.error('Error fetching weather data:', error);
        alert('Failed to fetch weather data. Please try again later.');
      }
    } else {
      alert('Please fill out all fields.');
    }
  });
  