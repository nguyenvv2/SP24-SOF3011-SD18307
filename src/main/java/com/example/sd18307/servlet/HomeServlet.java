package com.example.sd18307.servlet;

import com.example.sd18307.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = {"/sinh-vien/trang-chu",
        "/sinh-vien/add",
})
public class HomeServlet extends HttpServlet {
    ArrayList<SinhVien> list;

    public HomeServlet() {
        list = new ArrayList<>();
        SinhVien sinhVien = new SinhVien("Ph12345", "Nguyen Van A", 20, "HCM", "Nam", "");
        list.add(sinhVien);
        list.add(new SinhVien("Ph12311", "Nguyen Thi B", 21, "HN", "Nam", ""));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSinhVien", list);
        request.getRequestDispatcher("/sinh-vien/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSinhVien = request.getParameter("maSinhVien");
        String tenSinhVien = request.getParameter("tenSinhVien");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        System.out.println(gioiTinh);
        SinhVien sinhVien = new SinhVien(maSinhVien, tenSinhVien, tuoi, diaChi, gioiTinh, "");
        list.add(sinhVien);

        response.sendRedirect("/sinh-vien/trang-chu");
    }
}
