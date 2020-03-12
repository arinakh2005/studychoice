<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="styleform.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<%--<div class="form">--%>
<%--        <div class="name-mail">--%>
<%--            <p><b>Ваше ім'я та прізвище</b><br>--%>
<%--                <input type="text" size="40">--%>
<%--            </p>--%>
<%--            <p><b>Ваша електронна адреса:</b><br>--%>
<%--            <input type="text" size="40"></p>--%>
<%--        </div>--%>
        <div id="form1" class="form1">
            <div class="choose">
                <div class="choose-city">
                    <p><h3>Вкажіть місто, в якому ви мешкаєте</h3></p>
                    <select class="custom-select-lg" data-style="btn-secondary">
                        <c:forEach var="city" items="${cities}">
                            <option class="list-group-item-success" value="${city.id}">${city.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="choose-city"><a href="#" onclick="showAlternativeComparisonPromptModal()"><h4>Як порівнювати альтернативи</h4></a></div>
            </div>
            <div id='all-choices-container' class="choose">
            <div class="choose-university">
                <p><h3>Оберіть ЗВО</h3></p>
                <c:forEach var="university" items="${universities}">
                    <p><input type="checkbox" class="university" value="${university.id}">${university.name}</p>
                </c:forEach></div>
            <div class="choose-criterion">
                <p><h3>Оберіть критерії, які є важливими для Вас, при вступі до ЗВО</h3></p>
                <c:forEach var="criteria" items="${criterions}">
                    <p><input type="checkbox" class='criteria' name="a" value="${criteria.id}" onclick="formCriteriaComparisonView()">${criteria.name}</p>
                </c:forEach>
            </div>
        </div>
    <%--</div>--%>
            <div id="comparison"></div>

            <p><button class='get-result-button' onclick="doComparison()">Отримати результат</button></p>

<!-- The Modal -->
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="totalResult">Some text in the Modal..</p>
    </div>
</div>
<div id="criteriaPromptModal" class="modal">
    <div class="container p-3 my-3 alert alert-success">
        <span class="close">&times;</span>
        <p>1 - однакова важливість</p>
        <p>3 - перший критерій трохи важливіший за другий</p>
        <p>5 - перший критерій має суттєву перевагу над другим</p>
        <p>7 - перший критерій має значну перевагу над другим</p>
        <p>9 - перший критерій має абсолютну перевагу над другим</p>
    </div>
</div>


