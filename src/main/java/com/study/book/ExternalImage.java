package com.study.book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EI")
public class ExternalImage extends Image{
}
