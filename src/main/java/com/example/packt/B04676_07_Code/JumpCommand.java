package com.example.packt.B04676_07_Code;

public class JumpCommand implements Command{
   private final Move move;

   public JumpCommand(Move move){
      this.move=move;
   }

   @Override
   public boolean execute() {
      return move.jump();
   }
}