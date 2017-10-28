/**
 * Created by lenovo on 2017/9/15.
 */
$(function () {
    $("li:eq(4)").click(function () {
        $.ajax({
            type:"POST",
            url:"${path}/departments",
            dataType:"json",
            success:function (data) {
                var data=JSON.parse(data);
                var $table=$('<table class="table table-bordered"></table>');
                for(var i=0;i<data.total;i++){
                    var $tr=$('<tr></tr>');
                    var $td1=$('<td>'+data[i].id+'</td>');
                    var $td2=$('<td>'+data[i].departmentName+'</td>');
                    var $td3=$('<td>'+data[i].phone+'</td>');
                    var $td4=$('<td>'+data[i].state+'</td>');
                    $tr.append($td1).append($td2).append($td3).append($td4);
                    $table.append($tr);
                }
                $('#tex4').append($table);
            }

        })
    });

});