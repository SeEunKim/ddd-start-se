package com.study.book;

import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

public class AndSpec<T> implements Specification<T> {
    private List<Specification<T>> specs;

    public AndSpecification(Specification<T> ... specs) {
        this.specs = Arrays.asList(specs);
    }

    public boolean isSatisfiedBy(T agg) {
        for (Specification<T> spec : specs) {
            if (!spec.isSatisfiedBy(agg)) return false;

        }
    }
}
