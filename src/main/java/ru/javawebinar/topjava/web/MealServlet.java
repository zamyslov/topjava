package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.DaoFactory;
import ru.javawebinar.topjava.dao.api.Dao;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao<Integer, Meal> mealDao = DaoFactory.getInstance().getMealDao();
        if (mealDao.getAll().size() == 0) {
            log.debug("init meals");
            MealsUtil.initListMeal();
        }
        if (request.getPathInfo() != null) {
            String[] params = request.getPathInfo().split("/");
            if (params[1].equals("delete")) {
                log.debug("delete meal id = "+params[2]);
                mealDao.delete(Integer.parseInt(params[2]));
                final HttpServletRequestWrapper wrapped = new HttpServletRequestWrapper(request) {
                    @Override
                    public StringBuffer getRequestURL() {
                        final StringBuffer originalUrl = ((HttpServletRequest) getRequest()).getRequestURL();
                        return new StringBuffer("http://localhost:8080/topjava/meals");
                    }
                };
                request.getServletContext().getRequestDispatcher("/meals").forward(wrapped, response);
            }
        }else {
            log.debug("redirect to meals");
            List<MealWithExceed> mealsWithExceeded =
                    MealsUtil.getFilteredWithExceeded(mealDao.getAll(), LocalTime.MIN, LocalTime.MAX, 2000);
            request.setAttribute("mealsWithExceededList", mealsWithExceeded);
            request.getRequestDispatcher("meals.jsp").forward(request, response);
        }

    }
}
