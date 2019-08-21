const PAGE_SIZE = 5;
var currentPage = 0;
var totalPages = 0;


function reloadTableUsers() {
    $.ajax({
        url: "http://localhost:8080/users?page=" + currentPage + "&size=" + PAGE_SIZE,
        method: "GET",
        dataType: "JSON",
        success: function (users) {

            reloadPaginationTableUsers(users);

            const $trUserTemplate = $("#tr-user-template");
            const $tbody = $("tbody");
            $tbody.children("tr:not(#tr-user-template)").remove();

            for (let i = 0; i < users.content.length; i++) {
                const user = users.content[i];
                const $trUser = $trUserTemplate.clone();
                $trUser.removeAttr("id");
                $trUser.children(".td-user-id").text(user.id);
                $trUser.children(".td-user-first-name").text(user.firstName);
                $trUser.children(".td-user-last-name").text(user.lastName);
                $trUser.children(".td-user-login-name").text(user.loginName);
                $trUser.children(".td-user-role").text(user.role);
                $tbody.append($trUser);
            }
        }
    });

}

function getUserById(id) {
    $.ajax({
        url: "http://localhost:8080/users/" + id,
        method: "GET",
        dataType: "JSON",
        success: function (user) {
            $("#input-id").val(user.id);
            $("#input-first-name").val(user.firstName);
            $("#input-last-name").val(user.lastName);
            $("#input-login").val(user.loginName);
            $("#input-role").val(user.role);
        }
    });
}

function reloadPaginationTableUsers(users){
    if (users.totalPages > 1){
        totalPages = users.totalPages;
        currentPage = users.number;

                var options = {
                    currentPage: currentPage,
                    totalPages: totalPages,
                    shouldShowPage:function(type, page, current){
                        switch(type)
                        {
                            case "first":
                            case "last":
                                return false;
                            default:
                                return true;
                        }
                    }
                }

    }

}

$('#pagination').bootstrapPaginator(options);


$("#table-users").on("click", "tr", function () {
    var id = $(this).find("td:first-child").text();
    getUserById(id);
});

$("#button-new").on("click", function () {
    console.log("new");
});

$("#button-update").on("click", function () {
    console.log("update");
});

$("#button-delete").on("click", function () {
    console.log("delete");
});

reloadTableUsers();