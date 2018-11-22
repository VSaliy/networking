package com.example.packt.B04676_07_Code;

import java.util.ArrayList;
import java.util.List;

public class Commands {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command action) {
        commands.add(action);
    }

    public void executeCommand() {
        commands.forEach(Command::execute);
    }
}
