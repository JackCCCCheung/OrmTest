package com.example.administrator.ormtest;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yztc.dao.DaoMaster;
import com.yztc.dao.DaoSession;
import com.yztc.dao.Student;
import com.yztc.dao.StudentDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.insert)
    Button insert;
    @InjectView(R.id.update)
    Button update;
    @InjectView(R.id.select)
    Button select;
    @InjectView(R.id.delete)
    Button delete;
    @InjectView(R.id.show)
    TextView show;
    StudentDao studentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //得到dbhelper
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "test-greendao.db", null);
        //得到数据据库
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(database);
        //得到会话层
        DaoSession daoSession = daoMaster.newSession();
        //得到操作数据库的对象
        studentDao = daoSession.getStudentDao();
    }
    @OnClick({R.id.insert, R.id.update, R.id.select, R.id.delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert:
                final Student[] students=new Student[10000];
                for (int i = 0; i <10000 ; i++) {
                    Student student=new Student("jack"+i,"男",i+"");
                    students[i]=student;
                }
                takeTimes(new TakeTime() {
                    @Override
                    public void add() {
                        studentDao.insertInTx(students);
                    }

                    @Override
                    public void select() {

                    }
                }, 1);
                break;
            case R.id.update:
                break;
            case R.id.select:
                takeTimes(new TakeTime() {
                    @Override
                    public void add() {

                    }

                    @Override
                    public void select() {
                        List<Student> datas = studentDao.loadAll();
                        show.setText(datas.toString());

                    }
                }, 2);
                break;
            case R.id.delete:
                studentDao.deleteAll();
                break;
        }
    }
    interface TakeTime{
        void add();
        void select();
    }

    //测试增删改查的效率在10000条数据在700毫秒左右
    private void takeTimes(TakeTime entity,int flag) {
        long time1=System.currentTimeMillis();
        if(flag==1){
            entity.add();
        }else{
            entity.select();
        }
        long time2=System.currentTimeMillis();
        Toast.makeText(this, "花费时间是" + (time2-time1), Toast.LENGTH_SHORT).show();
    }
}
