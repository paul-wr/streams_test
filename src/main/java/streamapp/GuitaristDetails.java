package main.java.streamapp;

public class GuitaristDetails {
    private String name;
    private String model;
    private String make;


    public GuitaristDetails(String name, String model, String make) {
        this.name = name;
        this.model = model;
        this.make = make;
    }

    public String getName(){
        return this.name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setName(String name1){
        this.name = name;
    }

}
