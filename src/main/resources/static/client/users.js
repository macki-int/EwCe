const SIZE = 5;
var page = 0;

function reloadTableUsers() {
    $.ajax({
        url: "http://localhost:8080/users?page=" + page + "&size=" + SIZE,
        method: "GET",
        dataType: "JSON",
        success: function (users) {
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

$("#table-users").on("click", "tr", function () {
    var id = $(this).find("td:first-child").text();
    getUserById(id);
});

$("#button-new").on('click', function () {
    console.log('new');
});

reloadTableUsers();