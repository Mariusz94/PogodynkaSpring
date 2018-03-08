package pl.mariuszlyszczarz.Pogodynka.models.services;


import org.json.JSONArray;
import org.json.JSONObject;
import pl.mariuszlyszczarz.Pogodynka.models.Utils;
import pl.mariuszlyszczarz.Pogodynka.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class ForNext5DaysWeather {
    private static ForNext5DaysWeather ourInstance = new ForNext5DaysWeather();

    public static ForNext5DaysWeather getInstance() {
        return ourInstance;
    }

    public ForNext5DaysWeather() {
    }

    public WeatherModel getWeather(String city, int j) {
        String websiteResponse = Utils.readWebsiteContent("http://api.openweathermap.org/data/2.5/forecast?q=" + city + ",pl&appid=309de344ece3620d91da5bf4945d9265");
        String description = null;
        int temperature;
        int pressure;
        int humidity;
        int clouds;
        String dt_txt = null;

        JSONObject root = new JSONObject(websiteResponse);
        JSONArray listArray = root.getJSONArray("list");
        JSONObject elementInArrayList = listArray.getJSONObject(j);

        JSONArray weatherObject = elementInArrayList.getJSONArray("weather");
        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("main");
        }

        JSONObject main = elementInArrayList.getJSONObject("main");

        temperature = (int) main.getFloat("temp");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");

        JSONObject cloudsObject = elementInArrayList.getJSONObject("clouds");
        clouds = cloudsObject.getInt("all");

        dt_txt = elementInArrayList.getString("dt_txt");


        return new WeatherModel
                .Builder(city)
                .setClouds(clouds)
                .setPressure(pressure)
                .setTemperature(temperature - 273)
                .setWeatherComment(description)
                .setHumidity(humidity)
                .setDt_txt(dt_txt)
                .build();
    }

    public List<WeatherModel> getWeather5days (String city){
        List<WeatherModel> list5days = new ArrayList<>();

        list5days.add(getWeather(city, 4));
        list5days.add(getWeather(city, 12));
        list5days.add(getWeather(city, 20));
        list5days.add(getWeather(city, 28));
        list5days.add(getWeather(city, 36));

        return list5days;
    }


}
