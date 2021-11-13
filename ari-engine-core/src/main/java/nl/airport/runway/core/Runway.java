package nl.airport.runway.core;

import com.opencsv.bean.CsvBindByPosition;

public class Runway {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String airport_ref;
    @CsvBindByPosition(position = 2)
    private String airport_ident;
    @CsvBindByPosition(position = 3)
    private String length_ft;
    @CsvBindByPosition(position = 4)
    private String width_ft;
    @CsvBindByPosition(position = 5)
    private String surface;
    @CsvBindByPosition(position = 6)
    private String lighted;
    @CsvBindByPosition(position = 7)
    private String closed;
    @CsvBindByPosition(position = 8)
    private String le_ident;
    @CsvBindByPosition(position = 9)
    private String le_latitude_deg;
    @CsvBindByPosition(position = 10)
    private String le_longitude_deg;
    @CsvBindByPosition(position = 11)
    private String le_elevation_ft;
    @CsvBindByPosition(position = 12)
    private String le_heading_degT;
    @CsvBindByPosition(position = 13)
    private String le_displaced_threshold_ft;
    @CsvBindByPosition(position = 14)
    private String he_ident;
    @CsvBindByPosition(position = 15)
    private String he_latitude_deg;
    @CsvBindByPosition(position = 16)
    private String he_longitude_deg;
    @CsvBindByPosition(position = 17)
    private String he_elevation_ft;
    @CsvBindByPosition(position = 18)
    private String he_heading_degT;
    @CsvBindByPosition(position = 19)
    private String he_displaced_threshold_ft;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirport_ref() {
        return airport_ref;
    }

    public void setAirport_ref(String airport_ref) {
        this.airport_ref = airport_ref;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public void setAirport_ident(String airport_ident) {
        this.airport_ident = airport_ident;
    }

    public String getLength_ft() {
        return length_ft;
    }

    public void setLength_ft(String length_ft) {
        this.length_ft = length_ft;
    }

    public String getWidth_ft() {
        return width_ft;
    }

    public void setWidth_ft(String width_ft) {
        this.width_ft = width_ft;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getLighted() {
        return lighted;
    }

    public void setLighted(String lighted) {
        this.lighted = lighted;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public void setLe_ident(String le_ident) {
        this.le_ident = le_ident;
    }

    public String getLe_latitude_deg() {
        return le_latitude_deg;
    }

    public void setLe_latitude_deg(String le_latitude_deg) {
        this.le_latitude_deg = le_latitude_deg;
    }

    public String getLe_longitude_deg() {
        return le_longitude_deg;
    }

    public void setLe_longitude_deg(String le_longitude_deg) {
        this.le_longitude_deg = le_longitude_deg;
    }

    public String getLe_elevation_ft() {
        return le_elevation_ft;
    }

    public void setLe_elevation_ft(String le_elevation_ft) {
        this.le_elevation_ft = le_elevation_ft;
    }

    public String getLe_heading_degT() {
        return le_heading_degT;
    }

    public void setLe_heading_degT(String le_heading_degT) {
        this.le_heading_degT = le_heading_degT;
    }

    public String getLe_displaced_threshold_ft() {
        return le_displaced_threshold_ft;
    }

    public void setLe_displaced_threshold_ft(String le_displaced_threshold_ft) {
        this.le_displaced_threshold_ft = le_displaced_threshold_ft;
    }

    public String getHe_ident() {
        return he_ident;
    }

    public void setHe_ident(String he_ident) {
        this.he_ident = he_ident;
    }

    public String getHe_latitude_deg() {
        return he_latitude_deg;
    }

    public void setHe_latitude_deg(String he_latitude_deg) {
        this.he_latitude_deg = he_latitude_deg;
    }

    public String getHe_longitude_deg() {
        return he_longitude_deg;
    }

    public void setHe_longitude_deg(String he_longitude_deg) {
        this.he_longitude_deg = he_longitude_deg;
    }

    public String getHe_elevation_ft() {
        return he_elevation_ft;
    }

    public void setHe_elevation_ft(String he_elevation_ft) {
        this.he_elevation_ft = he_elevation_ft;
    }

    public String getHe_heading_degT() {
        return he_heading_degT;
    }

    public void setHe_heading_degT(String he_heading_degT) {
        this.he_heading_degT = he_heading_degT;
    }

    public String getHe_displaced_threshold_ft() {
        return he_displaced_threshold_ft;
    }

    public void setHe_displaced_threshold_ft(String he_displaced_threshold_ft) {
        this.he_displaced_threshold_ft = he_displaced_threshold_ft;
    }

    @Override
    public String toString() {
        return "Runway{" +
                "id='" + id + '\'' +
                ", airport_ref='" + airport_ref + '\'' +
                ", airport_ident='" + airport_ident + '\'' +
                ", length_ft='" + length_ft + '\'' +
                ", width_ft='" + width_ft + '\'' +
                ", surface='" + surface + '\'' +
                ", lighted='" + lighted + '\'' +
                ", closed='" + closed + '\'' +
                ", le_ident='" + le_ident + '\'' +
                ", le_latitude_deg='" + le_latitude_deg + '\'' +
                ", le_longitude_deg='" + le_longitude_deg + '\'' +
                ", le_elevation_ft='" + le_elevation_ft + '\'' +
                ", le_heading_degT='" + le_heading_degT + '\'' +
                ", le_displaced_threshold_ft='" + le_displaced_threshold_ft + '\'' +
                ", he_ident='" + he_ident + '\'' +
                ", he_latitude_deg='" + he_latitude_deg + '\'' +
                ", he_longitude_deg='" + he_longitude_deg + '\'' +
                ", he_elevation_ft='" + he_elevation_ft + '\'' +
                ", he_heading_degT='" + he_heading_degT + '\'' +
                ", he_displaced_threshold_ft='" + he_displaced_threshold_ft + '\'' +
                '}';
    }
}
