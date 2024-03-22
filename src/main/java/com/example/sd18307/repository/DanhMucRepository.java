package com.example.sd18307.repository;

import com.example.sd18307.connect.HibernateUtils;
import com.example.sd18307.model.DanhMuc;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;

public class DanhMucRepository {

    Session session;
    public ArrayList<DanhMuc> getList() {
        ArrayList<DanhMuc> list = new ArrayList<>();
        session = HibernateUtils.getFACTORY().openSession();
        list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc ").list();
        session.close();
        return list;
    }

//    public static void main(String[] args) {
//        ArrayList<DanhMuc> list = new DanhMucRepository().getList();
//        for (DanhMuc danhMuc :list){
//            System.out.println(danhMuc.toString());
//        }
//    }
}
