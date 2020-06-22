package com.study.book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(("II"))
public class InternalImage extends Image{
}
