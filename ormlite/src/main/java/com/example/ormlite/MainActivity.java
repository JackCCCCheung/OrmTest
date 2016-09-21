package com.example.ormlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.litesuits.orm.LiteOrm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    LiteOrm liteOrm;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        liteOrm=LiteOrm.newCascadeInstance(this,"liteOrm.db");
    }
    @OnClick({R.id.delete,R.id.insert,R.id.select,R.id.update})
    public void onClick(View view ){
        switch (view.getId()) {
            case R.id.insert:
                takeTimes(new TakeTime() {
                    @Override
                    public void add() {
                        List<Person> list=new ArrayList<>();
                        for (int i = 0; i <1000 ; i++) {
                            Person person=new Person("jack"+i,""+i,"nan");
                            list.add(person);
                        }
                    }

                    @Override
                    public void select() {

                    }
                },0);

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
                                List<Person> list=liteOrm.query(Person.class);
                                show.setText(list.toString());
                    }
                },1);
                break;
            case R.id.delete:
                break;
        }
    }
    interface TakeTime{
        void add();
        void select();
    }
    private void takeTimes(TakeTime entity,int flag) {
        long time1=System.currentTimeMillis();
        if(flag==0){
            entity.add();
        }else{
            entity.select();
        }
        long time2=System.currentTimeMillis();
        Toast.makeText(this, "花费时间是" + (time2 - time1), Toast.LENGTH_SHORT).show();
    }
}
