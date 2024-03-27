package com.example.sd18307.repository;

import com.example.sd18307.connect.HibernateUtils;
import com.example.sd18307.model.SanPham;
import org.hibernate.Session;

import java.util.ArrayList;

public class SanPhamRepository {

    public ArrayList<SanPham> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        ArrayList<SanPham> list =
                (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        session.close();
        return list;
    }
}
