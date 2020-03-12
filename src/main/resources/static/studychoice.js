function doComparison() {
    let info = readInputData();
    let criteriaWeights = calculateWeights(info.coefficients);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // document.querySelector("#city").innerHTML = 'AAAAAAAAAAAAA';
            // Get the modal
            let modal = document.getElementById("myModal");
// Get the <span> element that closes the modal
            let span = document.getElementsByClassName("close")[0];
            span.onclick = function() {
                modal.style.display = "none";
            }
// When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
            let data = JSON.parse(this.responseText).data;
            let alternativesWeights = new Array(data.length);
            for (let i = 0; i < data.length; i++) {
                alternativesWeights[i] = calculateWeights(data[i]);
            }
            let resultWeights = calculateResult(criteriaWeights, alternativesWeights);
            outputResult(resultWeights, info.universityNames);
            modal.style.display = "block";
        } else
            if (this.readyState == 4 && this.status != 200){
                alert('ERROR!');
        }
    };
    let url = '/criteria-comparison';
    xhr.open('GET', url+'?criteriaIds='+info.criteria+'&universityIds='+info.universities, true);
    xhr.send();
}

function readInputData() {
    let info = {
        universityNames: [],
        universities: [],
        criteria: [],
        coefficients: []
    };
    let universitiesCheckBoxes = document.querySelectorAll('input.university:checked');
    for (let universityCheckBox of universitiesCheckBoxes) {
        info.universities.push(universityCheckBox.value);
        info.universityNames.push(universityCheckBox.parentNode.innerText);
    }
    let criteriaCheckBoxes = document.querySelectorAll('input.criteria:checked');
    for (let criteriaCheckBox of criteriaCheckBoxes) {
        info.criteria.push(criteriaCheckBox.value);
    }
    let coefficientComboBoxes = document.querySelectorAll('.coefficients');
    let k = 0;
    let n = criteriaCheckBoxes.length;
    info.coefficients = new Array(n);
    for(let i = 0; i < n; i++) {
        info.coefficients[i] = new Array(n);
        info.coefficients[i][i] = 1;
    }
    for(let i = 0; i < n; i++) {
        for(let j = i+1; j < n; j++) {
            info.coefficients[i][j] = convertCoefficientStrToNumber(coefficientComboBoxes[k].value);
            info.coefficients[j][i] = 1.0/convertCoefficientStrToNumber(coefficientComboBoxes[k++].value);
        }
    }
    return info;
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

function outputResult(resultWeights, alternatives) {
    let resultRow = document.querySelector('#result_row_0');
    let resultInputs = resultRow.getElementsByTagName('input');
    resultInputs[0].value = alternatives[0];
    resultInputs[1].value = resultWeights[0].toFixed(3);
    for (let i = 1; i < alternatives.length; i++) {
        let newRow = document.createElement('tr');
        newRow.innerHTML = resultRow.innerHTML;
        resultInputs = newRow.getElementsByTagName('input');
        resultInputs[0].value = alternatives[i];
        resultInputs[1].value = resultWeights[i].toFixed(3);
        resultRow.parentNode.append(newRow);
    }
}

function calculateWeights(compr,/*значення матриці порівнянь*/){
    let n = compr.length;
    let weights = new Array(n); //значення ваг
    let rationing = 0; //змінна для нормування на одиницю
    let coherence = new Array();

    //розраховуємо ваги
    for(let i = 0; i < n; i++){
        let res = 1;
        for(let j = 0; j < n; j++){
            res *= compr[i][j];
        }

        weights[i] = Math.pow(res, 1/n);
        rationing += weights[i];
    }

    for(let i = 0; i < n; i++){
        weights[i] /= rationing;
    }

    coherence[0] = n; //Dim
    coherence[1] = 0;

    //розраховуємо Lmax
    for(let i = 0; i < n; i++){
        let summ = 0;
        for(let j = 0; j < n; j++){
            summ +=  compr[j][i];
        }
        coherence[1] += summ * weights[i];
    }

    coherence[2] =  (coherence[1] - n)/(n - 1); //CI - ІО
    // if(N > 2){
    // 	coherence[3] = coherence[2]/n[N - 1]; //OC - ВО
    // }
    return weights;
}

function calculateResult(weights_purpose, weights_alt){
    var total_weights = [];
    var transpose_weights_alt = [];

    //транспоніємо матрицю ваг альтернатив

    var n = weights_alt.length; //кількість рядків матриці
    var m = weights_alt[0].length; //кількість стовпців матриці

    for(var i = 0; i < m; i++){
        transpose_weights_alt[i] = new Array();
        for(var j = 0; j < n; j++){
            transpose_weights_alt[i][j] = weights_alt[j][i];
        }
    }
    //розраховуємо підсумкові ваги
    for(var i = 0; i < transpose_weights_alt.length; i++){
        var summ = 0;
        for(var j = 0; j < transpose_weights_alt[i].length; j++){
            summ += transpose_weights_alt[i][j]*weights_purpose[j];
        }
        total_weights.push(summ);
    }
    return total_weights;
}

// function scroll(){
//      let target = $(this).data('target');
//      let pos = $(target).offset().top;
//      $('html, body').animate({'scrollTop': pos - 100}, 400);
//  }

