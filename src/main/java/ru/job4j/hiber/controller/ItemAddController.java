package ru.job4j.hiber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.hiber.models.Item;
import ru.job4j.hiber.services.DBLogic;
import ru.job4j.hiber.services.ILogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 19.02.2020
 */
public class ItemAddController extends HttpServlet {

    private final ILogic logic = DBLogic.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json");

        BufferedReader in = req.getReader();
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();

        Item item = mapper.readValue(sb.toString(), Item.class);
        item.setCreated(Calendar.getInstance());
        item.setDone(false);

        Item added = logic.add(item);
        PrintWriter out = resp.getWriter();
        String json = mapper.writeValueAsString(added);
        out.append(json);
        out.flush();
    }

}
