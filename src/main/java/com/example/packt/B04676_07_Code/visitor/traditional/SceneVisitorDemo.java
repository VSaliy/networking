package com.example.packt.B04676_07_Code.visitor.traditional;

public class SceneVisitorDemo {
    public static void main(String[] args) {
        ISceneElement scene = new Scene("Primary Scene");
        scene.accept(new SceneElementPrintVisitor());
        scene.accept(new SceneElementRefreshVisitor());
    }
}
