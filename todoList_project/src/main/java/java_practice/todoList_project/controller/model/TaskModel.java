package java_practice.todoList_project.controller.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Table: TaskModel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskModel {
    /**
     * Column: taskname
     */
    private String taskname;

    /**
     * Column: deadline
     */
    private String deadline;

    /**
     * Column: primaryflag
     */
    private String primaryflag;

    /**
     * Column: regdate
     */
    private String regdate;

    /**
     * Column: upddate
     */
    private String upddate;
}

