package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Delegate {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
