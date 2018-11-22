package com.example.packt.B04676_07_Code.visitor.functional;

public class PlantElement implements ISceneElement {
    private String name;
    
    public PlantElement(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return this.name;
    } 

}
