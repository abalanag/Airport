/*<![CDATA[*/
    function retrieveAirports() {
        // required by Spring Security

        $.ajax({
            url: '/countries/airports?countryId=' + $('#countrySelect option:selected').val(),
            type: 'get',
            contentType: 'application/json',

            success: function (result) {
                var $dropdown = $("#airportSelect");
                var $id = $("#airportId");
                $dropdown.empty();
                $.each(result, function() {
                    $dropdown.append($("<option/>").val(this.id).text(this.name));

                });
            },
            error: function () {
                // what do you want to do in case of error
            }
        });
    }
/*]]>*/
