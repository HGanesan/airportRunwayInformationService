package nl.airport.runway.core;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Country {
    @CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByName(column = "code")
    @CsvBindByPosition(position = 1)
    private String code;
    @CsvBindByName(column = "name")
    @CsvBindByPosition(position = 2)
    private String name;
    @CsvBindByName(column = "continent")
    @CsvBindByPosition(position = 3)
    private String continent;
    @CsvBindByName(column = "wikipedia_link")
    @CsvBindByPosition(position = 4)
    private String wikipedia_link;
    @CsvBindByName(column = "keywords")
    @CsvBindByPosition(position = 5)
    private String keywords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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
        return "Country{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", wikipedia_link='" + wikipedia_link + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
