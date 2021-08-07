/*<![CDATA[*/
function deleteFlight(url) {
    // required by Spring Security
    console.log(url);
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    $.ajax({
        url: url,
        type: 'get',
        contentType: 'application/json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function (result) {
            location.reload()
        },
    });
}

function deleteFunc(id) {
    if (confirm("Are you sure you want to delete this flight?")) {
        console.log("deleted");
        deleteFlight('/dashboard/delete/?id=' + id);
    } else {
    }
}
/*]]>*/
