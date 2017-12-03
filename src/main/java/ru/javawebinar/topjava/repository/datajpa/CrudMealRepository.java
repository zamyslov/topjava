package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
    @Override
    List<Meal> findAll(Sort sort);

    @Query("SELECT m from Meal m where m.user.id=:userid and m.id=:id")
    Meal getOne(Integer id, Integer userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id=:id and m.user.id =:userId")
    int delete(Integer id, Integer userId);

    Meal save (Meal meal, Integer userId);

    @Query("SELECT m from Meal m where m.user.id=:userid and m.dateTime>=:startdate and m.dateTime<:enddate ORDER BY m.dateTime DESC")
    List<Meal> getBetweenOrderByDateTime(@Param("startdate")LocalDateTime startDate, @Param("enddate")LocalDateTime endDate, @Param("userid")Integer userId);
}
