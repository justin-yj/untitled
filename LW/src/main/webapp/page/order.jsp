<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel="shortcut icon" href="favicon.ico"> <link href="/static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/static/css/animate.min.css" rel="stylesheet">
    <link href="/static/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       

        <!-- End Panel Sort & Hideheader -->



        <!-- Panel Other -->
        <div class="ibox float-e-margins"  style="overflow:hidden">
          
            <div class="ibox-content">
                <div class="row row-lg">
                    <div class="col-sm-12">
                        <!-- Example Events -->
                        <div class="example-wrap">
                            <h4 class="example-title">店铺信息</h4>
                            <div class="example">
                               
                                <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-heart" aria-hidden="true"></i>
                                    </button>
                                    <button type="button" class="btn btn-outline btn-default">
                                        <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                    </button>
                                </div>
                                <table id="exampleTableEvents" data-height="690" data-mobile-responsive="true">
                                    <thead>
                                        <tr>
                                            <th data-field="state" data-checkbox="true"></th>
                                            <th data-field="company_nm">公司</th>
                                            <th data-field="name">店铺名称</th>
                                            <th data-field="stco">店铺编号</th>
                                            <th data-field="shop_type">店铺类型</th>
                                            <th data-field="open_date">开店日</th>
                                            <th data-field="close_date">闭店日</th>
                                            <th data-field="address">地址</th>
                                            <th data-field="tel">电话</th>
                                            <th data-field="business_time">营业时间</th>
                                            <th data-field="business">状态</th>
                                            <th data-field="area_nm">区域</th>
                                            <th data-field="location">立地</th>
                                            <th data-field="sv_name">sv</th>
                                            <th data-field="edit">操作</th>
                                        </tr>
                                    </thead>
                                    <c:forEach var="shopMsg" items="${shopMsg}" varStatus="status">
                                        <tr>
                                            <td></td>
                                            <td>${shopMsg.company_nm}</td>
                                            <td>${shopMsg.name}</td>
                                            <td>${shopMsg.stco}</td>
                                            <td>${shopMsg.shop_type}</td>
                                            <td><fmt:formatDate value="${shopMsg.open_date}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                                            <td><fmt:formatDate value="${shopMsg.close_date}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                            <td>${shopMsg.address}</td>
                                            <td>${shopMsg.tel}</td>
                                            <td>${shopMsg.start_time}-${shopMsg.end_time}</td>
                                            <td>${shopMsg.business}</td>
                                            <td>${shopMsg.area_nm}</td>
                                            <td>${shopMsg.location}</td>
                                            <td>${shopMsg.sv_name}</td>
                                            <td>
                                                <button class="btn btn-sm btn-primary pull-left m-t-n-xs" type="submit" onclick="openDialog('会员编辑','${contentPath}/editMember','700px','420px')"><strong>编 辑</strong></button>
                                                <button class="btn btn-sm btn-primary-del pull-left m-t-n-xs" type="submit" onclick="delMember('${members.id}')" style="margin-left:10px;"><strong>删 除</strong></button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                        <!-- End Example Events -->
                    </div>
                </div>
            </div>
        </div>
        <!-- End Panel Other -->
    </div>
    <script src="/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/static/js/content.min.js?v=1.0.0"></script>
    <script src="/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="/static/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="/static/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="/static/js/demo/bootstrap-table-demo.min.js"></script>


</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:06 GMT -->
</html>
