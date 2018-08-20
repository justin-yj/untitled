<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<script src="/static/js/jquery.min.js"></script>
<script src="/static/common/layer-v3.1.1/layer/layer.js"></script>

<head></head>
<script>

    function openDialog(){
        top.layer.open({
            type: 2,
            area: ['700px', '510px'],
            fixed: false, //不固定
            maxmin: true,
            content: '${contentPath}/editMember',
            btn: ['确定', '关闭']
        });
    }
</script>
<body>
    <button onclick="openDialog()">编辑</button>
</body>

</html>
