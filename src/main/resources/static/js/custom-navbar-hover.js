$('.navbar-list-element a').hover(function (ev) {
    if ($(ev.target).hasClass('custom-hover-out')) {
        $(ev.target).removeClass('custom-hover-out')
    }

    if (!$(ev.target).hasClass('custom-hover-in')) {
        $(ev.target)
            .addClass('custom-hover-in');
    }
});

$('.navbar-list-element a').mouseleave(function (ev) {
    $(ev.target)
        .removeClass('custom-hover-in')
        .addClass('custom-hover-out');
});