function test() {
    // let xhr = new XMLHttpRequest();
    // xhr.onreadystatechange = function() {
    //     if (this.readyState == 4 && this.status == 200) {
    //         let city = JSON.parse(this.responseText);
    //         document.querySelector("#city").innerHTML = city[0].name + '<br>' + city[1].name;
    //     } else
    //     if (this.readyState == 4 && this.status != 200){
    //         alert('ERROR!');
    //     }
    // };
    // xhr.open('GET', '/send', true);
    // xhr.send();
}

function doComparison() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // document.querySelector("#city").innerHTML = 'AAAAAAAAAAAAA';
            // Get the modal
            var modal = document.getElementById("myModal");
// Get the button that opens the modal
            var btn = document.getElementsByClassName("get-result-button")[0];
// Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];
// When the user clicks on the button, open the modal
            btn.onclick = function() {
                modal.style.display = "block";
            }
// When the user clicks on <span> (x), close the modal
            span.onclick = function() {
                modal.style.display = "none";
            }
// When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }

            document.querySelector('#totalResult').innerHTML = this.responseText;
        } else
            if (this.readyState == 4 && this.status != 200){
                alert('ERROR!');
        }
    };
    let url = '/send';
    let info = {
        universities: [],
        criteria: [],
        coefficients: []
    };
    let univesitiesCheckBoxes = document.querySelectorAll('input.university:checked');
    for (let universityCheckBox of univesitiesCheckBoxes) {
        info.universities.push(universityCheckBox.parentNode.innerText);
    }
    let criteriaCheckBoxes = document.querySelectorAll('input.criteria:checked');
    for (let criteriaCheckBox of criteriaCheckBoxes) {
        info.criteria.push(criteriaCheckBox.parentNode.innerText);
    }
    let coefficientComboBoxes = document.querySelectorAll('.coefficients');
    for (let coefficientComboBox of coefficientComboBoxes) {
        let n = convertCoefficientStrToNumber(coefficientComboBox.value);
        info.coefficients.push(n);
    }
    let infoJson = JSON.stringify(info);
    xhr.open('POST', url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(infoJson);
}

function convertCoefficientStrToNumber(coefficientStr) {
    if (!coefficientStr.includes('/')) {
        return +coefficientStr;
    } else {
        let numbers = coefficientStr.split('/');
        return numbers[0]/numbers[1];
    }
}

function insertChooseSection() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.querySelector("#choose").innerHTML = this.responseText;
        } else
        if (this.readyState == 4 && this.status != 200){
            alert('ERROR!');
        }
    };
    xhttp.open("GET", "/choose", true);
    xhttp.send();
}

function formCriteriaComparisonView() {
    let comboboxView = "<select class='coefficients'>" +
        "<option value='1'>" + 1 + "</option>" +
        "<option value='3'>" + 3 + "</option>" +
        "<option value='5'>" + 5 + "</option>" +
        "<option value='7'>" + 7 + "</option>" +
        "<option value='9'>" + 9 + "</option>" +
        "<option value='1/3'>" + '1/3' + "</option>" +
        "<option value='1/5'>" + '1/5' + "</option>" +
        "<option value='1/7'>" + '1/7' + "</option>" +
        "<option value='1/9'>" + '1/9' + "</option></select>";
    let comparisonView = document.querySelector('#comparison');
    comparisonView.innerHTML = '';
    let criteriaCheckBoxes = document.querySelectorAll('input.criteria:checked');
    for (let i = 0; i < criteriaCheckBoxes.length-1; i++) {
        for (let j = i+1; j < criteriaCheckBoxes.length; j++) {
            comparisonView.innerHTML += '<p>' + (criteriaCheckBoxes[i].parentNode.innerText + ' -> '
                + criteriaCheckBoxes[j].parentNode.innerText) + "        " + comboboxView + '</p>';
        }
    }
}

