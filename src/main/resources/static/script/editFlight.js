/*<![CDATA[*/
function editFlight(url) {
    // required by Spring Security
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
            location.href = url;
        },
    });
}

function editFunc(id) {
    if (confirm("Are you sure you want to edit this flight?")) {
            editFlight('/dashboard/edit/?id=' + id);
    } else {
    }
}
/*]]>*/
