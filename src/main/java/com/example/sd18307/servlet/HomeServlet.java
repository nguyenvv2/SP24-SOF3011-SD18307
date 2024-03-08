package com.example.sd18307.servlet;

import com.example.sd18307.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = "/sinh-vien/trang-chu")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SinhVien sinhVien = new SinhVien("Ph12345","Nguyen Van A", 20,"HCM");
        request.setAttribute("sinhVien", sinhVien);
        ArrayList<String> str = new ArrayList<>();
        str.add("Nguyen Van A");
        str.add("Nguyen Van B");
        str.add("Nguyen Van C");
        str.add("Nguyen Van B");


        request.getRequestDispatcher("/sinh-vien/trang-chu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");
    }
}