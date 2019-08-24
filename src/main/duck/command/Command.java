package duck.command;

import duck.util.TaskList;
import duck.util.Storage;
import duck.util.Ui;

public abstract class Command {

    protected boolean isExit;

    public Command() {
        isExit = false;
    }

    public boolean isExit() {
        return isExit;
    }

    abstract public void execute(TaskList taskList, Ui ui, Storage storage);
}