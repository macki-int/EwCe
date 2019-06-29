function reloadTableUsers() {
    $.ajax({
        url: "http://localhost:8080/users",
        method: "get",
        success: function (users) {
            const $trUserTemplate = $("#tr-user-template");
            const $tbody = $("tbody");
            // $tbody.children("tr:not(#tr-user-template)").remove();
            for (let i = 0; i < users.length; i++) {
                const user = users[i];
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

reloadTableUsers();