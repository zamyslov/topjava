var ajaxUrl = "ajax/profile/meals/";
var datatableApi;

// $(document).ready(function () {
$(function () {
    datatableApi = $("#datatable").DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "dateTime"
            },
            {
                "data": "description"
            },
            {
                "data": "calories"
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

// function updateFilter(data) {
//     datatableApi.clear().rows.add(data).draw();
// }

function updateTable() {
    $.ajax({
        url: ajaxUrl + "filter",
        type: "POST",
        data: $("#filterForm").serialize(),
        success: updateTableByData
    });
}

function cleanFilter() {
    $("#filterForm")[0].reset();
    updateTable();
}

