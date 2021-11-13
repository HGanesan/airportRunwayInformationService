package nl.airport.runway.core;

import com.opencsv.bean.CsvBindByPosition;

public class Airport {

    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String ident;
    @CsvBindByPosition(position = 2)
    private String type;
    @CsvBindByPosition(position = 3)
    private String name;
    @CsvBindByPosition(position = 4)
    private String latitude_deg;
    @CsvBindByPosition(position = 5)
    private String longitude_deg;
    @CsvBindByPosition(position = 6)
    private String elevation_ft;
    @CsvBindByPosition(position = 7)
    private String continent;
    @CsvBindByPosition(position = 8)
    private String iso_country;
    @CsvBindByPosition(position = 9)
    private String iso_region;
    @CsvBindByPosition(position = 10)
    private String municipality;
    @CsvBindByPosition(position = 11)
    private String scheduled_service;
    @CsvBindByPosition(position = 12)
    private String gps_code;
    @CsvBindByPosition(position = 13)
    private String iata_code;
    @CsvBindByPosition(position = 14)
    private String local_code;
    @CsvBindByPosition(position = 15)
    private String home_link;
    @CsvBindByPosition(position = 16)
    private String wikipedia_link;
    @CsvBindByPosition(position = 17)
    private String keywords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude_deg() {
        return latitude_deg;
    }

    public void setLatitude_deg(String latitude_deg) {
        this.latitude_deg = latitude_deg;
    }

    public String getLongitude_deg() {
        return longitude_deg;
    }

    public void setLongitude_deg(String longitude_deg) {
        this.longitude_deg = longitude_deg;
    }

    public String getElevation_ft() {
        return elevation_ft;
    }

    public void setElevation_ft(String elevation_ft) {
        this.elevation_ft = elevation_ft;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIso_country() {
        return iso_country;
    }

    public void setIso_country(String iso_country) {
        this.iso_country = iso_country;
    }

    public String getIso_region() {
        return iso_region;
    }

    public void setIso_region(String iso_region) {
        this.iso_region = iso_region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getScheduled_service() {
        return scheduled_service;
    }

    public void setScheduled_service(String scheduled_service) {
        this.scheduled_service = scheduled_service;
    }

    public String getGps_code() {
        return gps_code;
    }

    public void setGps_code(String gps_code) {
        this.gps_code = gps_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getLocal_code() {
        return local_code;
    }

    public void setLocal_code(String local_code) {
        this.local_code = local_code;
    }

    public String getHome_link() {
        return home_link;
    }

    public void setHome_link(String home_link) {
        this.home_link = home_link;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public void setWikipedia_link(String wikipedia_link) {
        this.wikipedia_link = wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", ident='" + ident + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", latitude_deg='" + latitude_deg + '\'' +
                ", longitude_deg='" + longitude_deg + '\'' +
                ", elevation_ft='" + elevation_ft + '\'' +
                ", continent='" + continent + '\'' +
                ", iso_country='" + iso_country + '\'' +
                ", iso_region='" + iso_region + '\'' +
                ", municipality='" + municipality + '\'' +
                ", scheduled_service='" + scheduled_service + '\'' +
                ", gps_code='" + gps_code + '\'' +
                ", iata_code='" + iata_code + '\'' +
                ", local_code='" + local_code + '\'' +
                ", home_link='" + home_link + '\'' +
                ", wikipedia_link='" + wikipedia_link + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
