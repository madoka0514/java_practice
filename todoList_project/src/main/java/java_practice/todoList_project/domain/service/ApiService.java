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
        List tasktblList = apiRep.getTaskName();

        List<ResponseModel> resModelList = new ArrayList<>();
        List<TaskModel> taskModelList = new ArrayList<>();
        // Iteratorを使う
        Iterator tasktblListIt = tasktblList.iterator();
        while(tasktblListIt.hasNext()){

            Tasktbl tasktbl = (Tasktbl)tasktblListIt.next();

            TaskModel taskModel = new TaskModel();

            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

//            taskModel.setTaskname(tasktbl.getTaskname());
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
        List<Tasktbl> taskTblList = new ArrayList<Tasktbl>();

        for(int i=0;i<taskModelList.size();i++){
            // taskModelListから１要素ずつtaskModelに格納
//            TaskModel taskModel = new TaskModel();
            TaskModel taskModel=taskModelList.get(i);

            // taskModel1の情報をtasktblに格納
            Tasktbl tasktbl = new Tasktbl();
            tasktbl.setTaskname(taskModel.getTaskname());
            tasktbl.setPrimaryflag(taskModel.getPrimaryflag());

            // String→TimeStampに変換して格納
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            Timestamp tsDeadline = new Timestamp(sdFormat.parse(taskModel.getDeadline()).getTime());
            tasktbl.setDeadline(tsDeadline);

            // 現在時刻を格納
            Date nowDate = new Date();
            Timestamp tsNowDate = new Timestamp(nowDate.getTime());
            tasktbl.setRegdate(tsNowDate);
            tasktbl.setUpddate(tsNowDate);

            taskTblList.add(tasktbl);
        }
        apiRep.insertTask(taskTblList);
    }

    public void deleteTask(RequestModel reqModel) {
        List<TaskModel> taskModelList =reqModel.getTaskModelList();
        List<String> deleteTaskNameList = new ArrayList<String>();

        for(int i=0;i<taskModelList.size();i++){
            TaskModel taskModel=taskModelList.get(i);
            deleteTaskNameList.add(taskModel.getTaskname());
        }

        apiRep.deleteTask(deleteTaskNameList);
    }

    public void updateTask(RequestModel reqModel) throws ParseException{
        List<TaskModel> taskModelList =reqModel.getTaskModelList();
        List<Tasktbl> updateTasktblList = new ArrayList<Tasktbl>();

        for(int i=0;i<taskModelList.size();i++){
            TaskModel taskModel=taskModelList.get(i);

            // taskModel1の情報をtasktblに格納
            Tasktbl tasktbl = new Tasktbl();
            tasktbl.setTaskname(taskModel.getTaskname());
            tasktbl.setPrimaryflag(taskModel.getPrimaryflag());

            // String→TimeStampに変換して格納
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            Timestamp tsDeadline = new Timestamp(sdFormat.parse(taskModel.getDeadline()).getTime());
            tasktbl.setDeadline(tsDeadline);

            // 現在時刻を格納
            Date nowDate = new Date();
            Timestamp tsNowDate = new Timestamp(nowDate.getTime());
            tasktbl.setRegdate(tsNowDate);

            updateTasktblList.add(tasktbl);
        }

        apiRep.updateTask(updateTasktblList);
    }

}
