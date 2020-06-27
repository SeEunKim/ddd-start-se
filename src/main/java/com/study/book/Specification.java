package com.study.book;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.function.Predicate;

public interface Specification<T> {
    Predicate toPredicate(Root<T> root, CriteriaBuilder cb);

}
