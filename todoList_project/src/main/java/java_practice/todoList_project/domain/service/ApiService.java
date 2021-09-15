package java_practice.todoList_project.domain.service;

import java_practice.todoList_project.controller.model.RequestModel;
import java_practice.todoList_project.controller.model.ResponseModel;
import java_practice.todoList_project.controller.model.TaskModel;
import java_practice.todoList_project.domain.repository.ApiRepository;
import java_practice.todoList_project.domain.repository.entity.Tasktbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    ApiRepository apiRep;
    public  ResponseModel getAllTask(){
        // Modelの宣言
        ResponseModel resModel = new ResponseModel();

        // タスク一覧を受け取る
        List<Tasktbl> taskTblList = apiRep.getTaskName();

        List<TaskModel> taskModelList = new ArrayList<>();
        // Iteratorを使う
        Iterator<Tasktbl> taskTblListIt = taskTblList.iterator();
        while(taskTblListIt.hasNext()){

            Tasktbl tasktbl = taskTblListIt.next();

            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            TaskModel taskModel2 = TaskModel.builder()
                    .deadline(df.format(tasktbl.getDeadline()))
                    .taskname(tasktbl.getTaskname())
                    .primaryflag(tasktbl.getPrimaryflag())
                    .regdate(df.format(tasktbl.getRegdate()))
                    .upddate(df.format(tasktbl.getUpddate()))
                    .build();

            taskModelList.add(taskModel2);

            resModel.setTaskModelList(taskModelList);
        }
        return  resModel;
    }

    public void insertTask(RequestModel reqModel) throws ParseException {

        List<TaskModel> taskModelList =reqModel.getTaskModelList();
        List<Tasktbl> taskTblList = new ArrayList<>();

        for(TaskModel taskModel:taskModelList){

            // taskModel1の情報をtaskTblに格納
            Tasktbl taskTbl = new Tasktbl();
            taskTbl.setTaskname(taskModel.getTaskname());

            // フラグを格納（新規登録時は０（未着手））
            taskTbl.setPrimaryflag("0");

            // String→TimeStampに変換して格納
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            Timestamp tsDeadline = new Timestamp(sdFormat.parse(taskModel.getDeadline()).getTime());
            taskTbl.setDeadline(tsDeadline);

            // 現在時刻を格納
            Date nowDate = new Date();
            Timestamp tsNowDate = new Timestamp(nowDate.getTime());
            taskTbl.setRegdate(tsNowDate);
            taskTbl.setUpddate(tsNowDate);

            taskTblList.add(taskTbl);
        }
        apiRep.insertTask(taskTblList);
    }

    public void deleteTask(RequestModel reqModel) {
        List<TaskModel> taskModelList =reqModel.getTaskModelList();
        List<String> deleteTaskNameList = new ArrayList<>();

        for(TaskModel taskModel:taskModelList){
            deleteTaskNameList.add(taskModel.getTaskname());
        }

        apiRep.deleteTask(deleteTaskNameList);
    }

    public void updateTask(RequestModel reqModel) throws ParseException{
        List<TaskModel> taskModelList =reqModel.getTaskModelList();
        List<Tasktbl> updateTaskTblList = new ArrayList<>();

        for(TaskModel taskModel:taskModelList){
            // taskModelの情報をtaskTblに格納
            Tasktbl taskTbl = new Tasktbl();
            taskTbl.setTaskname(taskModel.getTaskname());
            taskTbl.setPrimaryflag(taskModel.getPrimaryflag());

            // String→TimeStampに変換して格納
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            Timestamp tsDeadline = new Timestamp(sdFormat.parse(taskModel.getDeadline()).getTime());
            taskTbl.setDeadline(tsDeadline);

            // 現在時刻を格納
            Date nowDate = new Date();
            Timestamp tsNowDate = new Timestamp(nowDate.getTime());
            taskTbl.setRegdate(tsNowDate);

            updateTaskTblList.add(taskTbl);
        }

        apiRep.updateTask(updateTaskTblList);
    }

    public ResponseModel getFinishTaskList() {
        // 完了済みタスク一覧を受け取る
        List<Tasktbl> finishTaskTblList = apiRep.getFinishTaskList();
        ResponseModel resModel = new ResponseModel();

        for(Tasktbl taskTbl:finishTaskTblList){
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            TaskModel taskModel = TaskModel.builder()
                    .deadline(df.format(taskTbl.getDeadline()))
                    .taskname(taskTbl.getTaskname())
                    .primaryflag(taskTbl.getPrimaryflag())
                    .regdate(df.format(taskTbl.getRegdate()))
                    .upddate(df.format(taskTbl.getUpddate()))
                    .build();

            List<TaskModel> taskModelList = new ArrayList<>();
            taskModelList.add(taskModel);

            resModel.setTaskModelList(taskModelList);
        }
        return resModel;
    }
}
