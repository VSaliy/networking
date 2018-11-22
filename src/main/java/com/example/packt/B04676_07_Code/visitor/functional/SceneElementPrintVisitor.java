package com.example.packt.B04676_07_Code.visitor.functional;

public class SceneElementPrintVisitor implements ISceneElementVisitor {

    @Override
    public void visit(ISceneElement element) {
        System.out.println("Printing " + element.getName());
    }

}
