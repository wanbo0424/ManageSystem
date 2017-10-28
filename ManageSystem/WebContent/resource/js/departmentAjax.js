/**
 * Created by lenovo on 2017/9/14.
 */
$(function () {
    $("ul li:last-child").click(function () {
        $.ajax({
            type:"POST",
            url:"/ManageSystem/src/cn/MS/service/serviceIm/DepartmentServiceIm.java",
            dataType:"json",
            success:function (data) {
                var data=JSON.parse(data);
                var $table=$('<table class="table table-striped"></table>');
                for(var i=0;i<total;i++){
                    var $tr=$('<tr></tr>');
                    var $td1=$('<td>'+data[i].id+'</td>');
                    var $td2=$('<td>'+data[i].departmentName+'</td>');
                    var $td3=$('<td>'+data[i].phone+'</td>');
                    var $td4=$('<td>'+data[i].state+'</td>');
                    var $ap=$('<td><button type="button" class="btn btn-success btn-sm" contenteditable="true" onclick="modify('+data[i]+')">'+修改+'</button><button  type="button" class="btn btn-danger btn-sm" contenteditable="true" onclick="remove('+i+')">'+删除+'</button></td>');

                    $tr.append($td1).append($td2).append($td3).append($td4).append($ap);
                    $("#tab5").append($tr);
                }
            }
        })
    })
    //部门信息的修改功能
    function modify(data) {
        $("#user").append(data.departmentName);
        $("#phone").append(data.phone);
        $("#state").append(data.state);
    }
//    部门信息的删除功能
    function remove(i) {
        var $romovetr=$("#tab5>tr")[i];
        $removetr.romove();
    }

});