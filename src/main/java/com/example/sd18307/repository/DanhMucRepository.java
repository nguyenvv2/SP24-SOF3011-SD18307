package com.example.sd18307.repository;

import com.example.sd18307.connect.HibernateUtils;
import com.example.sd18307.model.DanhMuc;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepository {

    Session session;

    public ArrayList<DanhMuc> getList() {
        ArrayList<DanhMuc> list = new ArrayList<>();
        session = HibernateUtils.getFACTORY().openSession();
        list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc ORDER BY ngayTao ASC ").list();
        session.close();
        return list;
    }

    public void add(DanhMuc danhMuc) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(danhMuc);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }


    }

}
