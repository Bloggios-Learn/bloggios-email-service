package com.bloggios.email.rules;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules
 * Created_on - May 06 - 2024
 * Created_at - 16:50
 */

@FunctionalInterface
public interface Exhibitor<A> {

    void exhibit(A a);
}
