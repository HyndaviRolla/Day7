package com.learning.hello;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
public class FibonacciServlet extends HttpServlet{
 
 private static final long serialVersionUID = 1L;


 private static int fibonacci(int n) {
   if (n == 0) {
     return 1;
   } else if (n == 1) {
     return 1;
   } else {
     return fibonacci(n-1) + fibonacci(n-2);
   }
 }

 private static List<Integer> fibonaccis(int n) {
   return IntStream.range(0, n + 1).mapToObj(x -> fibonacci(x)).collect(Collectors.toList());
 }
 
@Override
 public void doGet(HttpServletRequest req, HttpServletResponse resp) {
   try {
 
     PrintWriter out = resp.getWriter();
     int value = Integer.valueOf(req.getParameter("n"));
     out.println("<h1>fibonacci</h1>");
     out.println(String.format("<p>%s</p>", fibonaccis(value)));
   }
   catch (IOException e) {
     
     e.printStackTrace();
   }
 }
 
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  PrintWriter out = response.getWriter();
  if (request.getParameter("formLimit") == null) {
    out.println("This is not the way to access this resource. Please give a value for the parameter 'n' in your query ");
    return;
  } else {
    int limit = Integer.valueOf(request.getParameter("formLimit"));
    out.println(String.format("<p>%s</p>", fibonaccis(limit)));
  }
}
}
