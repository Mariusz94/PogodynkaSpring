package pl.mariuszlyszczarz.Pogodynka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mariuszlyszczarz.Pogodynka.models.WeatherModel;
import pl.mariuszlyszczarz.Pogodynka.models.services.ForNext5DaysWeather;
import pl.mariuszlyszczarz.Pogodynka.models.services.UploadWeather;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String menu(){
        return "menu";
    }

    @PostMapping("/")
        public String menuPost(@RequestParam("number") int number){
        if(number == 1) return "weather";
        return "weather5";
    }

    @GetMapping("/weather")
    public String weather() {
        return "weather";
    }

    @PostMapping("/weather")
    public String weatherPost(@RequestParam("city") String city, Model model) {
        UploadWeather uploadWeather = new UploadWeather();

        WeatherModel weather = uploadWeather.getWeather(city);

        model.addAttribute("text", weather);

        return "weather";
    }


    @GetMapping("/weather5")
    public String weather5() {
        return "weather5";
    }

    @PostMapping("/weather5")
    public String weather5Post(@RequestParam("city") String city, Model model) {

        ForNext5DaysWeather forNext5DaysWeather = new ForNext5DaysWeather();

        List<WeatherModel> weather5 = forNext5DaysWeather.getWeather5days(city);

        model.addAttribute("text5", weather5);

        return "weather5";
    }



}
