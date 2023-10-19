<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous" defer></script>
                <script src="https://kit.fontawesome.com/e136359f35.js" crossorigin="anonymous" defer></script>
            </head>

            <body>
                <div class="container">
                    <header class="row bg-light p-3">
                        <div class="text-center">
                            <h3 class="text-capitalize">SEARCH AND PAGE - DSL</h3>
                        </div>
                    </header>

                    <form action="/product/search-and-page-dsl" method="post">
                        <div class="mb-3">
                            <input class="form-control" type="text" name="keywords" placeholder="Search..." value="${keywords}">
                        </div>
                        <button type="submit" class="btn btn-success">Search</button>
                    </form>

                    <hr>

                    <jsp:include page="_table_2.jsp"></jsp:include>
                </div>
            </body>

            </html>