package ch.heigvd.cld.lab;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "DatastoreWrite", value = "/datastorewrite")
public class DatastoreWrite extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        pw.println("Writing entity to datastore.");

        Enumeration<String> parameters = req.getParameterNames();
        String _kind = "";
        String _key = "";
        Map<String, String> otherParameters = new HashMap<>();
        while(parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();

            switch(parameter) {
                case "_kind":
                    _kind = req.getParameter(parameter);
                    break;
                case "_key":
                    _key = req.getParameter(parameter);
                    break;
                default:
                    otherParameters.put(parameter, req.getParameter(parameter));
            }
        }

        if(_kind.isEmpty())
            throw new IOException("The kind is mandatory!");

        pw.println("The entity to store is");
        pw.println("Kind: " + _kind);
        pw.println("Key: " + _key);
        otherParameters.forEach((parameter, value) -> pw.println(parameter + ": " + value));

        // If the key already exists, we update the values by overwritting the old values
        Entity entity;
        if(_key.isEmpty())
            entity = new Entity(_kind);
        else
            entity = new Entity(_kind, _key);

        pw.println("\nSaving the entity...");
        otherParameters.forEach(entity::setProperty);

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(entity);

        pw.println("\nEntity is saved ! :D");

        // src : http://tutorials.jenkov.com/java-io/printwriter.html
        // The sample given does not close the PrintWriter, but we thought we sould do it :)
        pw.close();
    }
}
