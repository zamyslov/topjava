var ajaxUrl = "ajax/admin/users/";
var datatableApi;

// $(document).ready(function () {
$(function () {
    datatableApi = $("#datatable").DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "email"
            },
            {
                "data": "roles"
            },
            {
                "data": "enabled"
            },
            {
                "data": "registered"
            },
            {
                "defaultContent": "Edit",
                "orderable": false
            },
            {
                "defaultContent": "Delete",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "asc"
            ]
        ]
    });
    makeEditable();
});

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

function enabled() {
    var id = $('tr[id]').attr("id");
    var checked = $('#isEnabled').is(":checked");
    $.ajax({
        url: ajaxUrl + id,
        type: "POST",
        data: {
           'checked': checked
        },
        success: function () {
            updateTable();
            if (checked) {
                successNoty("Enabled");
            } else {
                successNoty("Disable");
            }
        }
    });
}