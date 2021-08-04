$( document ).ready(function() {
    $('.tdTime').each(function() {
        var timeAndDate = $(this).text().replace("T", " ");
        $(this).text(timeAndDate);
    });
});
