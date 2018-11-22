package com.example.packt.B04676_07_Code.visitor.traditional;

public interface ISceneElement {    
    public String getName();
    void accept(ISceneElementVisitor visitor);
}
