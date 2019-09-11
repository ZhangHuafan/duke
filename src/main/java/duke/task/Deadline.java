package duke.task;

import java.time.LocalDateTime;

/**
 * This is one kind of <code>Task</code> to specify the details and due date for the item in the task list.
 */
public class Deadline extends Task {

    private LocalDateTime dueDateTime;

    /**
     * {@inheritDoc} This is a class constructor specifying the description and the due dateTime. The
     * <code>isDone</code> status is set to be <code>false</code> by default.
     *
     * @param dueDateTime a <code>LocalDateTime</code> object to specify the due date and time
     */
    public Deadline(String description, LocalDateTime dueDateTime) {
        super(description);
        this.dueDateTime = dueDateTime;
    }

    /**
     * {@inheritDoc} This is a class constructor specifying the description, the due dateTime ane the
     * <code>isDone</code> status.
     *
     * @param dueDateTime a <code>LocalDateTime</code> object to specify the due date and time
     */
    public Deadline(String description, LocalDateTime dueDateTime, boolean isDone) {
        super(description, isDone);
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    /**
     * {@inheritDoc}
     *
     * @return a string representing this todo in the format of a tag "[D]" at the start, followed by the description
     * and the due date time
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatter.format(dueDateTime) + ")";
    }

    /**
     * {@inheritDoc} Compares two <code>Todo</code> objects by their descriptions, <code>isDone</code> status,
     * <code>dueDateTime</code>.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof Deadline && this.dueDateTime.equals(((Deadline) obj).dueDateTime);
    }
}