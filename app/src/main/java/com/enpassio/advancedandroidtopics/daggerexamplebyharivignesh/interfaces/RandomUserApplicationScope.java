package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Abhishek Raj on 12/18/2018.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface RandomUserApplicationScope {

}
