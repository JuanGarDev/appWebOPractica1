<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Datos Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <article id="datos">
            <div class="contenedor">
                <h5><jsp:getProperty name="usuarioBean" property="usuario"/></h5>
            </div>
        </article>

    </body>
</html>
