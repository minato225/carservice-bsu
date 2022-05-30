<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="${sessionScope.localisation}" scope="session"/>
<fmt:setBundle basename="localisation.localisedtext"/>

<footer class="footer title-regular-14">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown dropup">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-expanded="false">
                        ${sessionScope.localisation}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item"
                           href="./controller?command=change_localisation&localisation=en">en</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item"
                           href="./controller?command=change_localisation&localisation=ru">ru</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <marquee behavior="alternate" direction="left" bgcolor="#7f8"> Doskoch &copy</marquee>
</footer>