package com.example.ormlite;

import android.support.annotation.NonNull;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
@Table(value = "person")
public class Person {
    @PrimaryKey(value = AssignType.AUTO_INCREMENT)
    @NotNull
    private long id;
    @Column(value ="name")
    @NotNull
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getAge() {
        return age;
    }

    public void setAge(@NonNull String age) {
        this.age = age;
    }

    @NonNull
    public String getSex() {
        return sex;
    }

    public void setSex(@NonNull String sex) {
        this.sex = sex;
    }

    @Column(value = "age")
    @NonNull
    private String age;
    @Column(value = "sex")
    @NonNull
    private String sex;
    public Person(@NonNull String name, @NonNull String age, @NonNull String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person() {
    }

    public Person(@NonNull long id, @NonNull String name, @NonNull String age, @NonNull String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Stundet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
