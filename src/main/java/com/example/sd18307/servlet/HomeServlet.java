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
        "/sinh-vien/delete", //GET
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
            this.hienThi(request, response);
        } else if (uri.contains("/sinh-vien/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/sinh-vien/delete")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        for (SinhVien sinhVien : list) {
            if (sinhVien.getMaSv().equals(id)) {
                list.remove(sinhVien);
                break;
            }
        }
        response.sendRedirect("/sinh-vien/trang-chu");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lops", lops);
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/sinh-vien/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sinh-vien/add")) {
            this.add(request, response);
        } else if (uri.contains("/sinh-vien/update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maSinhVien = request.getParameter("maSinhVien");
        String tenSinhVien = request.getParameter("tenSinhVien");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        String lop = request.getParameter("lop");
        SinhVien sinhVien = new SinhVien(maSinhVien, tenSinhVien, tuoi, diaChi, gioiTinh, lop);
        list.add(sinhVien);

        response.sendRedirect("/sinh-vien/trang-chu");
    }
}
