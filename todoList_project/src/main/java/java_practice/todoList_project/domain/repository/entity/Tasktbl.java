package java_practice.todoList_project.domain.repository.entity;

import java.sql.Timestamp;
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
    private Timestamp deadline;

    /**
     * Column: primaryflag
     */
    private String primaryflag;

    /**
     * Column: regdate
     */
    private Timestamp regdate;

    /**
     * Column: upddate
     */
    private Timestamp upddate;
}