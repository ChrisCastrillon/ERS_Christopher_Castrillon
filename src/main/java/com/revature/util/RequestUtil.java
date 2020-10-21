package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    
    public static String readBody(HttpServletRequest req) throws IOException {
        BufferedReader reader = req.getReader();
        String body = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        return body;
    }

}
