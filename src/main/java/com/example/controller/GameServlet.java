package com.example.controller;

import com.example.model.Game;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

public class GameServlet extends HttpServlet {

    private Game game;

    @Override
    public void init() throws ServletException {
        game = new Game();  // Создаем объект игры
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("game", game);
        RequestDispatcher dispatcher = request.getRequestDispatcher("game.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("start".equals(action)) {
            game.startGame();  // Начать игру
        } else if ("attack".equals(action)) {
            game.attack();  // Игрок атакует
        } else if ("levelUp".equals(action)) {
            game.levelUp();  // Игрок повышает уровень
        } else if ("restart".equals(action)) {
            game.restartGame();  // Рестарт игры
        }

        // Если игра завершена, отображаем сообщение о поражении
        if (game.isGameOver()) {
            request.setAttribute("message", game.getGameOverMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);
        } else {
            doGet(request, response);  // Обновляем страницу игры
        }
    }


}



