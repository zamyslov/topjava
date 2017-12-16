package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;

@Controller
@RequestMapping(value = "/meals")
public class MealRestController extends AbstractMealController {

    @Autowired
    public MealRestController(MealService service) {
        super.service = service;
    }

    @Autowired
    UserService userService;

    @GetMapping("/{id}/delete")
    public String getDelete(@PathVariable int id, Model model) {
        super.delete(id);
        model.addAttribute("meals", super.getAll());
        return "redirect:/meals";
    }

    @GetMapping
    public String getAllMeal(Model model, HttpServletRequest request) {
        if (request.getParameter("meals") == null) {
            model.addAttribute("meals", super.getAll());
        }
        return "meals";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        Meal newMeal = new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 500);
        model.addAttribute("meal", newMeal);
        return "mealForm";
    }

    @GetMapping("/{id}/update")
    public String getUpdate(@PathVariable int id, Model model) {
        model.addAttribute("meal", super.get(id));
        return "mealForm";
    }

    @PostMapping("/save")
    public String postSave(HttpServletRequest request) {
        super.create(new Meal(LocalDateTime.parse(request.getParameter("dateTime"))
                , request.getParameter("description")
                , Integer.valueOf(request.getParameter("calories"))));
        return "redirect:/meals";
    }

    @PostMapping("/{id}/save")
    public String postSaveUpdated(@PathVariable int id, HttpServletRequest request) {
        Meal newMeal = super.get(id);
        newMeal.setCalories(Integer.valueOf(request.getParameter("calories")));
        newMeal.setDescription(request.getParameter("description"));
        newMeal.setDateTime(LocalDateTime.parse(request.getParameter("dateTime")));
        newMeal.setUser(userService.get(AuthorizedUser.id()));
        super.update(newMeal);
        return "redirect:/meals";
    }

    @PostMapping("/filter")
    public String postGetBetween(Model model, HttpServletRequest request) {
        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
        LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
        LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
        model.addAttribute("meals", super.getBetween(startDate, startTime, endDate, endTime));
        return "meals";
    }
}