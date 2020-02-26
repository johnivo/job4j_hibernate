package ru.job4j.hiber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.hiber.models.Item;
import ru.job4j.hiber.services.DBLogic;
import ru.job4j.hiber.services.ILogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 19.02.2020
 */
public class ItemController extends HttpServlet {

    private final ILogic logic = DBLogic.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");

        List<Item> items = logic.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(items);
        PrintWriter out = resp.getWriter();
        out.append(json);
        out.flush();
    }

}
