package lk.pdn.scs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {

        String x= req.getParameter("url");

        PrintWriter out = res.getWriter();
        out.print("URL : "+x);
    }
}