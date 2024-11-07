package com.example.demo1.repository;

import com.example.demo1.model.Demo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepo implements IDemoRepo{
    private static ArrayList<Demo> demoArrayList = new ArrayList<>();
    static {
        demoArrayList.add(new Demo(1,"Công","Đầu cha m đó "));
        demoArrayList.add(new Demo(1,"Công","Đầu cha m đó "));
        demoArrayList.add(new Demo(1,"Công","Đầu cha m đó "));
        demoArrayList.add(new Demo(1,"Công","Đầu cha m đó "));
        demoArrayList.add(new Demo(1,"Công","Đầu cha m đó "));
        demoArrayList.add(new Demo(1,"Công","Đầu cha m đó "));
    }
    @Override
    public List<Demo> selectAllDemo() {
        return demoArrayList;
    }
}
