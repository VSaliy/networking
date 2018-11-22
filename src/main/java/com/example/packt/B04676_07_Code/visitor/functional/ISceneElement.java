package com.example.packt.B04676_07_Code.visitor.functional;

@FunctionalInterface
public interface ISceneElement {
    
    public String getName();
    
    public default void accept(ISceneElementVisitor visitor) {
        visitor.visit(this);
    }    
}
