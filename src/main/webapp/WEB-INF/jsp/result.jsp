<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="last-step">
    <div style="">
        <h3 class="block-title block-title-no-margin text-center">Результат <small><span class="text-default"></span>Мета: Вибір ЗВО для вступу</small></h3>
        <br><br>
        <div class="row">
            <div class="col-lg-4 col-md-6 col-sm-10">
                <div class="table-responsive space-bottom-1x">
                    <table class="table-responsive" id="table-result">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Альтернативи</th>
                            <th>Вага</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td class="td-no-padding">
                                <input value="Львівський національний університет" id="result_0" readonly="" required="" class="form-control input-no-margin">
                            </td>
                            <td class="td-no-padding">
                                <input name="result_weights_0" value="0.216" id="result_weights_0" readonly="" required="" class="form-control input-no-margin text-center">
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td class="td-no-padding">
                                <input value="Національний технічний університет Київський політехнічний інститут" id="result_1" readonly="" required="" class="form-control input-no-margin"></td>
                            <td class="td-no-padding">
                                <input name="result_weights_1" value="0.418" id="result_weights_1" readonly="" required="" class="form-control input-no-margin text-center"></td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td class="td-no-padding">
                                <input value="Черкаський державний технологічний університет" id="result_2" readonly="" required="" class="form-control input-no-margin">
                            </td>
                            <td class="td-no-padding">
                                <input name="result_weights_2" value="0.366" id="result_weights_2" readonly="" required="" class="form-control input-no-margin text-center">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-lg-8 col-md-6 col-sm-12">
                <div id="chartdiv" style="width: 100%; height: 300px; overflow: hidden; text-align: left;"><div class="amcharts-main-div" style="position: relative;">
                    <div class="amcharts-chart-div" style="overflow: hidden; position: relative; text-align: left; width: 750px; height: 300px; padding: 0px;">
                        <svg version="1.1" style="position: absolute; width: 750px; height: 300px; top: -0.243042px; left: 0.204895px;">
                            <desc>JavaScript chart by amCharts 3.21.15</desc>
                            <g>
                                <path cs="100,100" d="M0.5,0.5 L749.5,0.5 L749.5,299.5 L0.5,299.5 Z" fill="#FFFFFF" stroke="#000000" fill-opacity="0" stroke-width="1" stroke-opacity="0"></path>
                            </g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g></g>
                            <g><g aria-label="Черкаський державний технологічний університет: 36.60% 0.366 ">
                                <path cs="1000,1000" d=" M375,157.5 L304.8815323301269,199.45874764835787 A94,63,0,0,1,375,94.5 L375,157.5 Z" fill="#6a924e" stroke-opacity="0" fill-opacity="1" transform="translate(0,0)"></path>
                                <path cs="1000,1000" d=" M375,157.5 L304.8815323301269,199.45874764835787 A94,63,0,0,1,375,94.5 L375,157.5 Z" fill="#6a924e" stroke-opacity="0" fill-opacity="1" transform="translate(0,-10)"></path>
                                <path cs="1000,1000" d=" M375,142.5 L375,157.5 L304.8815323301269,199.45874764835787 L304.8815323301269,184.45874764835787 L375,142.5 Z" fill="#6a924e" stroke-opacity="0" fill-opacity="1"></path>
                                <path cs="1000,1000" d=" M375,79.5 L375,94.5 L375,157.5 L375,142.5 L375,79.5 Z" fill="#6a924e" stroke-opacity="0" fill-opacity="1"></path>
                                <path cs="1000,1000" d=" M375,142.5 L304.8815323301269,184.45874764835787 A94,63,0,0,1,375,79.5 L375,142.5 Z" fill="#84b761" stroke="#FFFFFF" stroke-width="2" stroke-opacity="0.4" fill-opacity="1"></path>
                                <path cs="100,100" d="M289.5,117.5 L271.5,111.5 L263.5,111.5" fill="none" stroke-opacity="0.3" stroke="#000000" visibility="visible"></path>
                            </g><g aria-label="Львівський національний університет: 21.60% 0.216 " opacity="1"><path cs="1000,1000" d=" M375,157.5 L375,94.5 A94,63,0,0,1,466.86320361541016,144.14355207491056 L375,157.5 Z" fill="#5292b0" stroke-opacity="0" fill-opacity="1" transform="translate(0,0)"></path>
                                <path cs="1000,1000" d=" M375,157.5 L375,94.5 A94,63,0,0,1,466.86320361541016,144.14355207491056 L375,157.5 Z" fill="#5292b0" stroke-opacity="0" fill-opacity="1" transform="translate(0,-10)"></path>
                                <path cs="1000,1000" d=" M375,142.5 L375,157.5 L375,94.5 L375,79.5 L375,142.5 Z" fill="#5292b0" stroke-opacity="0" fill-opacity="1"></path>
                                <path cs="1000,1000" d=" M466.86320361541016,129.14355207491056 L466.86320361541016,144.14355207491056 L375,157.5 L375,142.5 L466.86320361541016,129.14355207491056 Z" fill="#5292b0" stroke-opacity="0" fill-opacity="1"></path>
                                <path cs="1000,1000" d=" M375,142.5 L375,79.5 A94,63,0,0,1,466.86320361541016,129.14355207491056 L375,142.5 Z" fill="#67b7dc" stroke="#FFFFFF" stroke-width="2" stroke-opacity="0.4" fill-opacity="1"></path>
                                <path cs="100,100" d="M434.5,94.5 L447.5,83.5 L455.5,83.5" fill="none" stroke-opacity="0.3" stroke="#000000" visibility="visible"></path>
                            </g><g aria-label="Національний технічний університет Київський політехнічний інститут: 41.80% 0.418 ">
                                <path cs="1000,1000" d=" M375,157.5 L466.86320361541016,144.14355207491056 A94,63,0,0,1,304.8815323301269,199.45874764835787 L375,157.5 Z" fill="#caaa00" stroke-opacity="0" fill-opacity="1" transform="translate(0,0)"></path>
                                <path cs="1000,1000" d=" M375,157.5 L466.86320361541016,144.14355207491056 A94,63,0,0,1,304.8815323301269,199.45874764835787 L375,157.5 Z" fill="#caaa00" stroke-opacity="0" fill-opacity="1" transform="translate(0,-10)"></path>
                                <path cs="1000,1000" d=" M375,142.5 L375,157.5 L466.86320361541016,144.14355207491056 L466.86320361541016,129.14355207491056 L375,142.5 Z" fill="#caaa00" stroke-opacity="0" fill-opacity="1"></path>
                                <path cs="1000,1000" d=" M304.8815323301269,184.45874764835787 L304.8815323301269,199.45874764835787 L375,157.5 L375,142.5 L304.8815323301269,184.45874764835787 Z" fill="#caaa00" stroke-opacity="0" fill-opacity="1"></path>
                                <path cs="1000,1000" d=" M375,142.5 L466.86320361541016,129.14355207491056 A94,63,0,0,1,304.8815323301269,184.45874764835787 L375,142.5 Z" fill="#fdd400" stroke="#FFFFFF" stroke-width="2" stroke-opacity="0.4" fill-opacity="1"></path>
                                <path cs="100,100" d="M418.5,198.5 L427.5,210.5 L435.5,210.5" fill="none" stroke-opacity="0.3" stroke="#000000" visibility="visible"></path>
                            </g></g><g></g>
                            <g>
                                <g>
                                <text y="6" fill="#000000" font-family="Verdana" font-size="11px" opacity="1" text-anchor="start" transform="translate(459,83)" style="cursor: default;" visibility="visible">
                                    <tspan y="6" x="0">Львівський національний</tspan>
                                    <tspan y="19" x="0">університет: 21.60%</tspan>
                                </text>
                                </g>
                                <g>
                                <text y="6" fill="#000000" font-family="Verdana" font-size="11px" opacity="1" text-anchor="start" transform="translate(439,210)" style="cursor: default;" visibility="visible">
                                    <tspan y="6" x="0">Національний технічний</tspan><tspan y="19" x="0">університет Київський</tspan>
                                    <tspan y="32" x="0">політехнічний інститут: 41.80%</tspan>
                                </text>
                                </g>
                                <g>
                                    <text y="6" fill="#000000" font-family="Verdana" font-size="11px" opacity="1" text-anchor="end" transform="translate(259,111)" style="cursor: default;" visibility="visible"><tspan y="6" x="0">Черкаський державний</tspan>
                                        <tspan y="19" x="0">технологічний університет:</tspan>
                                        <tspan y="32" x="0">36.60%</tspan>
                                    </text>
                                </g>
                            </g>
                            <g></g><g></g><g></g><g><g></g></g><g></g><g></g><g></g><g></g><g></g>
                        </svg>
                        <a href="http://www.amcharts.com" title="JavaScript charts" target="_self" style="position: absolute; text-decoration: none; color: rgb(0, 0, 0); font-family: Verdana; font-size: 11px; opacity: 0.7; display: block; left: 5px; top: 5px;">JS chart by amCharts</a>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>