package com.yztc.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "STUDENT".
 */
public class Student {

    private Long id;
    /** Not-null value. */
    private String name;
    /** Not-null value. */
    private String sex;
    /** Not-null value. */
    private String age;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Student(Long id) {
        this.id = id;
    }
    public Student(String name, String sex, String age){
        this.name = name;
        this.sex = sex;
        this.age = age;

    }
    public Student(Long id, String name, String sex, String age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getSex() {
        return sex;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /** Not-null value. */
    public String getAge() {
        return age;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAge(String age) {
        this.age = age;
    }

}