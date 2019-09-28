package duke.command;

import duke.task.Task;
import duke.util.DukeException;
import duke.util.Storage;
import duke.util.TaskList;
import duke.util.Ui;

import java.io.IOException;

/**
 * This is a <code>Command</code> to add a new task to the task list. After the <code>execute</code>, The new
 * task, if it is a duplicate of another existing task, will be added to the task list.
 */
public class AddCommand extends  Command {

    private Task newTask;

    public AddCommand(Task newTask) {
        this.newTask = newTask;
    }

    /**
     * Adds a new <code>Task</code> object to the task list and shows the user the successful execution of
     * adding. If the specified task has completely same information as any existing task, the user will be informed
     * and the task will not be added.
     *
     * @param taskList {@inheritDoc}
     * @param ui       {@inheritDoc}
     * @param storage  {@inheritDoc}
     * @return         a string showing the specified task is added to the task list
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        if (taskList.contains(newTask)) {
            return ui.showTaskDuplicated();
        }
        taskList.add(newTask);
        try {
            storage.recordTasks(taskList);
        } catch (IOException e) {
            return ui.showSavingError();
        }
        return ui.showTaskAdded(taskList.getTotalTask(), newTask);
    }
}
