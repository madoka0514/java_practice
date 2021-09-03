package java_practice.todoList_project.domain.repository;

import java_practice.todoList_project.domain.repository.entity.Tasktbl;
import java_practice.todoList_project.domain.repository.mapper.TaskTblMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiRepository {
    @Autowired
    TaskTblMapper taskMp;

    // 全タスクを取得
    public List<Tasktbl> getTaskName(){
        return taskMp.selectAll();
    }

    //新規タスクを登録
    public void insertTask(List<Tasktbl> taskTblList) {

        for(int i=0;i<taskTblList.size();i++){
            Tasktbl tasktbl = new Tasktbl();
            tasktbl = taskTblList.get(i);
            taskMp.insert(tasktbl);
        }
    }

    public void deleteTask(List<String> deleteTaskNameList) {
        for(int i=0;i<deleteTaskNameList.size();i++){
            String deleteTaskName= deleteTaskNameList.get(i);
            taskMp.deleteByPrimaryKey(deleteTaskName);
        }
    }

    public void updateTask(List<Tasktbl> updateTasktblList) {
        for(int i=0;i<updateTasktblList.size();i++){
            Tasktbl tasktbl = new Tasktbl();
            tasktbl = updateTasktblList.get(i);
            taskMp.updateByPrimaryKey(tasktbl);
        }
    }
}