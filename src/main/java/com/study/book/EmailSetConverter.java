package com.study.book;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet emailSet) {
        if (emailSet == null) {
            return null;
        }

        return emailSet.getEmails().stream()
                .map(Email::tostring)
                .collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        String[] emails = s.split(",");
        Set<Email> emailSet = Arrays.stream(emails)
                .map(value -> new Email(value))
                .collect(toSet());
        return new EmailSet(emailSet);
    }
}
