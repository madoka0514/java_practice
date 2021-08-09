package java_practice.todoList_project.domain.repository;

import java_practice.todoList_project.domain.repository.mapper.TaskTblMapper;
import model.Tasktbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiRepository {
    @Autowired
    TaskTblMapper taskMp;

    public Tasktbl getTaskName(){
        return taskMp.selectAll();
    }
}