package pl.mariuszlyszczarz.Pogodynka.models;

public class WeatherModel {
    private String cityName;
    private int temperature;
    private int pressure;
    private int humidity;
    private int clouds;
    private String weatherComment;
    private String dt_txt;

    private WeatherModel(Builder builder) {
        cityName = builder.getCityName();
        temperature = builder.getTemperature();
        pressure = builder.getPressure();
        humidity = builder.getHumidity();
        clouds = builder.getClouds();
        weatherComment = builder.getWeatherComment();
        dt_txt = builder.getDt_txt();
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public String getWeatherComment() {
        return weatherComment;
    }

    public void setWeatherComment(String weatherComment) {
        this.weatherComment = weatherComment;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", clouds=" + clouds +
                ", weatherComment='" + weatherComment + '\'' +
                '}';
    }

    public static class Builder {
        private String cityName;
        private int temperature;
        private int pressure;
        private int humidity;
        private int clouds;
        private String weatherComment;
        private String dt_txt;

        public Builder(String cityName){
            this.cityName = cityName;
        }

        public Builder setTemperature(int temp){
            this.temperature = temp;
            return this;
        }

        public Builder setPressure(int pressure){
            this.pressure = pressure;
            return this;
        }

        public Builder setHumidity(int humidity){
            this.humidity = humidity;
            return this;
        }

        public Builder setClouds(int clouds){
            this.clouds = clouds;
            return this;
        }

        public Builder setWeatherComment(String comment){
            this.weatherComment = comment;
            return this;
        }

        public Builder setDt_txt(String dt_txt){
            this.dt_txt = dt_txt;
            return this;
        }


        public String getCityName() {
            return cityName;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getClouds() {
            return clouds;
        }

        public String getWeatherComment() {
            return weatherComment;
        }

        public String getDt_txt() {
            return dt_txt;
        }

        public WeatherModel build(){
            return new WeatherModel(this);
        }
    }
}
