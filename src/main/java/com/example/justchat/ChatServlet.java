package com.example.justchat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/chat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Post - Redirect - Get
        // form으로 받을 것임
        String model = req.getParameter("model");
        String message = req.getParameter("message");
        HttpSession session = req.getSession();
        List<String> chat = null;
        try {
            // ArrayList<String> 타입으로 다운캐스팅
            chat = (ArrayList<String>) session.getAttribute("chat");
        } catch (Exception e){
            // 예외처리를 더 상세히 가져가도 괜찮음
            chat = new ArrayList<>(); // 에러가 있으면 빈 리스트
        }
        chat.add("나 : %s".formatted(message));
        chat.add("%s : %s".formatted(model, message));
        req.setAttribute("chat", chat); // -> el -> jstl(for-each)
    }
}