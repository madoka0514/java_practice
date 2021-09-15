package java_practice.todoList_project.domain.repository;

import java_practice.todoList_project.domain.repository.entity.Tasktbl;
import java_practice.todoList_project.domain.repository.entity.TasktblExample;
import java_practice.todoList_project.domain.repository.mapper.TaskTblMapper;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public void insertTask(@NotNull List<Tasktbl> taskTblList) {
        // 拡張for文
        for(Tasktbl tasktbl : taskTblList){
            taskMp.insert(tasktbl);
        }
    }

    public void deleteTask(@NotNull List<String> deleteTaskNameList) {
        for(String deleteTaskName : deleteTaskNameList) {
            taskMp.deleteByPrimaryKey(deleteTaskName);
        }
    }

    public void updateTask(@NotNull List<Tasktbl> updateTaskTblList) {
        for(Tasktbl tasktbl:updateTaskTblList){
            taskMp.updateByPrimaryKey(tasktbl);
        }
    }

    public List<Tasktbl> getFinishTaskList() {
        TasktblExample tasktblExample = new TasktblExample();
        // フラグが９（完了）のタスクを取得
        tasktblExample.createCriteria().andPrimaryflagEqualTo("9");
        // deadlineでソートして取得
        tasktblExample.setOrderByClause("deadline");
        return taskMp.selectByExample(tasktblExample);
    }
}