package duke.task;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This is one kind of <code>Task</code> to specify the details and the duration for the item in the task list.
 */
public class Event extends Task {

    private LocalDateTime startDateTime;
    private LocalTime endTime;

    /**
     * {@inheritDoc} This is a class constructor specifying the description, start time and end time for the task. The
     * <code>isDone</code> status is set to be <code>false</code> by default.
     *
     * @param startDateTime a <code>LocalDateTime</code> object to specify the start date and time of this event
     * @param endTime       a <code>LocalTime</code> object to specify the end time of this event
     */
    public Event(String description, LocalDateTime startDateTime, LocalTime endTime) {
        super(description);
        this.startDateTime = startDateTime;
        this.endTime = endTime;
    }

    /**
     * {@inheritDoc} This is a class constructor specifying the description, start time, end time, and
     * <code>isDone</code> status of the task.
     *
     * @param startDateTime a <code>LocalDateTime</code> object to specify the start date and time of this event
     * @param endTime       a <code>LocalTime</code> object to specify the end time of this event
     */
    public Event(String description, LocalDateTime startDateTime, LocalTime endTime, boolean isDone) {
        super(description, isDone);
        this.startDateTime = startDateTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * {@inheritDoc}
     *
     * @return a string representing this todo in the format of a tag "[E]" at the start, followed by the description,
     * the start date time, and the end time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + formatter.format(startDateTime) + " - " + endTime + ")";
    }

    /**
     * {@inheritDoc} Compares two <code>Todo</code> objects by their descriptions, <code>isDone</code> status,
     * <code>startDateTime</code>, and <code>endTime</code>.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && obj instanceof Event && this.startDateTime.equals(startDateTime)
                && this.endTime.equals(endTime);
    }
}