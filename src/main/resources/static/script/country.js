/*<![CDATA[*/
    function retrieveAirlines() {
        // required by Spring Security
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");
        $.ajax({
            url: '/airline/airlines?countryId=' + $('#countrySelect option:selected').val(),
            type: 'get',
            contentType: 'application/json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (result) {
                var $dropdown = $("#airlineSelect");
                var $id = $("#airlineId");
                $dropdown.empty();
                $.each(result, function() {
                    $dropdown.append($("<option />").val(this.id).text(this.airlineName));
                });
            },
            error: function () {
                // what do you want to do in case of error
            }
        });
    }
/*]]>*/
