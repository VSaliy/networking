package com.example.packt.B04676_07_Code.visitor.traditional;

public class SceneElementRefreshVisitor implements ISceneElementVisitor {

    @Override
    public void visit(ISceneElement element) {
        System.out.println("Refreshing " + element.getName());
    }
}
