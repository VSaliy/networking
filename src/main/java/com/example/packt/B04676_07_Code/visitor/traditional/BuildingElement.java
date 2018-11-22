package com.example.packt.B04676_07_Code.visitor.traditional;

public class BuildingElement implements ISceneElement {
    private String name;
 
    public BuildingElement(String name) {
        this.name = name;
    }
 
    public String getName() {
        return this.name;
    }
 
    @Override
    public void accept(ISceneElementVisitor visitor) {
        visitor.visit(this);
    }
}