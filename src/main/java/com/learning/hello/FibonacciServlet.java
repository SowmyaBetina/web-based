
package com.learning.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FibonacciServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Map<String, String[]> parameterMap = req.getParameterMap();
            parameterMap.entrySet().forEach(entry -> {
                System.out.print("key: " + entry.getKey());
                System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
            });

            PrintWriter out = resp.getWriter();
            String val = parameterMap.get("n")[0];
            int limit = Integer.parseInt(val);
            int n1 = 0, n2 = 1, n3, i;
            int count = limit;

            //out.println("<html><body><h2>Fibonacci Series:</h2>");
            out.print(n1 + " " + n2);

            for (i = 2; i < count; ++i) {
                n3 = n1 + n2;
                out.print(" " + n3);
                n1 = n2;
                n2 = n3;
            }

            //out.println("</body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
package com.learning.hello;

 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

 

/**
* Servlet implementation class FibonacciServlet
*/
/*
@WebServlet("/FibonacciServlet")
public class FibonacciServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Fibonacci Calculator</h2>");
        out.println("<form method=\"post\">");
        out.println("Number of Fibonacci numbers: <input type=\"text\" name=\"count\"><br>");
        out.println("<input type=\"submit\" value=\"Generate\">");
        out.println("</form>");
        out.println("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String countStr = request.getParameter("count");
        int n = 10;

        if(!countStr.isEmpty())
        n = Integer.parseInt(countStr);

        out.println("<html> <body>");
        out.println("<h2>Fibonacci Sequence</h2>");
        out.println("<p>Generating the first " + n + " Fibonacci numbers:</p>");

        long[] fib = new long[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        for (int i = 0; i < n; i++) {
            out.print(fib[i] + " , ");
        }

        out.println("</body></html>");
    }
}
*/