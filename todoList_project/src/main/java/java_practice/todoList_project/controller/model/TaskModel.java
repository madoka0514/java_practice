package java_practice.todoList_project.controller.model;


import java.util.Date;
import lombok.Data;

/**
 * Table: TaskModel
 */
@Data
public class TaskModel {
    /**
     * Column: taskname
     */
    private String taskname;

    /**
     * Column: deadline
     */
    private Date deadline;

    /**
     * Column: primaryflag
     */
    private String primaryflag;

    /**
     * Column: regdate
     */
    private Date regdate;

    /**
     * Column: upddate
     */
    private Date upddate;
}

