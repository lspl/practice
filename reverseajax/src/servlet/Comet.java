package servlet;

/**
 * Created by lishunpu on 2017/6/23.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/longpolling", asyncSupported=true)
public class Comet extends HttpServlet {
    private static final Queue<AsyncContext> CONNECTIONS = new ConcurrentLinkedQueue<AsyncContext>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("onOpen")) {
            onOpen(req, resp);
        } else if (method.equals("onMessage")) {
            onMessage(req, resp);
        }
    }

    private void onOpen(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext context = req.startAsync();
        context.setTimeout(0);
        CONNECTIONS.offer(context);
    }

    private void onMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = req.getParameter("msg");
        broadcast(msg);
    }

    private synchronized void broadcast(String msg) {
        for (AsyncContext context : CONNECTIONS) {
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            try {
                PrintWriter out = response.getWriter();
                out.print(msg.toUpperCase());
                out.flush();
                out.close();
                context.complete();
                CONNECTIONS.remove(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}