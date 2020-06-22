package com.study.book;

import java.util.Collections;
import java.util.HashSet;

public class EmailSet {
    private Set<Email> emails = new HashSet<>();

    private EmailSet() {}
    private EmailSet(Set<Email> emails) {
        this.emails.addAll(emails);
    }

    public Set<Email> getEmails() {
        return Collections.unmodifiableSet(emails);
    }
}
