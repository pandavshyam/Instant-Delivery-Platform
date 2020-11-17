$(function () {
    $("body").addClass("js-enabled");
    $("thead input[type=checkbox]").focus(function () {
      $(this).closest(".block-label").addClass("focused");
            })
            $("thead input[type=checkbox]").focusout(function () {
                $(this).closest(".block-label").removeClass("focused");
            })
            $("input[type=checkbox]").focus(function () {
                $(this).closest("tr").addClass("focused");
            })
            $("input[type=checkbox]").blur(function () {
                    $(this).closest("tr").removeClass("focused");
                })
                /* Checkbox, set classes to apply styles */
            $("input[type=checkbox]").click(function () {
                if ($(this).closest("tr").hasClass("head")) return;
                if ($(this).is(":checked")) {
                    $(this).closest("tr").addClass("row-selected");
                    $(this).closest(".selection-button-checkbox").addClass('selected');
                }
                else {
                    $(this).closest("tr").removeClass("row-selected");
                    $(this).closest(".selection-button-checkbox").removeClass('selected');
                }
            });
            $("#toggleAll").click(function () {
                if ($(this).hasClass("all-selected")) {
                    $(this).removeClass("all-selected");
                    $("input[type=checkbox]").each(function () {
                        $(this).closest(".selection-button-checkbox").removeClass('selected');
                        $(this).closest("tr").removeClass("row-selected");
                        $(this).attr("checked", false);
                    })
                }
                else {
                    $(this).addClass("all-selected");
                    $("input[type=checkbox]").each(function () {
                        $(this).closest(".selection-button-checkbox").addClass('selected');
                        if ($(this).attr("id") != "toggleAll") $(this).closest("tr").addClass("row-selected");
                        $(this).attr("checked", true);
                    })
                }
            })
            $(".row-select tbody tr").click(function (e) {
                selectRowChange($(this));
            })
            $("input[type=checkbox]").keyup(function (e) {
                if (e.which == 13) boxPressed($(this));
            })

            function selectRowChange(row) {
                if (row.find("select").is(":focus")) return;
                if (row.hasClass("row-selected")) {
                    row.removeClass("row-selected");
                    row.find("input[type=checkbox]").first().attr("checked", false);
                    row.find(".selection-button-checkbox").first().removeClass("selected");
                }
                else {
                    row.addClass("row-selected");
                    row.find("input[type=checkbox]").first().attr("checked", true);
                    row.find(".selection-button-checkbox").first().addClass("selected");
                }
            }

            function boxPressed(cbox) {
                if (cbox.closest("select").is(":focus")) return;
                if (cbox.closest("tr").hasClass("row-selected")) {
                    cbox.closest("tr").removeClass("row-selected");
                    cbox.attr("checked", false);
                    cbox.closest("label").removeClass("selected");
                }
                else {
                    cbox.closest("tr").addClass("row-selected");
                    cbox.attr("checked", true);
                    cbox.closest("label").addClass("selected");
                }
            }
})