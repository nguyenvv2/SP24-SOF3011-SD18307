package com.example.sd18307.servlet;

import com.example.sd18307.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = {"/sinh-vien/trang-chu", // GET
        "/sinh-vien/add", // POST
        "/sinh-vien/detail", //GET
        "/sinh-vien/update",// POST
})
public class HomeServlet extends HttpServlet {
    ArrayList<SinhVien> list;
    ArrayList<String> lops;

    public HomeServlet() {
        list = new ArrayList<>();
        SinhVien sinhVien = new SinhVien("Ph12345", "Nguyen Van A", 20, "HCM", "Nam", "");
        list.add(sinhVien);
        list.add(new SinhVien("Ph12311", "Nguyen Thi B", 21, "HN", "Nam", ""));

        lops = new ArrayList<>();
        lops.add("SD123");
        lops.add("Sd124");
        lops.add("SD125");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("/sinh-vien/trang-chu")) {
            request.setAttribute("lops", lops);
            request.setAttribute("listSinhVien", list);
            request.getRequestDispatcher("/sinh-vien/trang-chu.jsp").forward(request, response);
        } else if (uri.contains("/sinh-vien/detail")) {
            // mo trang detail
            String id = request.getParameter("id");
            SinhVien sinhVien = new SinhVien();
            for (SinhVien sv : list) {
                if (sv.getMaSv().equals(id)) {
                    sinhVien = sv;
                }
            }
            request.setAttribute("sinhVien", sinhVien);
            request.setAttribute("lops", lops);
            request.getRequestDispatcher("/sinh-vien/chi-tiet.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sinh-vien/add")) {
            String maSinhVien = request.getParameter("maSinhVien");
            String tenSinhVien = request.getParameter("tenSinhVien");
            Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
            String diaChi = request.getParameter("diaChi");
            String gioiTinh = request.getParameter("gioiTinh");
            String lop = request.getParameter("lop");
            SinhVien sinhVien = new SinhVien(maSinhVien, tenSinhVien, tuoi, diaChi, gioiTinh, lop);
            list.add(sinhVien);

            response.sendRedirect("/sinh-vien/trang-chu");
        } else if (uri.contains("/sinh-vien/update")) {
            // lam update
            String maSinhVien = request.getParameter("maSinhVien");
            String tenSinhVien = request.getParameter("tenSinhVien");
            System.out.println("Ma sinh vien :" + maSinhVien);
            Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
            String diaChi = request.getParameter("diaChi");
            String gioiTinh = request.getParameter("gioiTinh");
            String lop = request.getParameter("lop");
            for (SinhVien sv : list) {
                if (maSinhVien.equals(sv.getMaSv())) {
                    sv.setTuoi(tuoi);
                    sv.setGioiTinh(gioiTinh);
                    sv.setDiaChi(diaChi);
                    sv.setTenSv(tenSinhVien);
                    sv.setTenLop(lop);
                }
            }
            response.sendRedirect("/sinh-vien/trang-chu");
        }
    }
}
