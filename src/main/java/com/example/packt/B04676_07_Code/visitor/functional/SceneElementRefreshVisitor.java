package com.example.packt.B04676_07_Code.visitor.functional;

public class SceneElementRefreshVisitor implements ISceneElementVisitor {

    @Override
    public void visit(ISceneElement element) {
        System.out.println("Refesh " + element.getName());
    }
    
}
