<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title></title>
    <%@ include file="../static/include/taglib.jsp"%>
    <jsp:include page="${pageContext.request.contextPath}/static/include/head.jsp"/>
</head>
<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="col-sm-12">
        <!-- Example Events -->
        <div class="example-wrap">
            <h4 class="example-title">会员</h4>
            <div class="example">
                <div class="alert alert-success" role="alert">
                    会员信息
                </div>
                <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                    <button type="button" class="btn btn-outline btn-default">
                        <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                    </button>
                    <!--   <button type="button" class="btn btn-outline btn-default">
                           <i class="glyphicon glyphicon-heart" aria-hidden="true"></i>
                       </button>
                       -->
                    <button type="button" class="btn btn-outline btn-default">
                        <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                    </button>
                </div>
                <table id="exampleTableEvents" data-height="700" data-mobile-responsive="true">
                    <%--<thead>
                    <tr>
                        <th data-field="state" data-checkbox="true"></th>
                        <th data-field="id">ID</th>
                        <th data-field="name">会员名称</th>
                        <th data-field="phone">手机号码</th>
                        <th data-field="address">地址</th>
                        <th data-field="birthday">生日</th>
                        <th data-field="sex">性别</th>
                        <th data-field="insdate">注册日期</th>
                        <th datat-field="edit">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>--%>
                </table>

            </div>

        </div>

        <!-- End Example Events -->
    </div>
</div>
</div>
</div>


</body>

<script type="text/javascript">


    $(function () {
        $("#exampleTableEvents").bootstrapTable({
            url:'${contentPath}/findMembers',
            dataType: "json",
            striped: true,//row color
            cache: false,
            undefinedText: "-",
            sortName: "serviceId",
            sortOrder: "asc",
            pagination: true,
            sidePagination: "server",
            toolbar: "#toolbar",
            pageNumber:1,
            pageSize:5,
            pageList:[5,10,25,50],
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            columns: [{
                checkbox: true
            }, {
                field: "id",
                title: "id",
                align: 'center'
            },{
                field: 'serviceId',
                title:'操作',
                align:'center',
                formatter:function(value,row,index){
                    var serviceId = row.serviceId;
                    var a = '<a href="/service/csServiceAction_goCsServiceJsp.action?csService.serviceId='+serviceId+'" class="cs_menuTab">编辑</a>';
                    return a;
                }
            }]
        });
    });


    /*$(function () {
        findList(null);
    })*/
    function findList(name){
        var page = {"pageNo":1}
        var parm = {"page":page,"name":name}
        $.ajax({
            type: "post",
            dataType: "json",
            contentType : "application/json",
            url: '${contentPath}/findMembers',
            data:JSON.stringify(parm),
            success: function (data) {
                console.log(data)
                var html = template('dataList', data);
                $("#exampleTableEvents").find("tbody").html(html);
            }
        });

    }

    function delMember(memberId){
        layer.msg('是否删除该用户？', {
            time: 20000, //20s后自动关闭
            btn: ['删除', '取消'],
            yes: function(index, layero){
                //按钮【按钮一】的回调
                console.log('删除该用户'+memberId);
                alert(memberId);
                var data={id:memberId};
                console.log(data);
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: '${contentPath}/delMemberById',
                    contentType : "application/json",
                    data: JSON.stringify(data),
                    success: function (msg) {
                        console.log(msg);
                        if(msg.status==0){
                            layer.msg(msg.message);
                            window.location.reload()
                        }else {
                            layer.msg(msg.message);
                        }
                    }
                });
                layer.close(index);
            }
        });
    }
</script>
<script id="dataList" type="text/html">

    {{each data as data}}
    <tr>
        <th data-field="state" data-checkbox="true"></th>
        <td>{{data.id}}</td>
        <td>{{data.name}}</td>
        <td>{{data.mobile}}</td>
        <td>{{data.address}}</td>
        <td>{{data.birthday}}</td>
        <td>{{data.sex}}</td>
        <td>{{data.createDate}}</td>
        <td>
            <button class="btn btn-sm btn-primary pull-left m-t-n-xs" type="submit" onclick="openDialog('会员编辑','${contentPath}/editMember','700px','420px')"><strong>编 辑</strong></button>
            <button class="btn btn-sm btn-primary-del pull-left m-t-n-xs" type="submit" onclick="delMember('{{data.id}}')" style="margin-left:10px;"><strong>删 除</strong></button>
        </td>
    </tr>
    {{/each}}

</script>

<jsp:include page="${pageContext.request.contextPath}/static/include/boot.jsp"/>
</html>
