package ru.javawebinar.topjava.util.formatter;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeFormatter implements Formatter<LocalTime> {

    @Override
    public LocalTime parse(String s, Locale locale) throws ParseException {
        return StringUtils.isEmpty(s) ? null : LocalTime.parse(s);
    }

    @Override
    public String print(LocalTime localTime, Locale locale) {
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

}
