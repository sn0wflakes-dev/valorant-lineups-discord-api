package sn0w.discord.api.adapter.inbound.rest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        return checkDateFormat(value);
    }

    private Boolean checkDateFormat(String value) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd-MM-yyyy");

        try {
            LocalDate.parse(value, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
