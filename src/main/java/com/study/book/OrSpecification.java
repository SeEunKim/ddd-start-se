package com.study.book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class OrSpecification<T> implements Specification<T> {
    private List<Specification<T>> specs;

    public OrSpecification(Specification<T> ... specs) {
        this.specs = Arrays.asList(specs);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaBuilder cb) {
        Predicate[] predicates = specs.stream()
                .map(spec -> spec.toPredicate(root, cb))
                .toArray(Predicate[]::new);
        return cb.or(predicates);
    }
}
