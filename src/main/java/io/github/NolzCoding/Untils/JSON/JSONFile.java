package io.github.NolzCoding.Untils.JSON;

public class JSONFile {

    private String type;
    private double size;
    private String sizeUnit;
    private String url;


    public JSONFile(String type, double size, String sizeUnit, String url) {
        this.type = type;
        this.size = size;
        this.sizeUnit = sizeUnit;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
