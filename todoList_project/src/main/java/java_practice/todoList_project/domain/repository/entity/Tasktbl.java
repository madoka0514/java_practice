package java_practice.todoList_project.domain.repository.entity;

import java.util.Date;
import lombok.Data;

/**
 * Table: tasktbl
 */
@Data
public class Tasktbl {
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