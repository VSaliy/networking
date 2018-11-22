package com.example.packt.B04676_07_Code.visitor.functional;

@FunctionalInterface
public interface ISceneElementVisitor {
    public void visit(ISceneElement element);
}
