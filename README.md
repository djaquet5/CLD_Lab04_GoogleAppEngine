# Cloud Computing - Laboratory 04: Google App Engine

Authors : Baptiste Hardrick & David Jaquet

## Task 1: Deployment of a simple web application

- What does the sample code generated by the wizard do? Explain what you see in the **Java class files, web.xml, appengine-web.xml** and **index.jsp** files in a few sentences.

  - `HelloAppEngine.java` :

    - This file is a Servlet. With the annotation `@WebServlet`, we can see that the Servlet handle the request targetting the `/hello` URI. The server will handle only the `GET` request. The request will be handle by the `doGet` method. A text response is prepare and will contain some informations about the Java version used as shown below:

    - # TODO AJOUTER UNE IMAGE DE CA /hello !!!!

  - `web.xml` :

    - It is the deployment descriptor. This file is used by the application to define the `URLs` to map on the servlets, those that require an authentification and others informations.

      In the `web.xml`, we can a description of the classes, the ressources, the configuration of the application.
      In our case, the `web.xml` contains a `welcome-file` tag. This tag define a default file (`index.jsp`) for the application. It is the front page of our application.

    - The informations were find on the [Google Documentation](https://cloud.google.com/appengine/docs/standard/java/config/webxml?hl=fr) and the website [javatpoint](https://www.javatpoint.com/welcome-file-list).

  - `appengine-web.xml` :

    - This file is a complement to the deployment descriptor. Indeed, the applications of the App Engine use the `appengin-web.xml` file to specify some information about the application.
      In our case, we have the tags below :

      | Tag                 | Value                | Description                                                  |
      | ------------------- | -------------------- | ------------------------------------------------------------ |
      | `runtime`           | java8                | Specify the runtime environment to `Java 8`. The environments for App Engine are on `OpenJDK` |
      | `threadsafe`        | true                 | If the value is false, App Engine send requests serially to a web server. If the value is true, App Engine send requests in parallel. |
      | `system-properties` |                      | Used to define some system properties and environment variables that are set when the application is running |
      | `property`          | name = <br />value = | WUT ?! IntelliJ trouve pas les fichiers ?!                   |

      - The informations were find on the [Google Documentation](https://cloud.google.com/appengine/docs/standard/java/config/appref).

  - `index.jsp` :

    - It's the front page of our application. This fils is mainly written in `HTML` but contains some `Java` and can contains some `CSS` too. Here, the file describe the Servlets available. For now, we have only the `HelloAppEngine` automatically generated by the Google App Engine. The file use a statical method in the `HelloAppEngine` class to have the Java version, the name of the Operating System (OS) and the name of the user. You can find below a screenshot of our page :

      # TODO : AJOUTER IMAGE

